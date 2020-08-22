/*
 * This file is generated by jOOQ.
 */
package z.blog.mapping.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;

import z.blog.mapping.tables.LOG;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LogRecord extends UpdatableRecordImpl<LogRecord> implements Record6<Integer, String, String, Integer, String, Integer> {

    private static final long serialVersionUID = -1431406855;

    /**
     * Setter for <code>t_log.lid</code>.
     */
    public LogRecord setLid(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>t_log.lid</code>.
     */
    public Integer getLid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>t_log.title</code>.
     */
    public LogRecord setTitle(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>t_log.title</code>.
     */
    public String getTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>t_log.data</code>.
     */
    public LogRecord setData(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>t_log.data</code>.
     */
    public String getData() {
        return (String) get(2);
    }

    /**
     * Setter for <code>t_log.author_id</code>.
     */
    public LogRecord setAuthorId(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>t_log.author_id</code>.
     */
    public Integer getAuthorId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>t_log.ip</code>.
     */
    public LogRecord setIp(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>t_log.ip</code>.
     */
    public String getIp() {
        return (String) get(4);
    }

    /**
     * Setter for <code>t_log.created</code>.
     */
    public LogRecord setCreated(Integer value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>t_log.created</code>.
     */
    public Integer getCreated() {
        return (Integer) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, String, Integer, String, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, String, String, Integer, String, Integer> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return LOG.T_LOG.LID;
    }

    @Override
    public Field<String> field2() {
        return LOG.T_LOG.TITLE;
    }

    @Override
    public Field<String> field3() {
        return LOG.T_LOG.DATA;
    }

    @Override
    public Field<Integer> field4() {
        return LOG.T_LOG.AUTHOR_ID;
    }

    @Override
    public Field<String> field5() {
        return LOG.T_LOG.IP;
    }

    @Override
    public Field<Integer> field6() {
        return LOG.T_LOG.CREATED;
    }

    @Override
    public Integer component1() {
        return getLid();
    }

    @Override
    public String component2() {
        return getTitle();
    }

    @Override
    public String component3() {
        return getData();
    }

    @Override
    public Integer component4() {
        return getAuthorId();
    }

    @Override
    public String component5() {
        return getIp();
    }

    @Override
    public Integer component6() {
        return getCreated();
    }

    @Override
    public Integer value1() {
        return getLid();
    }

    @Override
    public String value2() {
        return getTitle();
    }

    @Override
    public String value3() {
        return getData();
    }

    @Override
    public Integer value4() {
        return getAuthorId();
    }

    @Override
    public String value5() {
        return getIp();
    }

    @Override
    public Integer value6() {
        return getCreated();
    }

    @Override
    public LogRecord value1(Integer value) {
        setLid(value);
        return this;
    }

    @Override
    public LogRecord value2(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public LogRecord value3(String value) {
        setData(value);
        return this;
    }

    @Override
    public LogRecord value4(Integer value) {
        setAuthorId(value);
        return this;
    }

    @Override
    public LogRecord value5(String value) {
        setIp(value);
        return this;
    }

    @Override
    public LogRecord value6(Integer value) {
        setCreated(value);
        return this;
    }

    @Override
    public LogRecord values(Integer value1, String value2, String value3, Integer value4, String value5, Integer value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LogRecord
     */
    public LogRecord() {
        super(LOG.T_LOG);
    }

    /**
     * Create a detached, initialised LogRecord
     */
    public LogRecord(Integer lid, String title, String data, Integer authorId, String ip, Integer created) {
        super(LOG.T_LOG);

        set(0, lid);
        set(1, title);
        set(2, data);
        set(3, authorId);
        set(4, ip);
        set(5, created);
    }
}
