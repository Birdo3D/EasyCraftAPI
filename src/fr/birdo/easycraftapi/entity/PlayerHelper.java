package fr.birdo.easycraftapi.entity;

import fr.birdo.easycraftapi.inventory.GuiScreen;
import fr.birdo.easycraftapi.item.Item;
import fr.birdo.easycraftapi.registry.GameRegistry;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PlayerHelper {

    public static void displayGui(Player playerIn, int guiIndex) {
        GameRegistry.registeredGuis.get(guiIndex).initGui();
        GameRegistry.registeredGuis.get(guiIndex).drawScreen();
        Inventory inventory = Bukkit.createInventory(null, GameRegistry.registeredGuis.get(guiIndex).getSize(), GameRegistry.registeredGuis.get(guiIndex).getCustomName());
        for (int i = 0; i < GameRegistry.registeredGuis.get(guiIndex).getSize(); i++) {
            if (GuiScreen.items.containsKey(i))
                inventory.setItem(i, Item.getStackFromItem(GuiScreen.items.get(i)));
        }
        playerIn.openInventory(inventory);
    }

    protected static void updateGui(Player playerIn, GuiScreen guiScreen){
        GuiScreen gui = new GuiScreen();
        gui.updateScreen();
        guiScreen.drawScreen();
        Inventory inventory = Bukkit.createInventory(null, guiScreen.getSize(), guiScreen.getCustomName());
        for (int i = 0; i < guiScreen.getSize(); i++) {
            if (GuiScreen.items.containsKey(i))
                inventory.setItem(i, Item.getStackFromItem(GuiScreen.items.get(i)));
        }
        playerIn.openInventory(inventory);
    }
}
