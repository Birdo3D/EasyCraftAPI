package fr.birdo.easycraftapi.registry;

import fr.birdo.easycraftapi.EasyCraftAPI;
import fr.birdo.easycraftapi.command.Command;
import fr.birdo.easycraftapi.inventory.GuiScreen;
import fr.birdo.easycraftapi.item.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class EventHandler implements Listener {

    public EventHandler(EasyCraftAPI easyCraftAPI) {
    }

    @org.bukkit.event.EventHandler
    public void guiClicked(InventoryClickEvent event) {
        if (event.getCurrentItem() != null) {
            if (event.getWhoClicked() instanceof Player && !(event.getClickedInventory() instanceof PlayerInventory)) {
                GuiScreen.buttonIsPressed((Player) event.getWhoClicked(), GameRegistry.registeredGuis.get(GuiScreen.getIdByName(event.getView().getTitle())), event.getSlot());
                if (GuiScreen.isButton(event.getSlot()) || !GuiScreen.isItemPickable(event.getSlot()))
                    event.setCancelled(true);
                if (GameRegistry.registeredGuis.get(GuiScreen.getIdByName(event.getView().getTitle())).setItemInCursor() != null) {
                    ItemStack itemStack = Item.getStackFromItem(GameRegistry.registeredGuis.get(GuiScreen.getIdByName(event.getView().getTitle())).setItemInCursor()).clone();
                    itemStack.setAmount(GameRegistry.registeredGuis.get(GuiScreen.getIdByName(event.getView().getTitle())).setItemInCursorAmount());
                    event.setCursor(itemStack);
                    GameRegistry.registeredGuis.get(GuiScreen.getIdByName(event.getView().getTitle())).itemHasBeenSetInCursor(GameRegistry.registeredGuis.get(GuiScreen.getIdByName(event.getView().getTitle())).setItemInCursor(), GameRegistry.registeredGuis.get(GuiScreen.getIdByName(event.getView().getTitle())).setItemInCursorAmount());
                }
            }
        }
    }

    @org.bukkit.event.EventHandler
    private void commandSend(PlayerCommandPreprocessEvent e) {
        int argsok = 0;
        String[] args = e.getMessage().split(" ");
        for (int h = 0; h < GameRegistry.registeredCommands.size(); h++) {//Pour toutes les commandes enregistrées
            Command command = GameRegistry.registeredCommands.get(h);//Commande
            if (args[0].equalsIgnoreCase(command.getCommand())) {//Si c'est bien cette commande
                if (args.length > 1 && command.getVariantSize() != 0) {//Si il y a des variants
                    for (int i = 0; i < command.getVariantSize(); i++) {//Pour chaque variant de cette commande
                        if (args[1].equalsIgnoreCase(command.getVariant(i))) {//Si le variant est bien celui ci
                            if (args.length > 2) {//Si il y a des args en plus des variants
                                if (args.length > 3) {//Si il y a + d'1 argument
                                    for (int j = args.length - 1; j >= 2; j--) {//Pour tout les args de la commande envoyée
                                        for (int m = 0; m < command.getArgs().size(); m++) {//Pour chaque argument de cette commande
                                            if (command.getArgs().get(m).getArgPos() == j - 2 && args[j].equalsIgnoreCase(command.getArgs().get(m).getArg()) && command.getArgs().get(m).getVariant() == i) {
                                                if (j > 2 && args[j - 1].equalsIgnoreCase(command.getArgs().get(m).getBeforeArg().getArg()))
                                                    argsok++;
                                                if (j == 2 && argsok == args.length - 3)//Si tout est bon
                                                    e.setCancelled(command.onCommandExecuted(e.getPlayer(), args, i, args.length - 3));
                                            }
                                        }
                                    }
                                } else {//Si il y a un seul argument
                                    for (int m = 0; m < command.getArgs().size(); m++) {//Pour chaque argument
                                        if (command.getArgs().get(m).getArgPos() == 0 && args[2].equalsIgnoreCase(command.getArgs().get(m).getArg()))
                                            e.setCancelled(command.onCommandExecuted(e.getPlayer(), args, i, 0));
                                    }
                                }
                            } else //Si il y a seulement un variant
                                e.setCancelled(command.onCommandExecuted(e.getPlayer(), args, i, -1));
                        }
                    }
                } else if (args.length == 1)//Si il y a seulement la commande
                    e.setCancelled(command.onCommandExecuted(e.getPlayer(), args, -1, -1));
            }
        }
    }
}