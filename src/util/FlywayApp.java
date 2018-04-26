package util;

import com.jfinal.plugin.IPlugin;
import config.WebConfig;
import org.flywaydb.core.Flyway;

public class FlywayApp implements IPlugin {

    private static Flyway getFlyway() {

        Flyway flyway = new Flyway();
        flyway.setDataSource(WebConfig.db_url, WebConfig.db_user, WebConfig.db_password);
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
