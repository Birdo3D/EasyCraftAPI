package fr.birdo.easycraftapi;

import fr.birdo.easycraftapi.creative.CommandCreative;
import fr.birdo.easycraftapi.creative.CreativeTabs;
import fr.birdo.easycraftapi.util.Command;
import fr.birdo.easycraftapi.util.GuiScreen;
import fr.birdo.easycraftapi.util.Random;
import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.Map;

public class GameRegistry {

    public static final Map<Integer, Items> registeredItems = new HashMap<>();
    public static final Map<Integer, CreativeTabs> registeredCreativeTabs = new HashMap<>();
    public static final Map<Integer, GuiScreen> registeredGuis = new HashMap<>();
    public static final Map<Integer, Command> registeredCommands = new HashMap<>();

    public void registerItems(Items item) {
        registeredItems.put(item.getId(), item);
        isBeingRegistryMessage(item);
    }

    public void registerAllItems(Items... items) {
        for (Items item : items) {
            registeredItems.put(item.getId(), item);
            isBeingRegistryMessage(item);
        }
    }

    public void registerCreativeTab(CreativeTabs tab) {
        registeredCreativeTabs.put(registeredCreativeTabs.size(), tab);
        isBeingRegistryMessage(tab);
    }

    public void registerGui(GuiScreen gui, int index) {
        registeredGuis.put(index, gui);
        isBeingRegistryMessage(gui);
    }

    public void registerCommand(Command command) {
        registeredCommands.put(Random.roll(0, 1555), command);
    }

    public void isBeingRegistryMessage(Items item) {
        System.out.println("[EasyCraftAPI] " + ChatColor.GOLD + "Registering Item " + item.getName() + "...");
    }

    public void isBeingRegistryMessage(CreativeTabs tab) {
        System.out.println("[EasyCraftAPI] " + ChatColor.GOLD + "Registering CreativeTab " + tab.getTabName() + "...");
    }

    public void isBeingRegistryMessage(GuiScreen guiScreen) {
        System.out.println("[EasyCraftAPI] " + ChatColor.GOLD + "Registering GuiScreen " + guiScreen.getCustomName() + "...");
    }
}