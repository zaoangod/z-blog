package z.blog.mapping.tables.records;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record15;
import org.jooq.Row15;
import org.jooq.impl.UpdatableRecordImpl;
import z.blog.mapping.tables.ARTICLE;

public class ArticleRecord extends UpdatableRecordImpl<ArticleRecord> implements Record15<Integer, String, String, String, String, String, String, String, Integer, Integer, Integer, Integer, Integer, String, Integer> {

    private static final long serialVersionUID = -679301378;

    public ArticleRecord setAid(Integer value) {
        set(0, value);
        return this;
    }

    public Integer getAid() {
        return (Integer) get(0);
    }

    public ArticleRecord setTitle(String value) {
        set(1, value);
        return this;
    }

    public String getTitle() {
        return (String) get(1);
    }

    public ArticleRecord setFlag(String value) {
        set(2, value);
        return this;
    }

    public String getFlag() {
        return (String) get(2);
    }

    public ArticleRecord setContent(String value) {
        set(3, value);
        return this;
    }

    public String getContent() {
        return (String) get(3);
    }

    public ArticleRecord setType(String value) {
        set(4, value);
        return this;
    }

    public String getType() {
        return (String) get(4);
    }

    public ArticleRecord setFormat(String value) {
        set(5, value);
        return this;
    }

    public String getFormat() {
        return (String) get(5);
    }

    public ArticleRecord setTag(String value) {
        set(6, value);
        return this;
    }

    public String getTag() {
        return (String) get(6);
    }

    public ArticleRecord setCategory(String value) {
        set(7, value);
        return this;
    }

    public String getCategory() {
        return (String) get(7);
    }

    public ArticleRecord setHistory(Integer value) {
        set(8, value);
        return this;
    }

    public Integer getHistory() {
        return (Integer) get(8);
    }

    public ArticleRecord setComment(Integer value) {
        set(9, value);
        return this;
    }

    public Integer getComment() {
        return (Integer) get(9);
    }

    public ArticleRecord setAllowComment(Integer value) {
        set(10, value);
        return this;
    }

    public Integer getAllowComment() {
        return (Integer) get(10);
    }

    public ArticleRecord setCreateTime(Integer value) {
        set(11, value);
        return this;
    }

    public Integer getCreateTime() {
        return (Integer) get(11);
    }

    public ArticleRecord setUpdateTime(Integer value) {
        set(12, value);
        return this;
    }

    public Integer getUpdateTime() {
        return (Integer) get(12);
    }

    public ArticleRecord setStatus(String value) {
        set(13, value);
        return this;
    }

    public String getStatus() {
        return (String) get(13);
    }

    public ArticleRecord setSort(Integer value) {
        set(14, value);
        return this;
    }

    public Integer getSort() {
        return (Integer) get(14);
    }

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    @Override
    public Row15<Integer, String, String, String, String, String, String, String, Integer, Integer, Integer, Integer, Integer, String, Integer> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    @Override
    public Row15<Integer, String, String, String, String, String, String, String, Integer, Integer, Integer, Integer, Integer, String, Integer> valuesRow() {
        return (Row15) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return ARTICLE.T_ARTICLE.AID;
    }

    @Override
    public Field<String> field2() {
        return ARTICLE.T_ARTICLE.TITLE;
    }

    @Override
    public Field<String> field3() {
        return ARTICLE.T_ARTICLE.FLAG;
    }

    @Override
    public Field<String> field4() {
        return ARTICLE.T_ARTICLE.CONTENT;
    }

    @Override
    public Field<String> field5() {
        return ARTICLE.T_ARTICLE.TYPE;
    }

    @Override
    public Field<String> field6() {
        return ARTICLE.T_ARTICLE.FORMAT;
    }

    @Override
    public Field<String> field7() {
        return ARTICLE.T_ARTICLE.TAG;
    }

    @Override
    public Field<String> field8() {
        return ARTICLE.T_ARTICLE.CATEGORY;
    }

    @Override
    public Field<Integer> field9() {
        return ARTICLE.T_ARTICLE.HISTORY;
    }

    @Override
    public Field<Integer> field10() {
        return ARTICLE.T_ARTICLE.COMMENT;
    }

    @Override
    public Field<Integer> field11() {
        return ARTICLE.T_ARTICLE.ALLOW_COMMENT;
    }

    @Override
    public Field<Integer> field12() {
        return ARTICLE.T_ARTICLE.CREATE_TIME;
    }

