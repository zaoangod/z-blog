package z.blog.mapping.tables.records;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record12;
import org.jooq.Row12;
import org.jooq.impl.UpdatableRecordImpl;
import z.blog.mapping.tables.COMMENT;

public class CommentRecord extends UpdatableRecordImpl<CommentRecord> implements Record12<Integer, Integer, Integer, String, String, String, String, String, String, String, String, Integer> {

    private static final long serialVersionUID = -1708857500;

    public CommentRecord setCid(Integer value) {
        set(0, value);
        return this;
    }

    public Integer getCid() {
        return (Integer) get(0);
    }

    public CommentRecord setAid(Integer value) {
        set(1, value);
        return this;
    }

    public Integer getAid() {
        return (Integer) get(1);
    }

    public CommentRecord setParent(Integer value) {
        set(2, value);
        return this;
    }

    public Integer getParent() {
        return (Integer) get(2);
    }

    public CommentRecord setAuthor(String value) {
        set(3, value);
        return this;
    }

    public String getAuthor() {
        return (String) get(3);
    }

    public CommentRecord setMail(String value) {
        set(4, value);
        return this;
    }

    public String getMail() {
        return (String) get(4);
    }

    public CommentRecord setUrl(String value) {
        set(5, value);
        return this;
    }

    public String getUrl() {
        return (String) get(5);
    }

    public CommentRecord setIp(String value) {
        set(6, value);
        return this;
    }

    public String getIp() {
        return (String) get(6);
    }

    public CommentRecord setAgent(String value) {
        set(7, value);
        return this;
    }

    public String getAgent() {
        return (String) get(7);
    }

    public CommentRecord setContent(String value) {
        set(8, value);
        return this;
    }

    public String getContent() {
        return (String) get(8);
    }

    public CommentRecord setType(String value) {
        set(9, value);
        return this;
    }

    public String getType() {
        return (String) get(9);
    }

    public CommentRecord setStatus(String value) {
        set(10, value);
        return this;
    }

    public String getStatus() {
        return (String) get(10);
    }

    public CommentRecord setCreateTime(Integer value) {
        set(11, value);
        return this;
    }

    public Integer getCreateTime() {
        return (Integer) get(11);
    }

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    @Override
    public Row12<Integer, Integer, Integer, String, String, String, String, String, String, String, String, Integer> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    @Override
    public Row12<Integer, Integer, Integer, String, String, String, String, String, String, String, String, Integer> valuesRow() {
        return (Row12) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return COMMENT.T_COMMENT.CID;
    }

    @Override
    public Field<Integer> field2() {
        return COMMENT.T_COMMENT.AID;
    }

    @Override
    public Field<Integer> field3() {
        return COMMENT.T_COMMENT.PARENT;
    }

    @Override
    public Field<String> field4() {
        return COMMENT.T_COMMENT.AUTHOR;
    }

    @Override
    public Field<String> field5() {
        return COMMENT.T_COMMENT.MAIL;
    }

    @Override
    public Field<String> field6() {
        return COMMENT.T_COMMENT.URL;
    }

    @Override
    public Field<String> field7() {
        return COMMENT.T_COMMENT.IP;
    }

    @Override
    public Field<String> field8() {
        return COMMENT.T_COMMENT.AGENT;
    }

    @Override
    public Field<String> field9() {
        return COMMENT.T_COMMENT.CONTENT;
    }

    @Override
    public Field<String> field10() {
        return COMMENT.T_COMMENT.TYPE;
    }

    @Override
    public Field<String> field11() {
        return COMMENT.T_COMMENT.STATUS;
    }

    @Override
    public Field<Integer> field12() {
        return COMMENT.T_COMMENT.CREATE_TIME;
    }

    @Override
    public Integer component1() {
        return getCid();
    }

    @Override
    public Integer component2() {
        return getAid();
    }

    @Override
    public Integer component3() {
        return getParent();
    }

    @Override
    public String component4() {
        return getAuthor();
    }

    @Override
    public String component5() {
        return getMail();
    }

    @Override
    public String component6() {
        return getUrl();
    }

    @Override
    public String component7() {
        return getIp();
    }

    @Override
    public String component8() {
        return getAgent();
    }

    @Override
    public String component9() {
        return getContent();
    }

    @Override
    public String component10() {
        return getType();
    }

    @Override
    public String component11() {
        return getStatus();
    }

    @Override
    public Integer component12() {
        return getCreateTime();
    }

    @Override
    public Integer value1() {
        return getCid();
    }

    @Override
    public Integer value2() {
        return getAid();
    }

    @Override
    public Integer value3() {
        return getParent();
    }

    @Override
    public String value4() {
        return getAuthor();
    }

    @Override
    public String value5() {
        return getMail();
    }

    @Override
    public String value6() {
        return getUrl();
    }

    @Override
    public String value7() {
        return getIp();
    }

    @Override
    public String value8() {
        return getAgent();
    }

    @Override
    public String value9() {
        return getContent();
    }

    @Override
    public String value10() {
        return getType();
    }

    @Override
    public String value11() {
        return getStatus();
    }

    @Override
    public Integer value12() {
        return getCreateTime();
    }

    @Override
    public CommentRecord value1(Integer value) {
        setCid(value);
        return this;
    }

    @Override
    public CommentRecord value2(Integer value) {
        setAid(value);
        return this;
    }

    @Override
    public CommentRecord value3(Integer value) {
        setParent(value);
        return this;
    }

    @Override
    public CommentRecord value4(String value) {
        setAuthor(value);
        return this;
    }

    @Override
    public CommentRecord value5(String value) {
        setMail(value);
        return this;
    }

    @Override
    public CommentRecord value6(String value) {
        setUrl(value);
        return this;
    }

    @Override
    public CommentRecord value7(String value) {
        setIp(value);
        return this;
    }

    @Override
    public CommentRecord value8(String value) {
        setAgent(value);
        return this;
    }

    @Override
    public CommentRecord value9(String value) {
        setContent(value);
        return this;
    }

    @Override
    public CommentRecord value10(String value) {
        setType(value);
        return this;
    }

    @Override
    public CommentRecord value11(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public CommentRecord value12(Integer value) {
        setCreateTime(value);
        return this;
    }

    @Override
    public CommentRecord values(Integer value1, Integer value2, Integer value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, String value11, Integer value12) {
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
        return this;
    }

    public CommentRecord() {
        super(COMMENT.T_COMMENT);
    }

    public CommentRecord(Integer cid, Integer aid, Integer parent, String author, String mail, String url, String ip, String agent, String content, String type, String status, Integer createTime) {
        super(COMMENT.T_COMMENT);

        set(0, cid);
        set(1, aid);
        set(2, parent);
        set(3, author);
        set(4, mail);
        set(5, url);
        set(6, ip);
        set(7, agent);
        set(8, content);
        set(9, type);
        set(10, status);
        set(11, createTime);
    }
}