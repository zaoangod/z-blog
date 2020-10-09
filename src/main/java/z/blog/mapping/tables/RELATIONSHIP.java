package z.blog.mapping.tables;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import z.blog.mapping.DefaultSchema;
import z.blog.mapping.tables.records.RelationshipRecord;

public class RELATIONSHIP extends TableImpl<RelationshipRecord> {

    private static final long serialVersionUID = -1869870083;

    public static final RELATIONSHIP T_RELATIONSHIP = new RELATIONSHIP();

    @Override
    public Class<RelationshipRecord> getRecordType() {
        return RelationshipRecord.class;
    }

    public final TableField<RelationshipRecord, Integer> AID = createField(DSL.name("aid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    public final TableField<RelationshipRecord, Integer> MID = createField(DSL.name("mid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    public RELATIONSHIP() {
        this(DSL.name("t_relationship"), null);
    }

    public RELATIONSHIP(String alias) {
        this(DSL.name(alias), T_RELATIONSHIP);
    }

    public RELATIONSHIP(Name alias) {
        this(alias, T_RELATIONSHIP);
    }

    private RELATIONSHIP(Name alias, Table<RelationshipRecord> aliased) {
        this(alias, aliased, null);
    }

    private RELATIONSHIP(Name alias, Table<RelationshipRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public RELATIONSHIP as(String alias) {
        return new RELATIONSHIP(DSL.name(alias), this);
    }

    @Override
    public RELATIONSHIP as(Name alias) {
        return new RELATIONSHIP(alias, this);
    }

    @Override
    public RELATIONSHIP rename(String name) {
        return new RELATIONSHIP(DSL.name(name), null);
    }

    @Override
    public RELATIONSHIP rename(Name name) {
        return new RELATIONSHIP(name, null);
    }

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}