package service;

import com.jfinal.kit.LogKit;
import com.jfinal.plugin.activerecord.Page;
import model.Admin;
import util.AdminThreadContext;

import java.util.Map;

public class AdminService {
    /**
     * 所有的 dao 对象也放在 Service 中
     */
    private static final Admin dao = new Admin().dao();

    /***
     * 登陆验证
     * @param map
     * @return
     */
    public static boolean loginCheck(Map<String, String[]> map) {
        if (map == null || map.isEmpty()) return false;
        String username = map.get("username")[0];
        String password = map.get("password")[0];
        //不得为空
        if (username == null || password == null) return false;
        Admin admin = AdminService.getByUserName(username);
        if (admin != null) {
            if (password.equals(admin.getPassword())) { //验证通过
                //设置登陆账号信息到本地线程
                AdminThreadContext.setId(admin.getId());
                AdminThreadContext.setUsername(admin.getUsername());
                AdminThreadContext.setNickname(admin.getNickname());
                return true;
            }
        }
        //验证失败
        AdminThreadContext.get().invalidate();
        return false;
    }

    /**
     * 登出，注销
     *
     * @return
     */
    public static boolean loginOut() {
        try {
            AdminThreadContext.get().invalidate();
            return true;
        } catch (Exception e) {
            LogKit.error("### 登出失败 ###", e);
            return false;
        }
    }

    public static Page<Admin> page(int pageNumber, int pageSize) {
        return dao.paginate(pageNumber, pageSize, "select *", "from admin");
    }

    public static Admin getById(int id) {
        return dao.findById(id);
    }

    public static boolean deleteById(int id) {
        return dao.findById().deleteById(id);
    }

    public static Admin getByUserName(String username) {
        return dao.findFirst("select * from admin where username =?", username);
    }

    public static boolean updateAdmin(Admin admin) {
        return admin.update();
    }

    public static int addAdmin(Admin admin) {
        admin.save();
        return admin.getId();
    }

}
