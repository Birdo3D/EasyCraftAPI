package fr.birdo.easycraftapi.util;

import fr.birdo.easycraftapi.EasyCraftAPI;
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
            GuiScreen.updateScreen(count);
            if (count > 1000000000)
                count = 0;
        }, 0L, 1L);
    }
}
