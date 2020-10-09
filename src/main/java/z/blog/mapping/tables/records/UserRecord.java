package z.blog.mapping.tables.records;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;
import z.blog.mapping.tables.USER;

public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record5<Integer, String, String, String, Integer> {

    private static final long serialVersionUID = 619790011;

    public UserRecord setUid(Integer value) {
        set(0, value);
        return this;
    }

    public Integer getUid() {
        return (Integer) get(0);
    }

    public UserRecord setUsername(String value) {
        set(1, value);
        return this;
    }

    public String getUsername() {
        return (String) get(1);
    }

    public UserRecord setPassword(String value) {
        set(2, value);
        return this;
    }

    public String getPassword() {
        return (String) get(2);
    }

    public UserRecord setEmail(String value) {
        set(3, value);
        return this;
    }

    public String getEmail() {
        return (String) get(3);
    }

    public UserRecord setLoginTime(Integer value) {
        set(4, value);
        return this;
    }

    public Integer getLoginTime() {
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
        return USER.T_USER.UID;
    }

    @Override
    public Field<String> field2() {
        return USER.T_USER.USERNAME;
    }

    @Override
    public Field<String> field3() {
        return USER.T_USER.PASSWORD;
    }

    @Override
    public Field<String> field4() {
        return USER.T_USER.EMAIL;
    }

    @Override
    public Field<Integer> field5() {
        return USER.T_USER.LOGIN_TIME;
    }

    @Override
    public Integer component1() {
        return getUid();
    }

    @Override
    public String component2() {
        return getUsername();
    }

    @Override
    public String component3() {
        return getPassword();
    }

    @Override
    public String component4() {
        return getEmail();
    }

    @Override
    public Integer component5() {
        return getLoginTime();
    }

    @Override
    public Integer value1() {
        return getUid();
    }

    @Override
    public String value2() {
        return getUsername();
    }

    @Override
    public String value3() {
        return getPassword();
    }

    @Override
    public String value4() {
        return getEmail();
    }

    @Override
    public Integer value5() {
        return getLoginTime();
    }

    @Override
    public UserRecord value1(Integer value) {
        setUid(value);
        return this;
    }

    @Override
    public UserRecord value2(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public UserRecord value3(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public UserRecord value4(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public UserRecord value5(Integer value) {
        setLoginTime(value);
        return this;
    }

    @Override
    public UserRecord values(Integer value1, String value2, String value3, String value4, Integer value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    public UserRecord() {
        super(USER.T_USER);
    }

    public UserRecord(Integer uid, String username, String password, String email, Integer loginTime) {
        super(USER.T_USER);

        set(0, uid);
        set(1, username);
        set(2, password);
        set(3, email);
        set(4, loginTime);
    }
}