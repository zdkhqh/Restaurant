package intercept;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.kit.Ret;

/**
 * 拦截器，用于拦截非登陆用户
 */
public class AdminIntercept implements Interceptor {
    public void intercept(Invocation inv) {
        Integer id = (Integer) inv.getController().getSession().getAttribute("id");
        if (id == null) {
            inv.getController().renderJson(Ret.fail("error", "请登录!").set("code", 401));
        } else {
            inv.invoke();
        }
    }
}
