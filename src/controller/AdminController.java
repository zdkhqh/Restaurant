package controller;

import com.jfinal.core.Controller;
import util.AdminThreadContext;
import util.TimeUtil;

public class AdminController extends Controller {
    /**
     * 管理员信息
     */
    private void setCurrentAdmin() {
        setAttr("admin_id", AdminThreadContext.getId());//设置管理员id
        //设置管理员显示名称，优先显示nickname，若没有则显示账号
        setAttr("admin_name", AdminThreadContext.getNickname() == null ? AdminThreadContext.getUsername() : AdminThreadContext.getNickname());
    }

    /**
     * 获得当前管理员信息和时间信息,后台首页显示用
     */
    public void getCurrent() {
        setCurrentAdmin();
        setAttr("time", TimeUtil.getDateYYYYMMDDEAByTime(TimeUtil.getNow()));
        renderJson(TimeUtil.getDateYYYYMMDDEAByTime(TimeUtil.getNow()));
    }

    /**
     * 管理员列表展示
     */
    public void getAdminList(){

    }

}


