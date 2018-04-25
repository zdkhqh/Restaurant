package util;

import com.jfinal.kit.PropKit;
import com.jfinal.plugin.IPlugin;
import org.flywaydb.core.Flyway;

public class FlywayApp implements IPlugin {

    private static Flyway getFlyway() {

        Flyway flyway = new Flyway();
        String url = "jdbc:mysql://" + "127.0.0.1" + "/" + "restaurant" + "?useSSL=false&serverTimezone=GMT%2b8&autoReconnect=true&failOverReadOnly=false&useUnicode=true&characterEncoding=UTF-8";
        flyway.setDataSource(url, PropKit.get("user"), PropKit.get("password"));
        return flyway;
    }

    public static void migrate() {
        getFlyway().migrate();
    }

    public static void repair() {
        getFlyway().repair();
    }

    @Override
    public boolean start() {
        migrate();
        return true;
    }

    @Override
    public boolean stop() {
        return false;
    }
}
