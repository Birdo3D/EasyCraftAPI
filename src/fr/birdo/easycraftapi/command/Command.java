package fr.birdo.easycraftapi.command;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Command {

    //command variant1 arg1 arg2
    //command variant2 arg1

    private static String command;
    private static final Map<Integer, String> variants = new HashMap<>();
    private final List<CommandArg> args = new ArrayList<>();
    private int index;

    public Command() {
    }

    public Command(String commandIn, int index) {
        command = commandIn;
        this.index = index;
    }

    public Command addVariant(int index, String variant) {
        variants.put(index, variant);
        return this;
    }

    public Command addArg(CommandArg arg) {
        this.args.add(arg);
        return this;
    }

    public boolean onCommandExecuted(Player player, String[] args, int variantIndex, int argsIndex) {
        return false;
    }

    public String getCommand() {
        return command;
    }

    public int getCommandIndex() {
        return index;
    }

    public int getVariantSize() {
        return variants.size();
    }

    public String getVariant(int index) {
        return variants.get(index);
    }

    public List<CommandArg> getArgs() {
        return this.args;
    }
}