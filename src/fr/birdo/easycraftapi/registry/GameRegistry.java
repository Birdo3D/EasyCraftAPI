package fr.birdo.easycraftapi.registry;

import fr.birdo.easycraftapi.EasyCraftAPI;
import fr.birdo.easycraftapi.item.Items;
import fr.birdo.easycraftapi.command.Command;
import fr.birdo.easycraftapi.inventory.GuiScreen;
import fr.birdo.easycraftapi.util.Messages;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class GameRegistry {

    public static final Map<Integer, Items> registeredItems = new HashMap<>();
    public static final Map<Integer, GuiScreen> registeredGuis = new HashMap<>();
    public static final Map<Integer, Command> registeredCommands = new HashMap<>();

    private static EasyCraftAPI instance;

    public GameRegistry(EasyCraftAPI easyCraftAPI) {
        instance = easyCraftAPI;
    }

    public GameRegistry() {
    }

    public void vanillaRegistering() {
        //Items
        instance.logger.log(Level.INFO, Messages.registeringVanillaItemsMessage);

        registerVanillaItems(Items.DIAMOND);
    }

    public void registerItem(String pluginIndex, Items item) {
        registeredItems.put(item.getId(), item);
        instance.logger.log(Level.INFO, Messages.registeringItemMessage(item.getName()));
    }

    public void registerAllItems(String pluginIndex, Items... items) {
        for (Items item : items) {
            registeredItems.put(item.getId(), item);
            instance.logger.log(Level.INFO, Messages.registeringItemMessage(item.getName()));
        }
    }

    public void registerGui(String pluginIndex, GuiScreen gui, int index) {
        registeredGuis.put(index, gui);
    }

    public void registerCommand(String pluginIndex, Command command) {
        registeredCommands.put(command.getCommandIndex(), command);
    }

    public void registerVanillaItems(Items item) {
        registeredItems.put(item.getId(), item);
    }
}