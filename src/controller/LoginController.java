package controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;
import intercept.AdminIntercept;
import service.AdminService;

public class LoginController extends Controller {
    /**
     * 登陆入口
     */
    public void index() {
        if (AdminService.loginCheck(getParaMap())) {
            getSession().setMaxInactiveInterval(-1);    //设置永不过期
            renderJson(Ret.ok("date", "登陆成功!"));
        }else{
            renderJson(Ret.fail("error", "登陆失败!"));
        }
    }

    /**
     * 登陆入口
     */
    public void login() {
        if (AdminService.loginCheck(getParaMap())) {
            getSession().setMaxInactiveInterval(-1);    //设置永不过期
            renderJson(Ret.ok("date", "登陆成功!"));
        }else{
            renderJson(Ret.fail("error", "登陆失败!"));
        }
    }

    /**
     * 登出
     */
    @Before(AdminIntercept.class)
    public void loginout() {
        Integer id = (Integer) getSession().getAttribute("id");
        if (id != null) {
            if (AdminService.loginOut()) {
                renderJson(Ret.ok("data", "退出成功!"));
                return;
            }
        }
        renderJson(Ret.fail("error", "退出失败!"));
    }
}
