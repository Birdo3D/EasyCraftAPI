package fr.birdo.easycraftapi.creative;

import fr.birdo.easycraftapi.GameRegistry;
import fr.birdo.easycraftapi.Items;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class CreativeTabs {

    String tabLabel;
    int tabIndex;
    public static CreativeTabs[] CREATIVE_TAB_ARRAY = new CreativeTabs[1];

    public static final CreativeTabs BUILDING_BLOCKS = (new CreativeTabs(0, "Building Blocks") {
        @Override
        public Items getTabIconItem() {
            return new Items(Material.GRASS_BLOCK, -1);
        }
    });

    public static final CreativeTabs TEST = (new CreativeTabs(1, "TEST Blocks") {
        @Override
        public Items getTabIconItem() {
            return new Items(Material.GRASS_BLOCK, -1);
        }
    });

    public CreativeTabs() {
    }

    public CreativeTabs(String label) {
        this(getNextID(), label);
    }

    public CreativeTabs(int index, String label) {
        if (index >= CREATIVE_TAB_ARRAY.length) {
            CreativeTabs[] tmp = new CreativeTabs[index + 1];
            for (int x = 0; x < CREATIVE_TAB_ARRAY.length; x++) {
                tmp[x] = CREATIVE_TAB_ARRAY[x];
            }
            CREATIVE_TAB_ARRAY = tmp;
        }
        this.tabIndex = index;
        this.tabLabel = label;
        CREATIVE_TAB_ARRAY[index] = this;
    }

    public Items getTabIconItem() {
        return new Items(Material.BARRIER, -1);
    }

    public static CreativeTabs getTabById(int index) {
        return CREATIVE_TAB_ARRAY[index];
    }

    public static List<Items> displayAllRelevantItems(CreativeTabs tab) {
        List<Items> itemsToDisplay = new ArrayList<>();
        for (Items item : GameRegistry.registeredItems.values()) {
            if (item.isInCreativeTab(tab))
                itemsToDisplay.add(item);
        }
        return itemsToDisplay;
    }

    public int getId() {
        return tabIndex;
    }

    public String getTabName() {
        return this.tabLabel;
    }

    public static int getNextID() {
        return CREATIVE_TAB_ARRAY.length;
    }
}