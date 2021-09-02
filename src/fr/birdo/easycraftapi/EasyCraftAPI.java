package fr.birdo.easycraftapi;

import org.bukkit.plugin.java.JavaPlugin;

public class EasyCraftAPI extends JavaPlugin {

    public static EasyCraftAPI INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
    }

    @Override
    public void onDisable() {

    }
}