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
                "select\n*", "from\n" + _model.getClass().getSimpleName() + "\norder\nby\n" + formUtil.getOrderName() + "\n" + formUtil.getOrderType());
    }
}