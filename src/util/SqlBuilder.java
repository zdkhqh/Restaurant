package util;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;


public class SqlBuilder<M extends Model<?>> {
    private M _model;

    public static <T extends Model<T>> SqlBuilder<T> dao(T model) {
        return new SqlBuilder<T>(model);
    }

    public SqlBuilder(M model) {
        _model = model;
    }

    /**
     * 进行分页
     */
    public Page<M> page(FormUtil formUtil) {
        return (Page<M>) _model.paginate(
                formUtil.getPageNumber(),
                formUtil.getPageSize(),
                "select\t*", "from\t" + _model.getClass().getSimpleName() + "\norder\tby\t" + formUtil.getOrderName() + "\t" + formUtil.getOrderType() + "\n");
    }

    public M get_by_id(int id) {
        return (M) _model.findById(id);
    }

    public boolean deleteById(int id) {
        return _model.deleteById(id);
    }

    public M getByUserName(String username) {
        return (M) _model.findFirst("select * from " + _model.getClass().getSimpleName() + " where username =?", username);
    }

    public boolean update(M model) {
        return model.update();
    }

    public int add(M model) {
        model.save();
        return model.getInt("id");
    }
}
