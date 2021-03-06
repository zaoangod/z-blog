package z.blog.mapping.tables.records;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;
import z.blog.mapping.tables.ATTACH;

public class AttachRecord extends UpdatableRecordImpl<AttachRecord> implements Record7<Integer, String, String, String, Integer, String, String> {

    private static final long serialVersionUID = 381957137;

    public AttachRecord setAid(Integer value) {
        set(0, value);
        return this;
    }

    public Integer getAid() {
        return (Integer) get(0);
    }

    public AttachRecord setName(String value) {
        set(1, value);
        return this;
    }

    public String getName() {
        return (String) get(1);
    }

    public AttachRecord setType(String value) {
        set(2, value);
        return this;
    }

    public String getType() {
        return (String) get(2);
    }

    public AttachRecord setKey(String value) {
        set(3, value);
        return this;
    }

    public String getKey() {
        return (String) get(3);
    }

    public AttachRecord setCreateTime(Integer value) {
        set(4, value);
        return this;
    }

    public Integer getCreateTime() {
        return (Integer) get(4);
    }

    public AttachRecord setUrl(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>t_attach.url</code>.
     */
    public String getUrl() {
        return (String) get(5);
    }

    public AttachRecord setStatus(String value) {
        set(6, value);
        return this;
    }

    public String getStatus() {
        return (String) get(6);
    }

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    @Override
    public Row7<Integer, String, String, String, Integer, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Integer, String, String, String, Integer, String, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return ATTACH.T_ATTACH.AID;
    }

    @Override
    public Field<String> field2() {
        return ATTACH.T_ATTACH.NAME;
    }

    @Override
    public Field<String> field3() {
        return ATTACH.T_ATTACH.TYPE;
    }

    @Override
    public Field<String> field4() {
        return ATTACH.T_ATTACH.KEY;
    }

    @Override
    public Field<Integer> field5() {
        return ATTACH.T_ATTACH.CREATE_TIME;
    }

    @Override
    public Field<String> field6() {
        return ATTACH.T_ATTACH.URL;
    }

    @Override
    public Field<String> field7() {
        return ATTACH.T_ATTACH.STATUS;
    }

    @Override
    public Integer component1() {
        return getAid();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getType();
    }

    @Override
    public String component4() {
        return getKey();
    }

    @Override
    public Integer component5() {
        return getCreateTime();
    }

    @Override
    public String component6() {
        return getUrl();
    }

    @Override
    public String component7() {
        return getStatus();
    }

    @Override
    public Integer value1() {
        return getAid();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getType();
    }

    @Override
    public String value4() {
        return getKey();
    }

    @Override
    public Integer value5() {
        return getCreateTime();
    }

    @Override
    public String value6() {
        return getUrl();
    }

    @Override
    public String value7() {
        return getStatus();
    }

    @Override
    public AttachRecord value1(Integer value) {
        setAid(value);
        return this;
    }

    @Override
    public AttachRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public AttachRecord value3(String value) {
        setType(value);
        return this;
    }

    @Override
    public AttachRecord value4(String value) {
        setKey(value);
        return this;
    }

    @Override
    public AttachRecord value5(Integer value) {
        setCreateTime(value);
        return this;
    }

    @Override
    public AttachRecord value6(String value) {
        setUrl(value);
        return this;
    }

    @Override
    public AttachRecord value7(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public AttachRecord values(Integer value1, String value2, String value3, String value4, Integer value5, String value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    public AttachRecord() {
        super(ATTACH.T_ATTACH);
    }

    public AttachRecord(Integer aid, String name, String type, String key, Integer createTime, String url, String status) {
        super(ATTACH.T_ATTACH);

        set(0, aid);
        set(1, name);
        set(2, type);
        set(3, key);
        set(4, createTime);
        set(5, url);
        set(6, status);
    }
}