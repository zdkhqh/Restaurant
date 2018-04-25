package config;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.handler.Handler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import intercept.SessionIntercept;
import model._MappingKit;
import util.FlywayApp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AppConfig extends JFinalConfig {

    public static void main(String[] args) {
        /**
         * 特别注意：Eclipse 之下的启动方式
         */
        //JFinal.start("WebRoot", 80, "/", 5);

        /**
         * 特别注意：IDEA 之下的启动方式，仅比 eclipse 之下少了最后一个参数
         */
        JFinal.start("WebRoot", 80, "/");
    }

    @Override
    public void afterJFinalStart() {

    }

    /**
     * 配置常量
     */
    @Override
    public void configConstant(Constants me) {
        // 加载少量必要配置，随后可用PropKit.get(...)获取值
        PropKit.use("config.txt");
        me.setDevMode(PropKit.getBoolean("devMode", false));
        me.setEncoding("utf-8");
        me.setViewType(ViewType.JSP);
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
        return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
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

        //数据库管理
        me.add(new FlywayApp());
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
        me.add(new Handler() {
            @Override
            public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
                request.setAttribute("ctx", request.getContextPath());
                next.handle(target, request, response, isHandled);
            }
        });
    }
}
