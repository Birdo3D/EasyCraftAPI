package fr.birdo.easycraftapi.creative;

import fr.birdo.easycraftapi.util.Command;

public class CommandCreative extends Command {

    public CommandCreative() {
        super("/creative");
        addArg(0, "inv");
    }

    public void onCommandExecuted(int variantIndex, int argsIndex) {
        if (variantIndex == -1 && argsIndex == 0)
            System.out.println("C'est gooooooodd !!");
    }
}