package fr.birdo.easycraftapi.inventory;

import fr.birdo.easycraftapi.item.Items;
import fr.birdo.easycraftapi.creativetab.CreativeTabs;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class GuiCreative extends GuiScreen {

    private int size;
    private int creativeTab = 0;
    private int itemsPage;
    private int tabPage;
    private int indicatorSlot;
    private final int[] tabsSlots = new int[]{9, 17, 18, 26, 27, 35, 36, 44};
    private final List<Integer> itemsSlots = new ArrayList<>();
    private final int[] indicatorSlots = new int[]{10, 16, 19, 25, 28, 34, 37, 43};

    public void initGui() {
        //this.creativeTab = 0;
        this.indicatorSlot = 10;
        this.tabPage = 0;
        this.itemsPage = 0;
        this.size = 6 * 9;
        itemsSlots.clear();
        for (int i = 11; i < 43; i++) {
            if (i != 16 && i != 17 && i != 18 && i != 19 && i != 25 && i != 26 && i != 27 && i != 28 && i != 34 && i != 35 && i != 36 && i != 37)
                itemsSlots.add(i);
        }
    }

    public void drawScreen() {
        //Set gui size
        setGuiSize(this.size);
        //Draw creative tabs buttons
        for (int i = 0; i < CreativeTabs.getNextID(); i++) {
            CreativeTabs creativeTabs = CreativeTabs.getTabById(i);
            addButton(new GuiButton(CreativeTabs.getTabById(i).getTabIconItem().setName(CreativeTabs.getTabById(i).getTabName()), creativeTabs.getId() + 2, this.tabsSlots[i]));
        }
        addItem(new Items(Material.GREEN_STAINED_GLASS_PANE, -1).setName(" "), indicatorSlot);
        //Draw tab indicator
        for (int i : this.indicatorSlots) {
            if (i != indicatorSlot)
                addItem(new Items(Material.GRAY_STAINED_GLASS_PANE, -1).setName(" "), i);
        }
        //Draw top
        for (int i = 0; i < 9; i++)
            addItem(new Items(Material.GRAY_STAINED_GLASS_PANE, -1).setName(" "), i);
        //Draw bottom
        for (int i = 45; i < 54; i++) {
            if ((CreativeTabs.displayAllRelevantItems(CreativeTabs.getTabById(this.creativeTab)).size() / 20) + 1 > 1) {
                if (i == 48 && this.itemsPage > 0) {
                    addButton(new GuiButton(new Items(Material.BROWN_STAINED_GLASS_PANE, -1).setName(ChatColor.DARK_GREEN + "Page Précédante"), 0, i));
                } else if (i == 50 && this.itemsPage < CreativeTabs.displayAllRelevantItems(CreativeTabs.getTabById(this.creativeTab)).size() / 20) {
                    addButton(new GuiButton(new Items(Material.BROWN_STAINED_GLASS_PANE, -1).setName(ChatColor.DARK_GREEN + "Page Suivante"), 1, i));
                } else {
                    addItem(new Items(Material.GRAY_STAINED_GLASS_PANE, -1).setName(" "), i);
                }
            } else {
                addItem(new Items(Material.GRAY_STAINED_GLASS_PANE, -1).setName(" "), i);
            }
        }
        //Display items
        for (int i = this.itemsPage * 20; i < this.itemsPage * 20 + 20; i++)
            if (i < CreativeTabs.displayAllRelevantItems(CreativeTabs.getTabById(this.creativeTab)).size())
                addItem(CreativeTabs.displayAllRelevantItems(CreativeTabs.getTabById(this.creativeTab)).get(i), this.itemsSlots.get(i - (this.itemsPage * 20)));
    }

    @Override
    public String getCustomName() {
        return ChatColor.BOLD + "Creative Inventory";
    }

    public void onButtonPressed(int buttonIndex) {
        switch (buttonIndex) {
            case 0:
                this.itemsPage--;
                break;
            case 1:
                this.itemsPage++;
                break;
            default:
                this.creativeTab = buttonIndex - 2;
                for (int tabsSlot : this.indicatorSlots) {
                    if (GuiScreen.getButtonById(buttonIndex).getPos() - 1 == tabsSlot) {
                        indicatorSlot = GuiScreen.getButtonById(buttonIndex).getPos() - 1;
                        break;
                    } else {
                        indicatorSlot = GuiScreen.getButtonById(buttonIndex).getPos() + 1;
                    }
                }
        }
    }
}