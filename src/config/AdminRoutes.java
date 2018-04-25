package config;

import com.jfinal.config.Routes;
import controller.AdminController;

public class AdminRoutes extends Routes {
    @Override
    public void config() {
        add("/admin", AdminController.class);
    }
}
