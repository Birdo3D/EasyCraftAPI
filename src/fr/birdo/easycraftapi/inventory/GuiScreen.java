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
    private final Map<Integer, GuiButton> buttons = new HashMap<>();
    private final List<Integer> pickable = new ArrayList<>();
    private final Map<Integer, Items> items = new HashMap<>();

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

    public GuiButton getButtonById(int index) {
        return this.buttons.get(index);
    }

    public void buttonIsPressed(Player player, GuiScreen gui, int slotIndex) {
        if (isButton(gui, slotIndex)) {
            for (GuiButton guiButton : gui.getButtons().values()) {
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

    public Boolean isItemPickable(int slotIndex) {
        return pickable.contains(slotIndex);
    }

    public boolean isButton(GuiScreen guiScreen, int slotIndex) {
        if (guiScreen != null && guiScreen.getButtons().size() != 0)
            for (int i : guiScreen.getButtons().keySet())
                if (guiScreen.getButtons().get(i).getPos() == slotIndex)
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

    private Map<Integer, GuiButton> getButtons() {
        return buttons;
    }

    public static int getId(GuiScreen gui) {
        for (int i : GameRegistry.registeredGuis.keySet()) {
            if (GameRegistry.registeredGuis.get(i) == gui) {
                return i;
            }
        }
        return -1;
    }

    public Map<Integer, Items> getItems(){
        return this.items;
    }
}
