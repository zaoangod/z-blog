package z.blog.kit;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class R {

    private Integer code;
    private String msg;
    private Object data;

    public R() {
    }

    public R(int c, String m, Object d) {
        this.code = c;
        this.msg = m;
        this.data = d;
    }

    /**
     * 成功
     *
     * @return R
     */
    public static R s() {
        return R.s("操作成功", null);
    }

    /**
     * 成功
     *
     * @param msg 消息提示
     * @return R
     */
    public static R s(String msg) {
        return new R(0, msg, null);
    }

    /**
     * 成功
     *
     * @param msg  消息提示
     * @param data 返回数据
     * @return R
     */
    public static R s(String msg, Object data) {
        return new R(0, msg, data);
    }

    /**
     * 失败
     *
     * @return R
     */
    public static R f() {
        return R.f("操作失败", null);
    }

    /**
     * 失败
     *
     * @param msg 消息提示
     * @return R
     */
    public static R f(String msg) {
        return new R(1, msg, null);
    }

    /**
     * 失败
     *
     * @param msg  消息提示
     * @param data 返回数据
     * @return R
     */
    public static R f(String msg, Object data) {
        return new R(1, msg, data);
    }
}