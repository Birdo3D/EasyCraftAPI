package fr.birdo.easycraftapi.command;

import fr.birdo.easycraftapi.registry.GameRegistry;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class CommandCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, org.bukkit.command.Command command, String root, String[] args) {

        List<String> output = new ArrayList<>();

        for (Object id : GameRegistry.getRegisteredCommands().keySet()) {
            Command c = GameRegistry.getRegisteredCommands().get(id);

            if (!c.getCommand().substring(1).equalsIgnoreCase(root) || args.length < 1 && c.getVariantSize() == 0) { //Check root command && variants
                continue;
            }

            //Complete variants
            if (args.length == 1 && c.getVariantSize() != 0) {
                for (String v : c.getVariants()) {
                    if (v.contains(args[0])) {
                        output.add(v);
                    }
                }
                return output;
            }

            //For on each possible arg of the command
            for (CommandArg arg : c.getArgs()){

                //Check if the written command contains more than 2 args
                if(arg.getArgPos() == args.length - 2 && args.length > 2){

                    //In this case loop on each before args to check if the path is correct
                    boolean correct_path = true;
                    CommandArg past_arg = arg;

                    for (int i = args.length; i > 1 ; i--){

                        //The written arg is contained
                        if(!past_arg.getArg().contains(args[i - 1])){
                           correct_path = false;
                        }
                        //Decrease in the command path
                        past_arg = past_arg.getBeforeArg();
                    }

                    if(correct_path){
                        output.add(arg.getArg());
                    }
                    //Complete if there is only one arg
                }else if(arg.getArgPos() == args.length - 2 && args.length < 3){

                    //Add arg
                    output.add(arg.getArg());
                }
            }
        }
        return output;
    }
}