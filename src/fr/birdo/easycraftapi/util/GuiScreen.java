package fr.birdo.easycraftapi.util;

import fr.birdo.easycraftapi.GameRegistry;
import fr.birdo.easycraftapi.Items;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class GuiScreen {

    private int index;
    private int size;
    private String customName;
    private static final Map<Integer, GuiButton> buttons = new HashMap<>();
    private static final Map<Integer, Items> items = new HashMap<>();

    public void initGui() {
        this.customName = this.getCustomName();
    }

    public static void updateScreen(int tick) {
    }

    public void drawScreen() {
    }

    public GuiScreen setGuiSize(int guiSize) {
        this.size = guiSize;
        return this;
    }

    public void onButtonPressed(int buttonIndex) {
    }

    public int getId() {
        return this.index;
    }

    public int getSize() {
        return this.size;
    }

    public String getCustomName() {
        return this.customName;
    }

    public void addButton(GuiButton button) {
        buttons.put(button.getId(), button);
        items.put(button.getPos(), button.getItem());
    }

    public void addItem(Items item, int pos) {
        items.put(pos, item);
    }

    public void addText(GuiText text) {
        items.put(text.getPos(), text.getItem());
    }

    public static GuiButton getButtonById(int index) {
        return buttons.get(index);
    }

    public static void buttonIsPressed(Player player, InventoryView view, ItemStack stack) {
        //if (view.getTitle().equalsIgnoreCase(customName)) {
            for (GuiButton guiButton : buttons.values()) {
                //if (stack.isSimilar(Item.getStackFromItem(guiButton.getItem()))) {
                GuiScreen guiScreen = new GuiScreen();
                guiScreen.onButtonPressed(guiButton.getId());
                break;
                //}
            }
        //}
    }
}
