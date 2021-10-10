package fr.birdo.easycraftapi.command;

import fr.birdo.easycraftapi.entity.PlayerHelper;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CommandCreative extends Command {

    public CommandCreative() {
        super("/creative", 0);
        addVariant(0, "inv");
    }

    public boolean onCommandExecuted(Player player, String[] args, int variantIndex, int argsIndex) {
        if (variantIndex == 0 && argsIndex == -1) {
            if (player.isOp())
                PlayerHelper.displayGui(player, 1);
            else
                player.sendMessage(ChatColor.RED+"Vous n'avez pas la permission de faire ça !");
            return true;
        }
        return false;
    }
}