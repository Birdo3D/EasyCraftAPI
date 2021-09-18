package fr.birdo.easycraftapi;

import fr.birdo.easycraftapi.command.CommandCreative;
import fr.birdo.easycraftapi.inventory.GuiCreative;
import fr.birdo.easycraftapi.registry.EventHandler;
import fr.birdo.easycraftapi.registry.GameRegistry;
import fr.birdo.easycraftapi.util.Messages;
import fr.birdo.easycraftapi.util.Ticking;
import org.bukkit.plugin.java.JavaPlugin;

public class EasyCraftAPI extends JavaPlugin {

    public static GameRegistry GAME_REGISTRY = new GameRegistry();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventHandler(this), this);
        getServer().getPluginManager().registerEvents(new Ticking(this), this);
        GAME_REGISTRY.registerCommand("api", new CommandCreative());
        GAME_REGISTRY.registerGui("api", new GuiCreative(), 1);
        Ticking.tick();
        Messages.printMessage(Messages.enableMessage);
    }

    @Override
    public void onDisable() {
        Messages.printMessage(Messages.disableMessage);
    }
}