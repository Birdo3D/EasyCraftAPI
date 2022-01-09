package fr.birdo.easycraftapi.advancement;

import fr.birdo.easycraftapi.EasyCraftAPI;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class AdvancementEvent implements Listener {

    public AdvancementEvent(EasyCraftAPI easyCraftAPI) {
    }

    @EventHandler
    public void playerFinshAdvancement(PlayerAdvancementDoneEvent event){
        NamespacedKey adv_namekey = event.getAdvancement().getKey();
        AdvancementFile.addAdvancement(event.getPlayer(), new Advancement(adv_namekey.getNamespace() +":"+ adv_namekey.getKey(),AdvancementType.NORMAL));
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent event){
        AdvancementFile.create(event.getPlayer());
    }
}
