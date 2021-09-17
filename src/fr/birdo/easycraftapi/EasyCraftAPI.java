package fr.birdo.easycraftapi;

import fr.birdo.easycraftapi.creative.CommandCreative;
import fr.birdo.easycraftapi.creative.GuiCreative;
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