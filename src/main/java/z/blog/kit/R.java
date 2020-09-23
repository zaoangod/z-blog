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

    public static R s() {
        return R.s("操作成功", null);
    }

    public static R s(String msg, Object data) {
        return new R(0, msg, data);
    }

    public static R f() {
        return R.f("操作失败", null);
    }

    public static R f(String msg, Object data) {
        return new R(1, msg, data);
    }
}