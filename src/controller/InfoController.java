package controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import model.Info;
import util.FormUtil;
import util.SqlBuilder;


public class InfoController extends Controller{
    public void get_info_page(){
        Page<Info> page = SqlBuilder.dao(Info.dao).page(new FormUtil(getParaMap()));
        renderJson(page);
    }
}
