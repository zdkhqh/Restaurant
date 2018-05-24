package config;

import com.jfinal.config.Routes;
import controller.AdminController;
import controller.InfoController;
import intercept.AdminIntercept;

public class AdminRoutes extends Routes {
    @Override
    public void config() {
        add("/admin", AdminController.class);
        add("/info", InfoController.class);
        addInterceptor(new AdminIntercept());   //登陆拦截器
    }
}
