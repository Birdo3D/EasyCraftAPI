package fr.birdo.easycraftapi;

import fr.birdo.easycraftapi.util.Command;
import fr.birdo.easycraftapi.util.GuiScreen;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class EventHandler implements Listener {

    public EventHandler(EasyCraftAPI easyCraftAPI) {
    }

    @org.bukkit.event.EventHandler
    public void guiClicked(InventoryClickEvent event) {
        if(event.getCurrentItem() != null) {
            if (event.getWhoClicked() instanceof Player)
                GuiScreen.buttonIsPressed((Player) event.getWhoClicked(), event.getView(), event.getSlot());
            if (GuiScreen.isButton(event.getSlot()) || !GuiScreen.isItemPickable(event.getSlot()))
                event.setCancelled(true);
        }
    }

    @org.bukkit.event.EventHandler
    private void commandSend(PlayerCommandPreprocessEvent e) {
        Command command = new Command();
        String[] args = e.getMessage().split(" ");
        if (args[0].equalsIgnoreCase(command.getCommand())) {
            if (args.length > 1 && command.getVariantSize() != 0) {
                for (int i = 0; i < command.getVariantSize(); i++) {
                    if (args[1].equalsIgnoreCase(command.getVariant(i))) {
                        if (args.length > 2 && command.getArgsSize(i) != 0) {
                            for (int j = 0; j < command.getArgsSize(i); j++) {
                                if (args[j + 2].equalsIgnoreCase(command.getArg(i, j)))
                                    //command.onCommandExecuted(e.getPlayer(), i, j);
                                    GameRegistry.registeredCommands.get(command.getCommandIndex()).onCommandExecuted(e.getPlayer(), i, j);
                            }
                        } else if (args.length == 2)
                            //command.onCommandExecuted(e.getPlayer(), i, -1);
                            GameRegistry.registeredCommands.get(command.getCommandIndex()).onCommandExecuted(e.getPlayer(), i, -1);
                    }
                }
            } else if (args.length == 1)
                //command.onCommandExecuted(e.getPlayer(), -1, -1);
                GameRegistry.registeredCommands.get(command.getCommandIndex()).onCommandExecuted(e.getPlayer(), -1, -1);
            e.setCancelled(true);
        }
    }
}