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

    public static final Map<Integer, Items> registeredItems = new HashMap<>();
    public static final Map<Integer, Blocks> registeredBlocks = new HashMap<>();
    public static final Map<Integer, GuiScreen> registeredGuis = new HashMap<>();
    public static final Map<Integer, Command> registeredCommands = new HashMap<>();
    public static final List<AnvilRecipes> registeredAnvilRecipes = new ArrayList<>();

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

    public void registerBlock(String pluginIndex, Blocks block) {
        registeredBlocks.put(block.getId(), block);
        //instance.logger.log(Level.INFO, Messages.registeringBlockMessage(block.getName()));
    }

    public void registerAllItems(String pluginIndex, Items... items) {
        for (Items item : items) {
            registeredItems.put(item.getId(), item);
            instance.logger.log(Level.INFO, Messages.registeringItemMessage(item.getName()));
        }
    }

    public void registerAllBlocks(String pluginIndex, Blocks... blocks) {
        for (Blocks block : blocks) {
            registeredBlocks.put(block.getId(), block);
            //instance.logger.log(Level.INFO, Messages.registeringBlockMessage(block.getName()));
        }
    }

    public void registerRecipe(String pluginIndex, Object recipe) {
        if (recipe instanceof AnvilRecipes)
            registeredAnvilRecipes.add((AnvilRecipes) recipe);
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

    public void registerVanillaBlocks(Blocks block) {
        registeredBlocks.put(block.getId(), block);
    }
}