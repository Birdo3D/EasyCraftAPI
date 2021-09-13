package fr.birdo.easycraftapi;

import fr.birdo.easycraftapi.creative.CommandCreative;
import fr.birdo.easycraftapi.creative.GuiCreative;
import fr.birdo.easycraftapi.util.Command;
import fr.birdo.easycraftapi.util.Ticking;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class EasyCraftAPI extends JavaPlugin {

    public Items items;
    public GameRegistry gameRegistry;
    public GuiCreative gui = new GuiCreative();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventHandler(this), this);
        getServer().getPluginManager().registerEvents(new Ticking(this), this);
        getServer().getPluginManager().registerEvents(new Command(this), this);
        items = new Items();
        gameRegistry = new GameRegistry();
        Ticking.tick();
        new CommandCreative();
        gameRegistry.registerGui(gui, 1);
    }

    @Override
    public void onDisable() {

    }

    public void displayGui(Player playerIn, int index) {
        Inventory inventory = Bukkit.createInventory(null, 6*9, GameRegistry.registeredGuis.get(index).getCustomName());
        /*for (int i = 0; i < 81; i++) {
            if (items.containsKey(i))
                inventory.setItem(i, Item.getStackFromItem(items.get(i)));
        }*/
        GameRegistry.registeredGuis.get(index).initGui();
        GameRegistry.registeredGuis.get(index).drawScreen();
        playerIn.openInventory(inventory);
    }
}