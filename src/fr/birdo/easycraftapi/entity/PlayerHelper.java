package fr.birdo.easycraftapi.entity;

import fr.birdo.easycraftapi.inventory.GuiScreen;
import fr.birdo.easycraftapi.item.Item;
import fr.birdo.easycraftapi.registry.GameRegistry;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PlayerHelper {

    public static void displayGui(Player playerIn, int guiIndex) {
        if (GameRegistry.registeredGuis.get(guiIndex) != null) {
            GuiScreen guiScreen = GameRegistry.registeredGuis.get(guiIndex);
            guiScreen.initGui();
            guiScreen.drawScreen();
            Inventory inventory = Bukkit.createInventory(null, guiScreen.getSize(), guiScreen.getCustomName());
            for (int i = 0; i < guiScreen.getSize(); i++) {
                if (guiScreen.getItems().containsKey(i))
                    inventory.setItem(i, Item.getStackFromItem(guiScreen.getItems().get(i)));
            }
            playerIn.openInventory(inventory);
        }
    }

    protected static void updateGui(Player playerIn, GuiScreen guiScreen) {
        GuiScreen gui = new GuiScreen();
        gui.updateScreen();
        guiScreen.drawScreen();
        Inventory inventory = Bukkit.createInventory(null, guiScreen.getSize(), guiScreen.getCustomName());
        for (int i = 0; i < guiScreen.getSize(); i++) {
            if (guiScreen.getItems().containsKey(i))
                inventory.setItem(i, Item.getStackFromItem(guiScreen.getItems().get(i)));
        }
        playerIn.openInventory(inventory);
    }
}
