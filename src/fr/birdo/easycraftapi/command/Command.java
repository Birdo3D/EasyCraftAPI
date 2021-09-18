package fr.birdo.easycraftapi.command;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Command {

    //command variant1 arg1 arg2
    //command variant2 arg1

    private static String command;
    private static final Map<Integer, String> variants = new HashMap<>();
    private static final Map<Integer, String> args = new HashMap<>();
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

    public Command addArg(int index, String arg) {
        args.put(index, arg);
        return this;
    }

    public void onCommandExecuted(Player player, int variantIndex, int argsIndex) {
    }

    public String getCommand() {
        return command;
    }

    public int getCommandIndex(){
        return index;
    }

    public int getVariantSize() {
        return variants.size();
    }

    public int getArgsSize(int variantIndex) {
        return args.size();
    }

    public String getVariant(int index) {
        return variants.get(index);
    }

    public String getArg(int variantIndex, int index) {
        return args.get(index);
    }
}