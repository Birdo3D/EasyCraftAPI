package fr.birdo.easycraftapi.registry;

import fr.birdo.easycraftapi.EasyCraftAPI;
import fr.birdo.easycraftapi.block.Blocks;
import fr.birdo.easycraftapi.item.Items;
import fr.birdo.easycraftapi.command.Command;
import fr.birdo.easycraftapi.inventory.GuiScreen;
import fr.birdo.easycraftapi.recipe.AnvilRecipes;
import fr.birdo.easycraftapi.util.Messages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class GameRegistry {

    private static final Map<Integer, Items> registeredItems = new HashMap<>();
    private static final Map<Integer, Blocks> registeredBlocks = new HashMap<>();
    private static final Map<Integer, GuiScreen> registeredGuis = new HashMap<>();
    private static final Map<Integer, Command> registeredCommands = new HashMap<>();
    private static final List<AnvilRecipes> registeredAnvilRecipes = new ArrayList<>();

    public static void registerItem(String pluginIndex, Items item) {
        registeredItems.put(item.getId(), item);
        EasyCraftAPI.logger.log(Level.INFO, Messages.registeringItemMessage(item.getName()));
    }

    public static void registerBlock(String pluginIndex, Blocks block) {
        registeredBlocks.put(block.getId(), block);
        //instance.logger.log(Level.INFO, Messages.registeringBlockMessage(block.getName()));
    }

    public static void registerItems(String pluginIndex, Items... items) {
        for (Items item : items) {
            registeredItems.put(item.getId(), item);
            EasyCraftAPI.logger.log(Level.INFO, Messages.registeringItemMessage(item.getName()));
        }
    }

    public static void registerBlocks(String pluginIndex, Blocks... blocks) {
        for (Blocks block : blocks) {
            registeredBlocks.put(block.getId(), block);
            //instance.logger.log(Level.INFO, Messages.registeringBlockMessage(block.getName()));
        }
    }

    public static void registerRecipe(String pluginIndex, Object recipe) {
        if (recipe instanceof AnvilRecipes)
            registeredAnvilRecipes.add((AnvilRecipes) recipe);
    }

    public static void registerGui(String pluginIndex, GuiScreen gui, int index) {
        registeredGuis.put(index, gui);
    }

    public static void registerCommand(String pluginIndex, Command command) {
        registeredCommands.put(command.getCommandIndex(), command);
    }

    public static Map<Integer, Items> getRegisteredItems() {
        return registeredItems;
    }

    public static Map<Integer, Blocks> getRegisteredBlocks() {
        return registeredBlocks;
    }

    public static Map<Integer, GuiScreen> getRegisteredGuis() {
        return registeredGuis;
    }

    public static Map<Integer, Command> getRegisteredCommands() {
        return registeredCommands;
    }

    public static List<AnvilRecipes> getRegisteredAnvilRecipes() {
        return registeredAnvilRecipes;
    }
}