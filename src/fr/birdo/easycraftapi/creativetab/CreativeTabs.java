package fr.birdo.easycraftapi.creativetab;

import fr.birdo.easycraftapi.registry.GameRegistry;
import fr.birdo.easycraftapi.item.Items;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class CreativeTabs {

    String tabLabel;
    int tabIndex;
    public static CreativeTabs[] CREATIVE_TAB_ARRAY = new CreativeTabs[1];

    public static final CreativeTabs BLOCKS = (new CreativeTabs(0, "Blocks") {
        @Override
        public Items getTabIconItem() {
            return new Items(Material.BRICKS, -1);
        }
    });

    public static final CreativeTabs REDSTONE = (new CreativeTabs(1, "Redstone") {
        @Override
        public Items getTabIconItem() {
            return new Items(Material.REDSTONE, -1);
        }
    });

    public static final CreativeTabs TRANSPORTATION = (new CreativeTabs(2, "Transportation") {
        @Override
        public Items getTabIconItem() {
            return new Items(Material.POWERED_RAIL, -1);
        }
    });

    public static final CreativeTabs BREWING = (new CreativeTabs(3, "Brewing") {
        @Override
        public Items getTabIconItem() {
            return new Items(Material.POTION, -1);
        }
    });

    public static final CreativeTabs MISCELLANEOUS = (new CreativeTabs(4, "Miscellaneous") {
        @Override
        public Items getTabIconItem() {
            return new Items(Material.LAVA_BUCKET, -1);
        }
    });

    public static final CreativeTabs FOODSTUFFS = (new CreativeTabs(5, "Foodstuffs") {
        @Override
        public Items getTabIconItem() {
            return new Items(Material.APPLE, -1);
        }
    });

    public static final CreativeTabs TOOLS = (new CreativeTabs(6, "Tools") {
        @Override
        public Items getTabIconItem() {
            return new Items(Material.IRON_AXE, -1);
        }
    });

    public static final CreativeTabs COMBAT = (new CreativeTabs(7, "Combat") {
        @Override
        public Items getTabIconItem() {
            return new Items(Material.GOLDEN_SWORD, -1);
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
        this.tabLabel = ChatColor.GOLD + label;
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