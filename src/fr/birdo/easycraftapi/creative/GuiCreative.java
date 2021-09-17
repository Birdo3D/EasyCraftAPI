package fr.birdo.easycraftapi.creative;

import fr.birdo.easycraftapi.Items;
import fr.birdo.easycraftapi.util.GuiButton;
import fr.birdo.easycraftapi.util.GuiScreen;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class GuiCreative extends GuiScreen {

    private int size;
    private int creativeTab = 0;
    private String tabName;
    private final int[] tabsSlots = new int[]{9, 17, 18, 26, 27, 35, 36, 44};
    private final int[] itemsSlots = new int[]{0, 1, 2};
    private final int[] indicatorSlot = new int[]{10, 16, 19, 25, 28, 34, 37, 43};

    public void initGui() {
        this.size = 6 * 9;
    }

    public void drawScreen() {
        setGuiSize(this.size);
        for (int i = 0; i < CreativeTabs.getNextID(); i++) {
            CreativeTabs creativeTabs = CreativeTabs.getTabById(i);
            addButton(new GuiButton(CreativeTabs.getTabById(i).getTabIconItem().setName(CreativeTabs.getTabById(i).getTabName()), creativeTabs.getId(), this.tabsSlots[i]));
        }
        if (creativeTab == 0) {
            addItem(new Items(Material.GREEN_STAINED_GLASS_PANE, -1).setName(" "), indicatorSlot[0]);
            for (int i = 1; i < indicatorSlot.length; i++)
                addItem(new Items(Material.GRAY_STAINED_GLASS_PANE, -1).setName(" "), indicatorSlot[i]);
        }
        for (int i = 0; i < 9; i++)
            addItem(new Items(Material.GRAY_STAINED_GLASS_PANE, -1).setName(" "), i);
    }

    @Override
    public String getCustomName() {
        if (tabName == null)
            return ChatColor.BOLD + "Creative Inventory";
        return ChatColor.BOLD + "Creative Inventory" + tabName;
    }

    public void onButtonPressed(int buttonIndex) {
        this.tabName = " " + GuiScreen.getButtonById(buttonIndex).getItem().getName();
        this.creativeTab = buttonIndex;
        int indicatorSlot = 0;
        for (int tabsSlot : this.indicatorSlot) {
            if (GuiScreen.getButtonById(buttonIndex).getPos() - 1 == tabsSlot) {
                indicatorSlot = GuiScreen.getButtonById(buttonIndex).getPos() - 1;
                break;
            } else {
                indicatorSlot = GuiScreen.getButtonById(buttonIndex).getPos() + 1;
            }
        }
        for (int i = 0; i < CreativeTabs.displayAllRelevantItems(CreativeTabs.getTabById(buttonIndex)).size(); i++) {
            addItem(CreativeTabs.displayAllRelevantItems(CreativeTabs.getTabById(buttonIndex)).get(i), this.itemsSlots[i]);
        }
        for (int i : this.indicatorSlot) {
            if (i != indicatorSlot)
                addItem(new Items(Material.GRAY_STAINED_GLASS_PANE, -1).setName(" "), i);
        }
        addItem(new Items(Material.GREEN_STAINED_GLASS_PANE, -1).setName(" "), indicatorSlot);
    }
}