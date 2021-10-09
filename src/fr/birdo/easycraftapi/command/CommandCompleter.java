package fr.birdo.easycraftapi.command;

import fr.birdo.easycraftapi.registry.GameRegistry;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class CommandCompleter  { //implements TabCompleter

    /*@Override
    public List<String> onTabComplete(CommandSender commandSender, Command c, String s, String[] args) {
        List<String> output_args = new ArrayList<>();
        for (fr.birdo.easycraftapi.command.Command command : GameRegistry.registeredCommands.values()) {
            if (command.getCommand().equalsIgnoreCase("/" + s)) {
                if (args.length == 1) {
                    //command
                    for (int i = 0; i < command.getVariantSize(); i++)
                        output_args.add(command.getVariant(i));
                } else if (args.length == 2) {
                    //Variant
                    for (int i = 0; i < command.getVariantSize(); i++) {
                        if (command.getVariant(i).equalsIgnoreCase(args[1])) {
                            for (int j = 0; j < command.getArgsSize(i); j++)
                                output_args.add(command.getArg(i, j));
                            break;
                        }
                    }
                } else if (args.length > 2) {
                    //Args
                }

                if (output_args.isEmpty()) {
                    return null;
                } else
                    return output_args;
            }
        }*/

        /*if (args.length >= 1) {
            for (String command : Commands.FMC_COMMANDS) {
                String[] command_args = command.split(" ");
                if (command_args.length >= args.length) {
                    String active_arg = command_args[args.length - 1];
                    if (args.length > 1) {
                        if (Arrays.equals(Arrays.copyOf(command_args, args.length - 1), Arrays.copyOf(args, args.length - 1))) {
                            if (active_arg.contains(args[args.length - 1]) && active_arg.indexOf(args[args.length - 1]) == 0) {
                                if (!output_args.contains(active_arg))
                                    output_args.add(active_arg);
                            }
                        }
                    } else {
                        if (active_arg.contains(args[args.length - 1]) && active_arg.indexOf(args[args.length - 1]) == 0) {
                            if (!output_args.contains(active_arg))
                                output_args.add(active_arg);
                        }
                    }
                }
            }
            if (output_args.isEmpty())
                return null;
            return output_args;
        }
        return null;*/
    //}
}