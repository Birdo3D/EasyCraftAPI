package fr.birdo.easycraftapi.util;

import org.bukkit.ChatColor;

public class Messages {

    private static final String pluginTag = ChatColor.AQUA + "[EasyCraftAPI] ";

    public static String enableMessage = pluginTag + "DEBUG : LOADED";

    public static String disableMessage = pluginTag + "DEBUG : UNLOADED";

    public static String registeringVanillaItemsMessage = pluginTag + ChatColor.GOLD + "Registering Vanilla Items...";

    public static String registeringVanillaBlocksMessage = pluginTag + ChatColor.GOLD + "Registering Vanilla Blocks...";

    public static String registeringItemMessage(String itemName) {
        return pluginTag + ChatColor.GOLD + "Registering Item " + itemName + "...";
    }

    public static String registeringBlockMessage(String blockName) {
        return pluginTag + ChatColor.GOLD + "Registering Block " + blockName + "...";
    }

    public static String registeringGuiMessage(String guiName) {
        return pluginTag + ChatColor.GOLD + "Registering GuiScreen " + guiName + "...";
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}