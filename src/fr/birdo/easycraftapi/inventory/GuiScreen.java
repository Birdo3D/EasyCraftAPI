package fr.birdo.easycraftapi.inventory;

import fr.birdo.easycraftapi.entity.PlayerHelper;
import fr.birdo.easycraftapi.item.Items;
import fr.birdo.easycraftapi.registry.GameRegistry;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuiScreen extends PlayerHelper {

    private int size;
    private static final Map<Integer, GuiButton> buttons = new HashMap<>();
    private static final List<Integer> pickable = new ArrayList<>();
    public static final Map<Integer, Items> items = new HashMap<>();

    public void initGui() {
    }

    public void updateScreen() {
        buttons.clear();
        pickable.clear();
        items.clear();
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

    public static void buttonIsPressed(Player player, GuiScreen gui, int slotIndex) {
        if (isButton(slotIndex)) {
            for (GuiButton guiButton : buttons.values()) {
                if (guiButton.getPos() == slotIndex) {
                    gui.onButtonPressed(guiButton.getId());
                    PlayerHelper.updateGui(player, gui);
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
        for (int i : buttons.keySet())
            if (buttons.get(i).getPos() == slotIndex)
                return true;
        return false;
    }

    public Items setItemInCursor() {
        return null;
    }

    public int setItemInCursorAmount() {
        return 0;
    }

    public void itemHasBeenSetInCursor(Items item, int quantity) {
    }

    public void onTick(int tick) {
    }

    public static int getIdByName(String name) {
        for (int i : GameRegistry.registeredGuis.keySet()) {
            if (GameRegistry.registeredGuis.get(i).getCustomName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public static int getId(GuiScreen gui) {
        for (int i : GameRegistry.registeredGuis.keySet()) {
            if (GameRegistry.registeredGuis.get(i) == gui) {
                return i;
            }
        }
        return -1;
    }
}
