package service;

import com.jfinal.plugin.activerecord.Page;
import model.Info;

public class InfoService{

    private static final Info dao = new Info().dao();

    public static Page<Info> page(int pageNumber, int pageSize) {
        return dao.paginate(pageNumber, pageSize, "select *", "from info");
    }

}
