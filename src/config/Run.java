package config;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import intercept.SessionIntercept;
import model._MappingKit;
import util.FlywayApp;


public class Run extends JFinalConfig {

    public static void main(String[] args) {
        //加载配置
        WebConfig.init();
        //输出配置
        WebConfig.printParam();

        //数据库管理
        FlywayApp.migrate();

        /**
         * 特别注意：Eclipse 之下的启动方式
         */
        //JFinal.start("WebRoot", 80, "/", 5);

        /**
         * 特别注意：IDEA 之下的启动方式，仅比 eclipse 之下少了最后一个参数
         */
        JFinal.start("WebRoot", WebConfig.web_listen_port, "/");
    }

    @Override
    public void afterJFinalStart() {

    }

    /**
     * 配置常量
     */
    @Override
    public void configConstant(Constants me) {
        me.setDevMode(WebConfig.devMode);
        me.setEncoding("utf-8");
        me.setError404View("/404.html");
        me.setError500View("/500.html");
    }

    /**
     * 配置路由
     */
    @Override
    public void configRoute(Routes me) {
        me.add(new AdminRoutes());
        me.add(new HomeRoutes());
    }

    @Override
    public void configEngine(Engine me) {

    }

    public static DruidPlugin createDruidPlugin() {
        return new DruidPlugin(WebConfig.db_url, WebConfig.db_user, WebConfig.db_password);
    }

    /**
     * 配置插件
     */
    @Override
    public void configPlugin(Plugins me) {
        // 配置C3p0数据库连接池插件
        DruidPlugin druidPlugin = createDruidPlugin();
        me.add(druidPlugin);

        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        // 所有映射在 MappingKit 中自动化搞定
        _MappingKit.mapping(arp);
        me.add(arp);
        arp.setShowSql(WebConfig.devMode);
        arp.setDevMode(WebConfig.devMode);
        me.add(arp);
    }

    /**
     * 配置全局拦截器
     */
    @Override
    public void configInterceptor(Interceptors me) {
        me.add(new SessionIntercept());
    }

    /**
     * 配置处理器
     */
    @Override
    public void configHandler(Handlers me) {
        me.add(new UrlHandler());
    }
}
