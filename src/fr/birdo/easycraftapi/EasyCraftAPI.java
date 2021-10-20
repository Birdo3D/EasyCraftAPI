package fr.birdo.easycraftapi;

import fr.birdo.easycraftapi.command.CommandCreative;
import fr.birdo.easycraftapi.inventory.GuiCreative;
import fr.birdo.easycraftapi.item.Items;
import fr.birdo.easycraftapi.registry.EventHandler;
import fr.birdo.easycraftapi.registry.GameRegistry;
import fr.birdo.easycraftapi.util.Messages;
import fr.birdo.easycraftapi.util.Ticking;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EasyCraftAPI extends JavaPlugin {

    public static final String NAME = "EasyCraftApi";
    public static final String PLUGINID = "api";
    public static final String VERSION = "1.0-BETA";
    public static Logger logger = Bukkit.getLogger();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventHandler(this), this);
        getServer().getPluginManager().registerEvents(new Ticking(this), this);
        saveDefaultConfig();
        vanillaRegistering();
        GameRegistry.registerCommand(PLUGINID, new CommandCreative());
        GameRegistry.registerGui(PLUGINID, new GuiCreative(), 0);
        Ticking.tick();
        logger.log(Level.INFO, Messages.enableMessage(VERSION));
    }

    @Override
    public void onDisable() {
        logger.log(Level.INFO, Messages.disableMessage);
    }

    private void vanillaRegistering() {
        GameRegistry.registerItem(PLUGINID, Items.DIAMOND);
    }
}