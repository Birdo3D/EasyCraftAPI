package fr.birdo.easycraftapi;

import fr.birdo.easycraftapi.util.GuiScreen;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class EventHandler implements Listener {

    public EventHandler(EasyCraftAPI easyCraftAPI) {
    }

    @org.bukkit.event.EventHandler
    public void onGuiClicked(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player)
            GuiScreen.buttonIsPressed((Player) event.getWhoClicked(), event.getView(), event.getCurrentItem());
    }
}