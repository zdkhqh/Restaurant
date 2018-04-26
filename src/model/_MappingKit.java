package model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 *
 */
public class _MappingKit {

    public static void mapping(ActiveRecordPlugin arp) {
        arp.addMapping("admin", "Id", Admin.class);
        arp.addMapping("info", "Id", Info.class);
        arp.addMapping("menu", "Id", Menu.class);
        arp.addMapping("reserve", "Id", Reserve.class);
    }
}

