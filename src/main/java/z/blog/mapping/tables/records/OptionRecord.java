package z.blog.mapping.tables.records;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;
import z.blog.mapping.tables.OPTION;

public class OptionRecord extends UpdatableRecordImpl<OptionRecord> implements Record2<String, String> {

    private static final long serialVersionUID = -761894671;

    public OptionRecord setKey(String value) {
        set(0, value);
        return this;
    }

    public String getKey() {
        return (String) get(0);
    }

    public OptionRecord setValue(String value) {
        set(1, value);
        return this;
    }

    public String getValue() {
        return (String) get(1);
    }

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return OPTION.T_OPTION.KEY;
    }

    @Override
    public Field<String> field2() {
        return OPTION.T_OPTION.VALUE;
    }

    @Override
    public String component1() {
        return getKey();
    }

    @Override
    public String component2() {
        return getValue();
    }

    @Override
    public String value1() {
        return getKey();
    }

    @Override
    public String value2() {
        return getValue();
    }

    @Override
    public OptionRecord value1(String value) {
        setKey(value);
        return this;
    }

    @Override
    public OptionRecord value2(String value) {
        setValue(value);
        return this;
    }

    @Override
    public OptionRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    public OptionRecord() {
        super(OPTION.T_OPTION);
    }

    public OptionRecord(String key, String value) {
        super(OPTION.T_OPTION);

        set(0, key);
        set(1, value);
    }
}