package controller;

import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import model.Reserve;

import java.util.Date;
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

    @Clear
    public void add_reserve(){
        Reserve reserve = getModel(Reserve.class,"reserve",true);
        String date = getPara("date");
        String time= getPara("time");
        reserve.setUseTime(date+" "+time);
        reserve.setAddTime(new Date());
        if(reserve.save()){
            renderJson(Ret.ok("msg",1));
        }else{
            renderJson(Ret.fail());
        }
    }
}
