package controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;

import java.util.List;

public class menuController extends Controller {
    public void get_menu_list(){
        List list = Db.find("select * from menu order by id DESC");
        setAttr("menuList", list);
        render("/get_menu_list.html");
    }
}
