package controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import model.Reserve;

import java.util.List;

public class ReserveController extends Controller {
    public void get_reserve_list() {
        List falseStatusList = Db.find("select * from reserve where status=false order by id DESC");
        List trueStatusList = Db.find("select * from reserve where status=true order by id DESC");
        setAttr("falseStatusList", falseStatusList);
        setAttr("falseStatusCount", falseStatusList.size());
        setAttr("trueStatusList", trueStatusList);
        setAttr("trueStatusCount", trueStatusList.size());
        render("/get_reserve_list.html");
    }

    public void update() {
        Integer id = getParaToInt("id");
        if (id != null) {
            Reserve reserve = new Reserve();
            reserve.setId(id);
            reserve.setStatus(true);
            reserve.update();
        }
        redirect("/reserve/get_reserve_list.html");
    }
}
