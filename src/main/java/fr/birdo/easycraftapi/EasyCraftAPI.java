package fr.birdo.easycraftapi;

import fr.birdo.easycraftapi.advancement.AdvancementEvent;
import fr.birdo.easycraftapi.advancement.AdvancementFile;
import fr.birdo.easycraftapi.command.CommandCreative;
import fr.birdo.easycraftapi.inventory.GuiCreative;
import fr.birdo.easycraftapi.item.Items;
import fr.birdo.easycraftapi.registry.EventHandler;
import fr.birdo.easycraftapi.registry.GameRegistry;
import fr.birdo.easycraftapi.util.Messages;
import fr.birdo.easycraftapi.util.Ticking;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EasyCraftAPI extends JavaPlugin {

    public static final String NAME = "EasyCraftApi";
    public static final String PLUGINID = "api";
    public static final String VERSION = "1.3-BETA";
    public static Logger logger = Bukkit.getLogger();

    @Override
    public void onEnable() {
        //Log version
        logger.log(Level.INFO, Messages.enableMessage(VERSION));

        //Register Events Handlers
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new EventHandler(this), this);
        pm.registerEvents(new Ticking(this), this);
        pm.registerEvents(new AdvancementEvent(this), this);

        //GameRegistry
        GameRegistry.registerCommand(this, new CommandCreative());
        GameRegistry.registerGui(PLUGINID, new GuiCreative(), 0);

        saveDefaultConfig();
        vanillaRegistering();

        Ticking.tick();

        //Init temp advancements files
        AdvancementFile.clear();
    }

    @Override
    public void onDisable() {
        logger.log(Level.INFO, Messages.disableMessage);

        //Clear temp advancements files
        AdvancementFile.clear();
    }

    private void vanillaRegistering() {
        GameRegistry.registerItem(PLUGINID, Items.DIAMOND);
    }
}