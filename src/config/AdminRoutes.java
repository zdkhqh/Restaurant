package config;

import com.jfinal.config.Routes;
import controller.AdminController;
import controller.InfoController;
import controller.ReserveController;
import controller.menuController;
import intercept.AdminIntercept;

public class AdminRoutes extends Routes {
    @Override
    public void config() {
        add("/admin", AdminController.class);
        add("/info", InfoController.class);
        add("/reserve", ReserveController.class);
        add("/menu", menuController.class);
        addInterceptor(new AdminIntercept());   //登陆拦截器
    }
}
