package z.blog.service;

import lombok.extern.slf4j.Slf4j;
import org.jooq.Record;
import org.jooq.SelectJoinStep;
import z.blog.model.entity.Article;
import z.blog.model.entity.Meta;
import z.blog.model.entity.Relationship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static z.blog.bootstrap.JooqConfig.dsl;
import static z.blog.mapping.tables.ARTICLE.T_ARTICLE;
import static z.blog.mapping.tables.META.T_META;
import static z.blog.mapping.tables.RELATIONSHIP.T_RELATIONSHIP;

@Slf4j
public class MetaService {

    /**
     * 根据类型查询项目列表
     *
     * @param meta 查询参数
     */
    public List<Meta> getMeta(Meta meta) {
        log.info("-> 根据类型查询Meta列表");
        SelectJoinStep<Record> data = dsl.select().from(T_META);
        if (meta != null && meta.getMid() != null) {
            data.where(T_META.MID.eq(meta.getMid()));
        }
        if (meta != null && meta.getTitle() != null) {
            data.where(T_META.TITLE.eq(meta.getTitle()));
        }
        if (meta != null && meta.getFlag() != null) {
            data.where(T_META.FLAG.eq(meta.getFlag()));
        }
        if (meta != null && meta.getType() != null) {
            data.where(T_META.TYPE.eq(meta.getType()));
        }
        return data.fetchInto(Meta.class);
    }

    /**
     * 查询项目映射
     *
     * @param type 类型, tag or category
     */
    public Map<String, List<Article>> getMeta(String type) {

        if (type == null) {
            return new HashMap<>();
        }
        List<Meta> meta = this.getMeta(new Meta().setType(type));

        if (null != meta && meta.size() > 0) {
            return meta.stream().collect(Collectors.toMap(Meta::getTitle, this::getMetaArticle));
        } else {
            return new HashMap<>();
        }
    }

    private List<Article> getMetaArticle(Meta m) {
        List<Integer> aidList = dsl.select().from(T_RELATIONSHIP).where(T_RELATIONSHIP.MID.eq(m.getMid())).fetchInto(Relationship.class)
                .stream().map(Relationship::getAid).collect(Collectors.toList());
        if (aidList.size() == 0) {
            return new ArrayList<>();
        }
        return dsl.select(T_ARTICLE.AID, T_ARTICLE.TITLE).from(T_ARTICLE).where(T_ARTICLE.AID.in(aidList)).orderBy(T_ARTICLE.CREATE_TIME).fetchInto(Article.class);
    }
}
