package config;

import com.jfinal.config.Routes;
import controller.InfoController;
import controller.LoginController;

public class HomeRoutes extends Routes {
    @Override
    public void config() {
        add("/", LoginController.class);
        add("/info", InfoController.class);
    }
}
