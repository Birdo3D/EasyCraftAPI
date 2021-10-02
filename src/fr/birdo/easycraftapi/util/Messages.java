package fr.birdo.easycraftapi.util;

import fr.birdo.easycraftapi.EasyCraftAPI;

public class Messages {

    private static final String pluginTag = "[" + EasyCraftAPI.NAME + "] ";

    public static String enableMessage(String version) {
        return pluginTag + "DEBUG : PLUGIN LOADED";
    }

    public static String disableMessage = pluginTag + "DEBUG : PLUGIN UNLOADED";

    public static String registeringVanillaItemsMessage = pluginTag + "Registering Vanilla Items...";

    public static String registeringVanillaBlocksMessage = pluginTag + "Registering Vanilla Blocks...";

    public static String registeringItemMessage(String itemName) {
        return pluginTag + "Registering Item " + itemName + "...";
    }

    public static String registeringBlockMessage(String blockName) {
        return pluginTag + "Registering Block " + blockName + "...";
    }
}