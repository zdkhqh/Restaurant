package controller;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import intercept.AdminIntercept;
import model.Admin;
import service.AdminService;
import util.AdminThreadContext;
import util.FormUtil;
import util.SqlBuilder;
import util.TimeUtil;

public class AdminController extends Controller {
    /**
     * 登陆入口
     */
    @Clear(AdminIntercept.class)
    @Before(POST.class)
    public void login() {
        if (AdminService.loginCheck(getParaMap())) {
            redirect("/admin/index");
        } else {
            setAttr("msg", "账号或密码不得为空或错误！");
            render("/login.html");
        }
    }

    /**
     * 登出
     */
    public void loginout() {
        Integer id = (Integer) getSession().getAttribute("id");
        if (id != null) {
            if (AdminService.loginOut()) {
                redirect("/admin/index");
                return;
            }
        }
        renderJson(Ret.fail("error", "退出失败!"));
    }

    /**
     * 设置当前登录管理员信息
     */
    private void setCurrentAdmin() {
        setAttr("admin_id", AdminThreadContext.getId());//设置管理员id
        //设置管理员显示名称，优先显示nickname，若没有则显示账号
        setAttr("admin_name", AdminThreadContext.getNickname() == null ? AdminThreadContext.getUsername() : AdminThreadContext.getNickname());
    }

    /**
     * 获得当前管理员信息和时间信息,后台首页显示用
     */
    public void index() {
        setCurrentAdmin();
        setAttr("time", TimeUtil.getDateYYYYMMDDEAByTime(TimeUtil.getNow()));
        render("/index.html");
    }

    /**
     * 管理员信息分页展示
     */
    public void get_admin_page() {
        Page<Admin> adminPage = SqlBuilder.dao(Admin.dao).page(new FormUtil(getParaMap()));
        renderJson(Ret.ok("data", adminPage));
    }

    /**
     * 管理员账号信息修改
     */
    public void update_admin() {
        Admin admin = getBean(Admin.class, "");
        if (AdminService.updateAdmin(admin)) {
            renderJson(Ret.ok("data", "修改信息成功!"));
        } else {
            renderJson(Ret.fail("error", "修改信息失败!"));
        }
    }

    /**
     * 删除管理员
     */
    public void delete_admin() {
        if (AdminService.deleteById(getParaToInt("id", -1))) {
            renderJson(Ret.ok("data", "删除管理员成功!"));
        } else {
            renderJson(Ret.ok("data", "删除管理员失败!"));
        }
    }

    /**
     * 新增管理员
     */
    public void add_admin() {
        Admin admin = getBean(Admin.class, "");
        if (AdminService.addAdmin(admin) > 0) {
            renderJson(Ret.ok("data", "新增管理员成功!"));
        } else {
            renderJson(Ret.fail("error", "新增管理员失败!"));
        }
    }

    /**
     * 获得单个管理员信息
     */
    public void get_admin() {
        renderJson(Ret.ok("data", AdminService.getById(getParaToInt("id"))));
    }
}


