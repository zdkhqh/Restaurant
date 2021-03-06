package model;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseInfo<M extends BaseInfo<M>> extends Model<M> implements IBean {

    public M setId(java.lang.Integer Id) {
        set("Id", Id);
        return (M) this;
    }

    public java.lang.Integer getId() {
        return getInt("Id");
    }

    public M setTitle(java.lang.String title) {
        set("title", title);
        return (M) this;
    }

    public java.lang.String getTitle() {
        return getStr("title");
    }

    public M setContent(java.lang.String content) {
        set("content", content);
        return (M) this;
    }

    public java.lang.String getContent() {
        return getStr("content");
    }

    public M setPic(java.lang.String pic) {
        set("pic", pic);
        return (M) this;
    }

    public java.lang.String getPic() {
        return getStr("pic");
    }

    public M setTime(java.util.Date time) {
        set("time", time);
        return (M) this;
    }

    public java.util.Date getTime() {
        return getDate("time");
    }

    public M setType(java.lang.Integer type) {
        set("type", type);
        return (M) this;
    }

    public java.lang.Integer getType() {
        return getInt("type");
    }

}
