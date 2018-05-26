package controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

public class IndexController extends Controller {
    public void index() {    //前台首页
        render("/page/index.html");
    }

    public void contact() {      //联系我们
        render("/page/contact.html");
    }

    public void about() {        //餐厅介绍
        Record record = Db.findFirst("select * from info where type = 1;");
        if (record == null) record = new Record();
        setAttr("info", record);
        render("/page/about.html");
    }

    public void food() {
        List list = Db.find("select * from menu order by id DESC");
        setAttr("menuList", list);
        render("/page/food.html");
    }

    public void news() {
        Integer id = getParaToInt("id");
        Record record;
        if (id == null) record = Db.findFirst("select * from info where type=2 order by id DESC");
        else record = Db.findFirst("select * from info  where type=2 and id =?", id);
        if (record == null) record = new Record();
        setAttr("info", record);
        List list = Db.find("select * from info where type=2 order by id DESC");
        setAttr("infoList", list);
        Record record2 = Db.findFirst("select * from info where type=2 order by id DESC");
        if (record2 == null) record2 = new Record();
        if (StrKit.equals(record.getStr("Id"), record2.getStr("Id"))) {
            setAttr("isLast", true);
        } else {
            setAttr("isLast", false);
        }
        render("/page/news.html");
    }
    public void Book(){
        render("/page/Book.html");
    }
}
