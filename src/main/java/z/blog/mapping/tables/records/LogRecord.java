package z.blog.mapping.tables.records;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;
import z.blog.mapping.tables.LOG;

public class LogRecord extends UpdatableRecordImpl<LogRecord> implements Record5<Integer, String, String, String, Integer> {

    private static final long serialVersionUID = 1540386677;

    public LogRecord setLid(Integer value) {
        set(0, value);
        return this;
    }

    public Integer getLid() {
        return (Integer) get(0);
    }

    public LogRecord setAction(String value) {
        set(1, value);
        return this;
    }

    public String getAction() {
        return (String) get(1);
    }

    public LogRecord setData(String value) {
        set(2, value);
        return this;
    }

    public String getData() {
        return (String) get(2);
    }

    public LogRecord setIp(String value) {
        set(3, value);
        return this;
    }

    public String getIp() {
        return (String) get(3);
    }

    public LogRecord setCreateTime(Integer value) {
        set(4, value);
        return this;
    }

    public Integer getCreateTime() {
        return (Integer) get(4);
    }

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    @Override
    public Row5<Integer, String, String, String, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, String, String, String, Integer> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return LOG.T_LOG.LID;
    }

    @Override
    public Field<String> field2() {
        return LOG.T_LOG.ACTION;
    }

    @Override
    public Field<String> field3() {
        return LOG.T_LOG.DATA;
    }

    @Override
    public Field<String> field4() {
        return LOG.T_LOG.IP;
    }

    @Override
    public Field<Integer> field5() {
        return LOG.T_LOG.CREATE_TIME;
    }

    @Override
    public Integer component1() {
        return getLid();
    }

    @Override
    public String component2() {
        return getAction();
    }

    @Override
    public String component3() {
        return getData();
    }

    @Override
    public String component4() {
        return getIp();
    }

    @Override
    public Integer component5() {
        return getCreateTime();
    }

    @Override
    public Integer value1() {
        return getLid();
    }

    @Override
    public String value2() {
        return getAction();
    }

    @Override
    public String value3() {
        return getData();
    }

    @Override
    public String value4() {
        return getIp();
    }

    @Override
    public Integer value5() {
        return getCreateTime();
    }

    @Override
    public LogRecord value1(Integer value) {
        setLid(value);
        return this;
    }

    @Override
    public LogRecord value2(String value) {
        setAction(value);
        return this;
    }

    @Override
    public LogRecord value3(String value) {
        setData(value);
        return this;
    }

    @Override
    public LogRecord value4(String value) {
        setIp(value);
        return this;
    }

    @Override
    public LogRecord value5(Integer value) {
        setCreateTime(value);
        return this;
    }

    @Override
    public LogRecord values(Integer value1, String value2, String value3, String value4, Integer value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    public LogRecord() {
        super(LOG.T_LOG);
    }

    public LogRecord(Integer lid, String action, String data, String ip, Integer createTime) {
        super(LOG.T_LOG);

        set(0, lid);
        set(1, action);
        set(2, data);
        set(3, ip);
        set(4, createTime);
    }
}