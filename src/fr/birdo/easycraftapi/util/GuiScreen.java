package fr.birdo.easycraftapi.util;

import fr.birdo.easycraftapi.Items;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuiScreen {

    private int size;
    private static String customName;
    private static final Map<Integer, GuiButton> buttons = new HashMap<>();
    private static final List<Integer> pickable = new ArrayList<>();
    public static final Map<Integer, Items> items = new HashMap<>();

    public void initGui() {
        customName = this.getCustomName();
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

    public int getSize() {
        return this.size;
    }

    public String getCustomName() {
        return " ";
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

    public static void buttonIsPressed(Player player, InventoryView view, int slotIndex) {
        if (view.getTitle().equalsIgnoreCase(customName)) {
            for (GuiButton guiButton : buttons.values()) {
                if (isButton(slotIndex)) {
                    GuiScreen guiScreen = new GuiScreen();
                    guiScreen.onButtonPressed(guiButton.getId());
                    break;
                }
            }
        }
    }

    public GuiScreen setItemPickable(int slotIndex) {
        this.pickable.add(slotIndex);
        return this;
    }

    public GuiScreen setItemPickable(int[] slotsIndex) {
        for (int i : slotsIndex)
            this.pickable.add(i);
        return this;
    }

    public static boolean isItemPickable(int slotIndex) {
        return pickable.contains(slotIndex);
    }

    public static boolean isButton(int slotIndex) {
        for (int i = 0; i < buttons.size(); i++)
            if (buttons.get(i).getPos() == slotIndex)
                return true;
        return false;
    }
}
