package fr.birdo.easycraftapi.entity;

import fr.birdo.easycraftapi.advancement.Advancement;
import fr.birdo.easycraftapi.advancement.Advancements;
import fr.birdo.easycraftapi.inventory.GuiScreen;
import fr.birdo.easycraftapi.item.Item;
import fr.birdo.easycraftapi.registry.GameRegistry;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import java.util.*;

public class PlayerHelper{

    public static void displayGui(Player playerIn, int guiIndex) {
        if (GameRegistry.getRegisteredGuis().get(guiIndex) != null) {
            GuiScreen guiScreen = GameRegistry.getRegisteredGuis().get(guiIndex);
            guiScreen.initGui();
            initGui(playerIn, guiScreen);
        }
    }

    public static void initGui(Player playerIn, GuiScreen guiScreen) {
        guiScreen.drawScreen();
        Inventory inventory = Bukkit.createInventory(null, guiScreen.getSize(), guiScreen.getCustomName());
        for (int i = 0; i < guiScreen.getSize(); i++) {
            if (guiScreen.getItems().containsKey(i))
                inventory.setItem(i, Item.getStackFromItem(guiScreen.getItems().get(i)));
        }
        playerIn.openInventory(inventory);
    }

    public static void updateGui(Player playerIn, GuiScreen guiScreen) {
        GuiScreen gui = new GuiScreen();
        gui.updateScreen();
        initGui(playerIn, guiScreen);
    }

    public static List<Advancement> getAdvancements(Player playerIn){
        return Advancements.getAdvancements(playerIn);
    }
}
