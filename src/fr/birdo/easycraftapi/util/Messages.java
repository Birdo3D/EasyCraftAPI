package fr.birdo.easycraftapi.util;

import org.bukkit.ChatColor;

public class Messages {

    private static final String pluginTag = ChatColor.AQUA + "[EasyCraftAPI] ";

    public static String enableMessage = pluginTag + "DEBUG : LOADED";

    public static String disableMessage = pluginTag + "DEBUG : UNLOADED";

    public static void printMessage(String message) {
        System.out.println(message);
    }
}