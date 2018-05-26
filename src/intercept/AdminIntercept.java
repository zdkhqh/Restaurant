package intercept;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import util.AdminThreadContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 拦截器，用于拦截非登陆用户
 */
public class AdminIntercept implements Interceptor {
    public void intercept(Invocation inv) {
        Integer id = (Integer) inv.getController().getSession().getAttribute("id");
        if (id == null) {
            inv.getController().render("/login.html");
        } else {
            HttpServletRequest request = inv.getController().getRequest();
            request.setAttribute("admin_id", AdminThreadContext.getId());//设置管理员id
            //设置管理员显示名称，优先显示nickname，若没有则显示账号
            request.setAttribute("admin_name", AdminThreadContext.getNickname() == null ? AdminThreadContext.getUsername() : AdminThreadContext.getNickname());
            inv.invoke();
        }
    }
}
