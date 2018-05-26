package controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;
import model.Info;
import util.FormUtil;
import util.SqlBuilder;

import java.util.Date;


public class InfoController extends Controller {
    private static final String RESULT_MESSAGE = "result_message";
    private static final int SUCCESS = 1;
    private static final int FAIL = 0;
    private static final int ERROR = -1;

    public void get_info_page() {
        FormUtil formUtil = new FormUtil(getParaMap());
        setAttr("infoPage", Db.paginate(formUtil.getPageNumber(),
                formUtil.getPageSize(),
                "select *", "from info where type = 2 order by id DESC"));
        render("/get_info_page.html");
    }

    public void get_info() {
        Record record = Db.findFirst("select * from info where type = 1;");
        if (record == null) record = new Record();
        setAttr("info", record);
        render("/get_info.html");
    }

    public void get_info_by_id() {
        renderJson(Db.findFirst("select * from info where id =?", getPara("id")));
    }

    public void add_info() {
        UploadFile uploadFile = getFile();
        Info info = getModel(Info.class, "info", true);
        if (info != null) {
            if (uploadFile != null) info.setPic(uploadFile.getFileName());
            info.setTime(new Date());
            if (info.getId() == null ? info.save() : info.update()) {
                if (info.getType() == 1) redirect("get_info.html");
                else redirect("/info/get_info_page.html");
                return;
            }
        }
        renderJson(Ret.fail());
    }

    public void delete_info() {
        SqlBuilder.dao(Info.dao).deleteById(getParaToInt("id"));
        redirect("/info/get_info_page.html");
    }

    public void update_info() {
        renderJson(SqlBuilder.dao(Info.dao).update(getBean(Info.class, "")));
    }
}
