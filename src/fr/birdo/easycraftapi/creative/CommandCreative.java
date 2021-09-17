package fr.birdo.easycraftapi.creative;

import fr.birdo.easycraftapi.util.Command;
import fr.birdo.easycraftapi.util.PlayerHelper;
import org.bukkit.entity.Player;

public class CommandCreative extends Command {

    public CommandCreative() {
        super("/creative", 0);
        addVariant(0, "inv");
    }

    public void onCommandExecuted(Player player, int variantIndex, int argsIndex) {
        System.out.println(player + " " + variantIndex + " " + argsIndex);
        if (variantIndex == 0 && argsIndex == -1)
            PlayerHelper.displayGui(player, 1);
    }
}