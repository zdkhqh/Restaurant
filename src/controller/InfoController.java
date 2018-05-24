package controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import model.Info;
import util.FormUtil;
import util.SqlBuilder;


public class InfoController extends Controller {
    public void get_info_page() {
        Page<Info> page = SqlBuilder.dao(Info.dao).page(new FormUtil(getParaMap()));
        renderJson(page);
    }

    public void get_info() {
        Record record = Db.findFirst("select * from info where type = 1;");
        if (record == null) record = new Record();
        setAttr("info", record);
        render("/get_info.html");
    }

    public void add_info() {
        renderJson(SqlBuilder.dao(Info.dao).add(getBean(Info.class, "")));
    }

    public void delete_info() {
        renderJson(SqlBuilder.dao(Info.dao).deleteById(getParaToInt("id")));
    }

    public void update_info() {
        renderJson(SqlBuilder.dao(Info.dao).update(getBean(Info.class, "")));
    }
}
