package fr.birdo.easycraftapi.command;

import fr.birdo.easycraftapi.entity.Player;
import org.bukkit.ChatColor;

public class CommandCreative extends Command {

    public CommandCreative() {
        super("/creative", 0);
        addVariant(0, "inv");
    }

    public Boolean onCommandExecuted(Player player, String[] args, int variantIndex, int argsIndex) {
        if (variantIndex == 0 && argsIndex == -1) {
            if (player.isOp())
                player.displayGui(0);
            else
                player.sendMessage(ChatColor.RED+"Vous n'avez pas la permission de faire ça !");
            return true;
        }
        return false;
    }
}