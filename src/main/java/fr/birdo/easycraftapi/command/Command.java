package fr.birdo.easycraftapi.command;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Command {

    //command variant1 arg1 arg2
    //command variant2 arg1

    private final String command;
    private final Map<Integer, String> variants = new HashMap<>();
    private final List<CommandArg> args = new ArrayList<>();
    private final int index;

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

    public Boolean onCommandExecuted(Player player, String[] args, int variantIndex, int argsIndex) {
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

    public List<String> getVariants() {
        return new ArrayList<>(variants.values());
    }
}