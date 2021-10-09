package fr.birdo.easycraftapi.command;

import fr.birdo.easycraftapi.entity.PlayerHelper;
import org.bukkit.entity.Player;

public class CommandCreative extends Command {

    public CommandCreative() {
        super("/creative", 0);
        addVariant(0, "inv");
        addArg(new CommandArg("test", 0, 0, 0));
        addArg(new CommandArg("cc", 1, 0, 1).setBeforeArg(new CommandArg("test", 0, 0, 0)));
    }

    public boolean onCommandExecuted(Player player, int variantIndex, int argsIndex) {
        if (variantIndex == 0 && argsIndex == -1) {
            PlayerHelper.displayGui(player, 1);
            return true;
        }
        return false;
    }
}