package fr.birdo.easycraftapi.registry;

import fr.birdo.easycraftapi.block.Blocks;
import fr.birdo.easycraftapi.item.ItemBlock;
import fr.birdo.easycraftapi.item.Items;
import fr.birdo.easycraftapi.creativetab.CreativeTabs;
import fr.birdo.easycraftapi.command.Command;
import fr.birdo.easycraftapi.inventory.GuiScreen;
import fr.birdo.easycraftapi.util.Messages;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameRegistry {

    public static final Map<Integer, Items> registeredItems = new HashMap<>();
    public static final Map<Integer, GuiScreen> registeredGuis = new HashMap<>();
    public static final Map<String, GuiScreen> registeredGuisByName = new HashMap<>();
    public static final Map<Integer, Blocks> registeredBlocks = new HashMap<>();
    public static final Map<Integer, Command> registeredCommands = new HashMap<>();

    public void vanillaRegistering() {
        //Items
        Messages.printMessage(Messages.registeringVanillaItemsMessage);
        registerVanillaItems(Items.DIAMOND);

        //ItemBlocks
        registerVanillaItems(Items.STONE_ITEM);
        registerVanillaItems(Items.GRANITE_ITEM);
        registerVanillaItems(Items.POLISHED_GRANITE_ITEM);
        registerVanillaItems(Items.DIORITE_ITEM);
        registerVanillaItems(Items.POLISHED_DIORITE_ITEM);
        registerVanillaItems(Items.ANDESITE_ITEM);
        registerVanillaItems(Items.POLISHED_ANDESITE_ITEM);

        registerVanillaItems(Items.DIAM1OND);
        registerVanillaItems(Items.DIA1MOND);
        registerVanillaItems(Items.DIAM11OND);
        registerVanillaItems(Items.DI1AMOND);
        registerVanillaItems(Items.DIAMO1ND);
        registerVanillaItems(Items.DIAM11ON1D);
        registerVanillaItems(Items.D1IAM1OND);
        registerVanillaItems(Items.DIA1MO1ND);
        registerVanillaItems(Items.DIAM111ND);
        registerVanillaItems(Items.DIA5MO1ND);
        registerVanillaItems(Items.DIAM511ON1D);
        registerVanillaItems(Items.D1I5AM1OND);
        registerVanillaItems(Items.DIA1MO15ND);
        registerVanillaItems(Items.DIAM1115ND);

        //Blocks
        Messages.printMessage(Messages.registeringVanillaBlocksMessage);
        registerVanillaBlocks(Blocks.STONE);
    }

    public void registerItems(String pluginIndex, Items item) {
        registeredItems.put(item.getId(), item);
        Messages.printMessage(Messages.registeringItemMessage(item.getName()));
    }

    public void registerAllItems(String pluginIndex, Items... items) {
        for (Items item : items) {
            registeredItems.put(item.getId(), item);
            Messages.printMessage(Messages.registeringItemMessage(item.getName()));
        }
    }

    public void registerGui(String pluginIndex, GuiScreen gui, int index) {
        registeredGuis.put(index, gui);
        registeredGuisByName.put(gui.getCustomName(), gui);
        Messages.printMessage(Messages.registeringGuiMessage(gui.getCustomName()));
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