    @Override
    public Field<Integer> field13() {
        return ARTICLE.T_ARTICLE.UPDATE_TIME;
    }

    @Override
    public Field<String> field14() {
        return ARTICLE.T_ARTICLE.STATUS;
    }

    @Override
    public Field<Integer> field15() {
        return ARTICLE.T_ARTICLE.SORT;
    }

    @Override
    public Integer component1() {
        return getAid();
    }

    @Override
    public String component2() {
        return getTitle();
    }

    @Override
    public String component3() {
        return getFlag();
    }

    @Override
    public String component4() {
        return getContent();
    }

    @Override
    public String component5() {
        return getType();
    }

    @Override
    public String component6() {
        return getFormat();
    }

    @Override
    public String component7() {
        return getTag();
    }

    @Override
    public String component8() {
        return getCategory();
    }

    @Override
    public Integer component9() {
        return getHistory();
    }

    @Override
    public Integer component10() {
        return getComment();
    }

    @Override
    public Integer component11() {
        return getAllowComment();
    }

    @Override
    public Integer component12() {
        return getCreateTime();
    }

    @Override
    public Integer component13() {
        return getUpdateTime();
    }

    @Override
    public String component14() {
        return getStatus();
    }

    @Override
    public Integer component15() {
        return getSort();
    }

    @Override
    public Integer value1() {
        return getAid();
    }

    @Override
    public String value2() {
        return getTitle();
    }

    @Override
    public String value3() {
        return getFlag();
    }

    @Override
    public String value4() {
        return getContent();
    }

    @Override
    public String value5() {
        return getType();
    }

    @Override
    public String value6() {
        return getFormat();
    }

    @Override
    public String value7() {
        return getTag();
    }

    @Override
    public String value8() {
        return getCategory();
    }

    @Override
    public Integer value9() {
        return getHistory();
    }

    @Override
    public Integer value10() {
        return getComment();
    }

    @Override
    public Integer value11() {
        return getAllowComment();
    }

    @Override
    public Integer value12() {
        return getCreateTime();
    }

    @Override
    public Integer value13() {
        return getUpdateTime();
    }

    @Override
    public String value14() {
        return getStatus();
    }

    @Override
    public Integer value15() {
        return getSort();
    }

    @Override
    public ArticleRecord value1(Integer value) {
        setAid(value);
        return this;
    }

    @Override
    public ArticleRecord value2(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public ArticleRecord value3(String value) {
        setFlag(value);
        return this;
    }

    @Override
    public ArticleRecord value4(String value) {
        setContent(value);
        return this;
    }

    @Override
    public ArticleRecord value5(String value) {
        setType(value);
        return this;
    }

    @Override
    public ArticleRecord value6(String value) {
        setFormat(value);
        return this;
    }

    @Override
    public ArticleRecord value7(String value) {
        setTag(value);
        return this;
    }

    @Override
    public ArticleRecord value8(String value) {
        setCategory(value);
        return this;
    }

    @Override
    public ArticleRecord value9(Integer value) {
        setHistory(value);
        return this;
    }

    @Override
    public ArticleRecord value10(Integer value) {
        setComment(value);
        return this;
    }

    @Override
    public ArticleRecord value11(Integer value) {
        setAllowComment(value);
        return this;
    }

    @Override
    public ArticleRecord value12(Integer value) {
        setCreateTime(value);
        return this;
    }

    @Override
    public ArticleRecord value13(Integer value) {
        setUpdateTime(value);
        return this;
    }

    @Override
    public ArticleRecord value14(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public ArticleRecord value15(Integer value) {
        setSort(value);
        return this;
    }

    @Override
    public ArticleRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, Integer value9, Integer value10, Integer value11, Integer value12, Integer value13, String value14, Integer value15) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        return this;
    }

    public ArticleRecord() {
        super(ARTICLE.T_ARTICLE);
    }

    public ArticleRecord(Integer aid, String title, String flag, String content, String type, String format, String tag, String category, Integer history, Integer comment, Integer allowComment, Integer createTime, Integer updateTime, String status, Integer sort) {
        super(ARTICLE.T_ARTICLE);
        set(0, aid);
        set(1, title);
        set(2, flag);
        set(3, content);
        set(4, type);
        set(5, format);
        set(6, tag);
        set(7, category);
        set(8, history);
        set(9, comment);
        set(10, allowComment);
        set(11, createTime);
        set(12, updateTime);
        set(13, status);
        set(14, sort);
    }
}