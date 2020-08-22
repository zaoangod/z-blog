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

import static z.blog.bootstrap.JooqConfig.dslContext;
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
        SelectJoinStep<Record> data = dslContext().select().from(T_META);
        if (meta != null && meta.getMid() != null) {
            data.where(T_META.MID.eq(meta.getMid()));
        }
        if (meta != null && meta.getName() != null) {
            data.where(T_META.NAME.eq(meta.getName()));
        }
        if (meta != null && meta.getSlug() != null) {
            data.where(T_META.SLUG.eq(meta.getSlug()));
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
        if (type != null) {
            List<Meta> metas = this.getMeta(new Meta().setType(type));
            if (null != metas) {
                return metas.stream().collect(Collectors.toMap(Meta::getName, this::getMetaContents));
            } else {
                return new HashMap<>();
            }
        }
        return new HashMap<>();
    }

    private List<Article> getMetaContents(Meta m) {
        List<Integer> aidList = dslContext()
                .select()
                .from(T_RELATIONSHIP)
                .where(T_RELATIONSHIP.MID.eq(m.getMid()))
                .fetchInto(Relationship.class)
                .stream()
                .map(Relationship::getAid)
                .collect(Collectors.toList());
        if (aidList.size() == 0) {
            return new ArrayList<>();
        }
        return dslContext().select().from(T_ARTICLE).where(T_ARTICLE.AID.in(aidList)).orderBy(T_ARTICLE.CREATED).fetchInto(Article.class);
    }
}
