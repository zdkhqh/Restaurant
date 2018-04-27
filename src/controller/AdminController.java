package controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import model.Admin;
import service.AdminService;
import util.AdminThreadContext;
import util.TimeUtil;

public class AdminController extends Controller {
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
    public void get_current() {
        setCurrentAdmin();
        setAttr("time", TimeUtil.getDateYYYYMMDDEAByTime(TimeUtil.getNow()));
        renderJson(TimeUtil.getDateYYYYMMDDEAByTime(TimeUtil.getNow()));
    }

    /**
     * 管理员信息分页展示
     */
    public void get_admin_page() {
        Page<Admin> adminList = AdminService.page(getParaToInt("page_number", 1), getParaToInt("page_size", 10));
        renderJson(Ret.ok("data", adminList));
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
    public void add_admin(){
        Admin admin = getBean(Admin.class, "");
        if (AdminService.addAdmin(admin)>0) {
            renderJson(Ret.ok("data", "新增管理员成功!"));
        } else {
            renderJson(Ret.fail("error", "新增管理员失败!"));
        }
    }
}


