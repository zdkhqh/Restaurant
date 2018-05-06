package controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import model.Info;
import util.FormUtil;
import util.SqlBuilder;


public class InfoController extends Controller {
    public void get_info_page() {
        Page<Info> page = SqlBuilder.dao(Info.dao).page(new FormUtil(getParaMap()));
        renderJson(page);
    }

    public void get_info() {
        renderJson(SqlBuilder.dao(Info.dao).get_by_id(1));
    }

    public void add_info() {
        renderJson(SqlBuilder.dao(Info.dao).add(getBean(Info.class, "")));
    }

    public void delete_info() {
        renderJson(SqlBuilder.dao(Info.dao).deleteById(getParaToInt("id")));
    }

    public void update_info(){
        renderJson(SqlBuilder.dao(Info.dao).update(getBean(Info.class, "")));
    }
}
