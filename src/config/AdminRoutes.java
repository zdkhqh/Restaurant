package config;

import com.jfinal.config.Routes;
import controller.AdminController;
import intercept.AdminIntercept;

public class AdminRoutes extends Routes {
    @Override
    public void config() {
        add("/admin", AdminController.class);
        //addInterceptor(new AdminIntercept());   //登陆拦截器
    }
}
