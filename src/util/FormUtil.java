package util;

import com.jfinal.kit.StrKit;

import java.util.HashMap;
import java.util.Map;


/**
 * 分页表单参数类
 */
public class FormUtil extends HashMap<String, String> {
    private int pageSize = 10; //分页大小
    private int pageNumber = 1; //当前页面
    private String orderName = "id";
    private String orderType = "ASC";

    public FormUtil() {
    }

    public FormUtil(Map<String, String[]> requestParameterMap) {
        for (Entry<String, String[]> entry : requestParameterMap.entrySet()) {
            put(entry.getKey(), entry.getValue()[0]);
        }
        paraInit();
    }

    //处理 a/1/b/2的情况
    public FormUtil(String requestUrl) {
        String[] list = requestUrl.split("\\/");
        if (list.length > 1) {
            for (int i = 0; i < list.length; i += 2) {
                put(list[i], list[i + 1]);
            }
        }
        paraInit();
    }

    private void paraInit() {
        //如果有页码
        if (containsKey("page_number") && StrKit.notBlank(get("page_number"))) {
            pageNumber = getInt("page_number");
        }

        //如果有分页大小
        if (containsKey("page_size") && StrKit.notBlank(get("page_size"))) {
            pageSize = getInt("page_size");
        }

        //如果有排序
        if (containsKey("order_name") && StrKit.notBlank(get("order_name"))) {
            orderName = get("order_name");
        }

        //如果有排序类型
        if (containsKey("order_type") && StrKit.notBlank(get("order_type"))) {
            orderType = get("order_type");
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getOrderName() {
        return orderName;
    }

    public FormUtil setOrderName(String orderName) {
        this.orderName = orderName;
        return this;
    }

    public String getOrderType() {
        return orderType;
    }

    public FormUtil setOrderType(String orderType) {
        this.orderType = orderType;
        return this;
    }


    public String getPara(String name) {
        return get(name);
    }

    public String getPara(String name, String defaultValue) {
        if (get(name) == null) return defaultValue;
        else return get(name);
    }



    private Integer toInt(String value, Integer defaultValue) {
        if (StrKit.isBlank(value)) {
            return defaultValue;
        } else {
            value = value.trim();
            return !value.startsWith("N") &&
                    !value.startsWith("n") ?
                    Integer.valueOf(Integer.parseInt(value)) :
                    Integer.valueOf(-Integer.parseInt(value.substring(1)));
        }
    }

    public Integer getInt(String name) {
        return this.toInt(get(name), (Integer) null);
    }

    public Integer getInt(String name, Integer defaultValue) {
        return this.toInt(get(name), defaultValue);
    }

    private Long toLong(String value, Long defaultValue) {
        if (StrKit.isBlank(value)) {
            return defaultValue;
        } else {
            value = value.trim();
            return !value.startsWith("N") &&
                    !value.startsWith("n") ?
                    Long.valueOf(Long.parseLong(value)) :
                    Long.valueOf(-Long.parseLong(value.substring(1)));
        }
    }

    public Long getLong(String name) {
        return this.toLong(get(name), (Long) null);
    }

    public Long getLong(String name, Long defaultValue) {
        return this.toLong(get(name), defaultValue);
    }


}
