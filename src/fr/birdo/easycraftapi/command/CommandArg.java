package fr.birdo.easycraftapi.command;

public class CommandArg {

    private final String arg;
    private final int index;
    private final int variantIndex;
    private final int argPos;
    private CommandArg beforeArg;

    public CommandArg(String arg, int argIndex, int variantIndex, int argPos) {
        this.index = argIndex;
        this.arg = arg;
        this.variantIndex = variantIndex;
        this.argPos = argPos;
    }

    public CommandArg setBeforeArg(CommandArg beforeArg){
        this.beforeArg = beforeArg;
        return this;
    }

    public String getArg(){
        return this.arg;
    }

    public int getVariant(){
        return this.variantIndex;
    }

    public int getId(){
        return this.index;
    }

    public int getArgPos(){
        return this.argPos;
    }

    public CommandArg getBeforeArg(){
        return this.beforeArg;
    }
}
