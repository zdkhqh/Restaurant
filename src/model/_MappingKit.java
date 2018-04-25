package model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * Generated by JFinal, do not modify this file.
 * <pre>
 * Example:
 * public void configPlugin(Plugins me) {
 *     ActiveRecordPlugin arp = new ActiveRecordPlugin(...);
 *     _MappingKit.mapping(arp);
 *     me.add(arp);
 * }
 * </pre>
 */
public class _MappingKit {
	
	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("admin", "Id", Admin.class);
		arp.addMapping("info", "Id", Info.class);
		arp.addMapping("menu", "Id", Menu.class);
		arp.addMapping("reserve", "Id", Reserve.class);
	}
}

