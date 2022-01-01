package fr.birdo.easycraftapi.util;

import fr.birdo.easycraftapi.EasyCraftAPI;
import fr.birdo.easycraftapi.block.Blocks;
import fr.birdo.easycraftapi.inventory.GuiScreen;
import fr.birdo.easycraftapi.item.Items;
import fr.birdo.easycraftapi.registry.GameRegistry;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class Ticking implements Listener {

    private static EasyCraftAPI instance;
    private static int count;

    public Ticking(EasyCraftAPI easyCraftAPI) {
        instance = easyCraftAPI;
    }

    public static void tick() {
        count = Bukkit.getScheduler().scheduleSyncRepeatingTask(instance, () -> {
            for (Items item : GameRegistry.getRegisteredItems().values())
                item.onTick(count);
            for (Blocks block : GameRegistry.getRegisteredBlocks().values())
                block.onTick(count);
            for (GuiScreen guiScreen : GameRegistry.getRegisteredGuis().values())
                guiScreen.onTick(count);
            if (count > 1000000000)
                count = 0;
        }, 0L, 1L);
    }
}
