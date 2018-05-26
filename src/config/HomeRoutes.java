package config;

import com.jfinal.config.Routes;
import controller.IndexController;

public class HomeRoutes extends Routes {
    @Override
    public void config() {
        add("/", IndexController.class);
        add("/page", IndexController.class);
    }
}
