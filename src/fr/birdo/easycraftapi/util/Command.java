package fr.birdo.easycraftapi.util;

import fr.birdo.easycraftapi.EasyCraftAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.HashMap;
import java.util.Map;

public class Command implements Listener {

    private static EasyCraftAPI instance;
    private String command = "/creative";
    private final Map<Integer, String> variants = new HashMap<>();
    private final Map<Integer, String> args = new HashMap<>();

    public Command(EasyCraftAPI easyCraftAPI) {
        instance = easyCraftAPI;
    }

    public Command(String command) {
        this.command = command;
    }

    public Command addVariant(int index, String variant) {
        this.variants.put(index, variant);
        return this;
    }

    public Command addArg(int index, String arg) {
        this.args.put(index, arg);
        return this;
    }

    public void onCommandExecuted(Player player, int variantIndex, int argsIndex) {
        System.out.println("OOOOOkkkkkk");
        instance.displayGui(player, 1);
    }

    @EventHandler
    private void commandSend(PlayerCommandPreprocessEvent e) {
        String[] args = e.getMessage().split(" ");
        System.out.println("1");
        if (args[0].equalsIgnoreCase(this.command)) {
            System.out.println("2");
            if (this.variants.size() != 0) {
                for (int i = 0; i < this.variants.size(); i++) {
                    if (args[1].equalsIgnoreCase(this.variants.get(i))) {
                        if (this.args.size() != 0) {
                            for (int j = 0; j < this.args.size(); j++) {
                                if (args[2].equalsIgnoreCase(this.args.get(j)))
                                    onCommandExecuted(e.getPlayer(), i, j);
                            }
                        } else
                            onCommandExecuted(e.getPlayer(), i, -1);
                    }
                }
            } else if (this.args.size() != 0) {
                System.out.println("3");
                for (int i = 0; i < this.args.size(); i++) {
                    if (args[1].equalsIgnoreCase(this.args.get(i)))
                        onCommandExecuted(e.getPlayer(), -1, i);
                }
            } else
                onCommandExecuted(e.getPlayer(), -1, -1);
            e.setCancelled(true);
        }
    }
}