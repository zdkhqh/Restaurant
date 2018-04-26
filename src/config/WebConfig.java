package config;

import com.jfinal.kit.LogKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

import java.io.File;
import java.lang.reflect.Field;

/**
 * 预读配置类
 */
public class WebConfig {

    //是否是开发模式，打印信息用
    public static boolean devMode = false;

    //数据库ip和端口号
    public static String db_ip;
    //数据库名
    public static String db_name;
    //数据库账号
    public static String db_user;
    //数据库密码
    public static String db_password;

    //网站端口
    public static int web_listen_port = 8080;

    //数据库连接地址
    public static String db_url;


    /**
     * 打印配置
     */
    public static void printParam() {
        Field[] fields = WebConfig.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                System.out.println(field.getName() + ":" + field.get(field.getName()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void init() {
        init(System.getProperty("user.dir") + File.separator + "res/webconfig.properties");
    }

    /**
     * 利用反射把prop中的配置设置进对象
     *
     * @param uri
     */
    public static void init(String uri) {
        File file = new File(uri);
        if ((file.exists() && file.isFile())) {
            try {
                Prop prop = PropKit.use(file);
                Class c = WebConfig.class;
                Field[] fields = c.getDeclaredFields();
                for (Field f : fields) {
                    if (prop.containsKey(f.getName())) {
                        if (f.getType().equals(String.class)) {
                            f.set(c, prop.get(f.getName()));
                        } else if (f.getType().equals(int.class)) {
                            f.set(c, prop.getInt(f.getName()));
                        } else if (f.getType().equals(long.class)) {
                            f.set(c, prop.getLong(f.getName()));
                        } else if (f.getType().equals(boolean.class)) {
                            f.set(c, prop.getBoolean(f.getName()));
                        }
                    }
                }
                db_url = "jdbc:mysql://" + db_ip + "/" + db_name + "?useSSL=false&serverTimezone=GMT%2b8&autoReconnect=true&failOverReadOnly=false&useUnicode=true&characterEncoding=UTF-8";
            } catch (Exception e) {
                LogKit.error("WebConfig init fail:" + e.getMessage());
            }
        } else {
            LogKit.error("配置文件不存在！");
        }
    }

}
