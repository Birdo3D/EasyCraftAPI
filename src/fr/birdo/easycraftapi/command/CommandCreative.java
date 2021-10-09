package fr.birdo.easycraftapi.command;

import fr.birdo.easycraftapi.entity.PlayerHelper;
import org.bukkit.entity.Player;

public class CommandCreative extends Command {

    public CommandCreative() {
        super("/creative", 0);
        addVariant(0, "inv");
    }

    public boolean onCommandExecuted(Player player, String[] args, int variantIndex, int argsIndex) {
        if (variantIndex == 0 && argsIndex == -1) {
            PlayerHelper.displayGui(player, 1);
            return true;
        }
        return false;
    }
}