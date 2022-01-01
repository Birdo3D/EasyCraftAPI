package fr.birdo.easycraftapi.entity;

import fr.birdo.easycraftapi.advancement.Advancement;
import fr.birdo.easycraftapi.inventory.GuiScreen;
import fr.birdo.easycraftapi.item.Item;
import fr.birdo.easycraftapi.registry.GameRegistry;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.util.List;

public abstract class Player implements org.bukkit.entity.Player {

    public void displayGui(int guiIndex) {
        if (GameRegistry.getRegisteredGuis().get(guiIndex) != null) {
            GuiScreen guiScreen = GameRegistry.getRegisteredGuis().get(guiIndex);
            guiScreen.initGui();
            initGui(guiScreen);
        }
    }

    private void initGui(GuiScreen guiScreen) {
        guiScreen.drawScreen();
        Inventory inventory = Bukkit.createInventory(null, guiScreen.getSize(), guiScreen.getCustomName());
        for (int i = 0; i < guiScreen.getSize(); i++) {
            if (guiScreen.getItems().containsKey(i))
                inventory.setItem(i, Item.getStackFromItem(guiScreen.getItems().get(i)));
        }
        this.openInventory(inventory);
    }

    public void updateGui(GuiScreen guiScreen) {
        GuiScreen gui = new GuiScreen();
        gui.updateScreen();
        initGui(guiScreen);
    }

    public List<Advancement> getAdvancements(){
        return Advancement.getAdvancements(this);
    }
}
