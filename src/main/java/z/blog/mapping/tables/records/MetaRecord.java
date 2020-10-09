package z.blog.mapping.tables.records;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;
import z.blog.mapping.tables.META;

public class MetaRecord extends UpdatableRecordImpl<MetaRecord> implements Record6<Integer, String, String, String, String, Integer> {

    private static final long serialVersionUID = -2121938856;

    public MetaRecord setMid(Integer value) {
        set(0, value);
        return this;
    }

    public Integer getMid() {
        return (Integer) get(0);
    }

    public MetaRecord setTitle(String value) {
        set(1, value);
        return this;
    }

    public String getTitle() {
        return (String) get(1);
    }

    public MetaRecord setFlag(String value) {
        set(2, value);
        return this;
    }

    public String getFlag() {
        return (String) get(2);
    }

    public MetaRecord setType(String value) {
        set(3, value);
        return this;
    }

    public String getType() {
        return (String) get(3);
    }

    public MetaRecord setDescription(String value) {
        set(4, value);
        return this;
    }

    public String getDescription() {
        return (String) get(4);
    }

    public MetaRecord setCount(Integer value) {
        set(5, value);
        return this;
    }

    public Integer getCount() {
        return (Integer) get(5);
    }

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    @Override
    public Row6<Integer, String, String, String, String, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, String, String, String, String, Integer> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return META.T_META.MID;
    }

    @Override
    public Field<String> field2() {
        return META.T_META.TITLE;
    }

    @Override
    public Field<String> field3() {
        return META.T_META.FLAG;
    }

    @Override
    public Field<String> field4() {
        return META.T_META.TYPE;
    }

    @Override
    public Field<String> field5() {
        return META.T_META.DESCRIPTION;
    }

    @Override
    public Field<Integer> field6() {
        return META.T_META.COUNT;
    }

    @Override
    public Integer component1() {
        return getMid();
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
        return getType();
    }

    @Override
    public String component5() {
        return getDescription();
    }

    @Override
    public Integer component6() {
        return getCount();
    }

    @Override
    public Integer value1() {
        return getMid();
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
        return getType();
    }

    @Override
    public String value5() {
        return getDescription();
    }

    @Override
    public Integer value6() {
        return getCount();
    }

    @Override
    public MetaRecord value1(Integer value) {
        setMid(value);
        return this;
    }

    @Override
    public MetaRecord value2(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public MetaRecord value3(String value) {
        setFlag(value);
        return this;
    }

    @Override
    public MetaRecord value4(String value) {
        setType(value);
        return this;
    }

    @Override
    public MetaRecord value5(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public MetaRecord value6(Integer value) {
        setCount(value);
        return this;
    }

    @Override
    public MetaRecord values(Integer value1, String value2, String value3, String value4, String value5, Integer value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    public MetaRecord() {
        super(META.T_META);
    }

    public MetaRecord(Integer mid, String title, String flag, String type, String description, Integer count) {
        super(META.T_META);
        set(0, mid);
        set(1, title);
        set(2, flag);
        set(3, type);
        set(4, description);
        set(5, count);
    }
}