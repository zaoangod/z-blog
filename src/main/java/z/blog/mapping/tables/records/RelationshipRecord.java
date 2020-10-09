package z.blog.mapping.tables.records;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;
import z.blog.mapping.tables.RELATIONSHIP;

public class RelationshipRecord extends TableRecordImpl<RelationshipRecord> implements Record2<Integer, Integer> {

    private static final long serialVersionUID = 1127162480;

    public RelationshipRecord setAid(Integer value) {
        set(0, value);
        return this;
    }

    public Integer getAid() {
        return (Integer) get(0);
    }

    public RelationshipRecord setMid(Integer value) {
        set(1, value);
        return this;
    }

    public Integer getMid() {
        return (Integer) get(1);
    }

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, Integer> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return RELATIONSHIP.T_RELATIONSHIP.AID;
    }

    @Override
    public Field<Integer> field2() {
        return RELATIONSHIP.T_RELATIONSHIP.MID;
    }

    @Override
    public Integer component1() {
        return getAid();
    }

    @Override
    public Integer component2() {
        return getMid();
    }

    @Override
    public Integer value1() {
        return getAid();
    }

    @Override
    public Integer value2() {
        return getMid();
    }

    @Override
    public RelationshipRecord value1(Integer value) {
        setAid(value);
        return this;
    }

    @Override
    public RelationshipRecord value2(Integer value) {
        setMid(value);
        return this;
    }

    @Override
    public RelationshipRecord values(Integer value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    public RelationshipRecord() {
        super(RELATIONSHIP.T_RELATIONSHIP);
    }

    public RelationshipRecord(Integer aid, Integer mid) {
        super(RELATIONSHIP.T_RELATIONSHIP);
        set(0, aid);
        set(1, mid);
    }
}