package controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.upload.UploadFile;
import model.Menu;
import util.SqlBuilder;

import java.util.List;

public class menuController extends Controller {
    public void get_menu_list() {
        List list = Db.find("select * from menu order by id DESC");
        setAttr("menuList", list);
        render("/get_menu_list.html");
    }

    public void update() {
        UploadFile uploadFile = getFile();
        Menu menu = getModel(Menu.class, "menu", true);
        if (menu != null) {
            if (uploadFile != null) menu.setPic(uploadFile.getFileName());
            if (menu.getId() == null ? menu.save() : menu.update()) {
                redirect("/menu/get_menu_list.html");
                return;
            }
        }
        renderJson(Ret.fail());
    }

    public void delete_menu(){
        SqlBuilder.dao(Menu.dao).deleteById(getParaToInt("id"));
        redirect("/menu/get_menu_list.html");
    }

}
