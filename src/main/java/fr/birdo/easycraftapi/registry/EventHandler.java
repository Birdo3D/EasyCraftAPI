package fr.birdo.easycraftapi.registry;

import fr.birdo.easycraftapi.EasyCraftAPI;
import fr.birdo.easycraftapi.command.Command;
import fr.birdo.easycraftapi.inventory.GuiScreen;
import fr.birdo.easycraftapi.item.Item;
import fr.birdo.easycraftapi.item.Items;
import fr.birdo.easycraftapi.util.BlockPos;
import fr.birdo.easycraftapi.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Objects;

@SuppressWarnings("deprecation")
public class EventHandler implements Listener {

    public EventHandler(EasyCraftAPI easyCraftAPI) {
    }

    @org.bukkit.event.EventHandler
    public void onGuiClicked(InventoryClickEvent event) {
        if (event.getCurrentItem() != null && event.getWhoClicked() instanceof Player) {
            if (event.getClickedInventory() instanceof AnvilInventory) {
                AnvilInventory anvilInventory = (AnvilInventory) event.getClickedInventory();
                if (event.getSlot() == 2) {
                    for (int i = 0; i < GameRegistry.getRegisteredAnvilRecipes().size(); i++) {
                        if (anvilInventory.getItem(2) != null) {
                            if (Objects.requireNonNull(anvilInventory.getItem(2)).isSimilar(Item.getStackFromItem(GameRegistry.getRegisteredAnvilRecipes().get(i).getItem()))) {
                                if (anvilInventory.getContents()[0] != null) {
                                    if (anvilInventory.getContents()[0].equals(Item.getStackFromItem(GameRegistry.getRegisteredAnvilRecipes().get(i).getItemLeft()))) {
                                        if (GameRegistry.getRegisteredAnvilRecipes().get(i).getItemRight() != null) {
                                            if (anvilInventory.getContents()[1] != null && Item.getStackFromItem(GameRegistry.getRegisteredAnvilRecipes().get(i).getItemRight()).equals(anvilInventory.getContents()[1])) {
                                                event.setCursor(Item.getStackFromItem(GameRegistry.getRegisteredAnvilRecipes().get(i).getItem()));
                                                anvilInventory.setItem(0, null);
                                                ItemStack itemSlot1 = Item.getStackFromItem(GameRegistry.getRegisteredAnvilRecipes().get(i).getItemRight());
                                                itemSlot1.setAmount(anvilInventory.getItem(1).getAmount() - 1);
                                                anvilInventory.setItem(1, itemSlot1);
                                                anvilInventory.setItem(2, null);
                                            }
                                        } else if (anvilInventory.getContents()[1] == null) {
                                            event.setCursor(Item.getStackFromItem(GameRegistry.getRegisteredAnvilRecipes().get(i).getItem()));
                                            anvilInventory.setItem(0, null);
                                            ItemStack itemSlot1 = Item.getStackFromItem(GameRegistry.getRegisteredAnvilRecipes().get(i).getItemRight());
                                            itemSlot1.setAmount(anvilInventory.getItem(1).getAmount() - 1);
                                            anvilInventory.setItem(1, itemSlot1);
                                            anvilInventory.setItem(2, null);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (!(event.getClickedInventory() instanceof PlayerInventory)) {
                if (GameRegistry.getRegisteredGuis().get(GuiScreen.getIdByName(event.getView().getTitle())) != null) {
                    GuiScreen guiScreen = GameRegistry.getRegisteredGuis().get(GuiScreen.getIdByName(event.getView().getTitle()));
                    guiScreen.buttonIsPressed((Player) event.getWhoClicked(), guiScreen, event.getSlot());
                    if (guiScreen.isButton(guiScreen, event.getSlot()) || !guiScreen.isItemPickable(event.getSlot()))
                        event.setCancelled(true);
                    if (guiScreen.setItemInCursor() != null) {
                        ItemStack itemStack = Item.getStackFromItem(guiScreen.setItemInCursor()).clone();
                        itemStack.setAmount(guiScreen.setItemInCursorAmount());
                        event.setCursor(itemStack);
                        guiScreen.itemHasBeenSetInCursor(guiScreen.setItemInCursor(), guiScreen.setItemInCursorAmount());
                    }
                }

            }
        }
    }

    @org.bukkit.event.EventHandler
    private void onCommandSend(PlayerCommandPreprocessEvent event) {
        int argsok = 0;
        String[] args = event.getMessage().split(" ");
        for (int h = 0; h < GameRegistry.getRegisteredCommands().size(); h++) {//Pour toutes les commandes enregistrées
            Command command = GameRegistry.getRegisteredCommands().get(h);//Commande
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
                                                    event.setCancelled(command.onCommandExecuted(event.getPlayer(), args, i, args.length - 3));
                                            }
                                        }
                                    }
                                } else {//Si il y a un seul argument
                                    for (int m = 0; m < command.getArgs().size(); m++) {//Pour chaque argument
                                        if (command.getArgs().get(m).getArgPos() == 0 && args[2].equalsIgnoreCase(command.getArgs().get(m).getArg()))
                                            event.setCancelled(command.onCommandExecuted(event.getPlayer(), args, i, 0));
                                    }
                                }
                            } else //Si il y a seulement un variant
                                event.setCancelled(command.onCommandExecuted(event.getPlayer(), args, i, -1));
                        }
                    }
                } else if (args.length == 1)//Si il y a seulement la commande
                    event.setCancelled(command.onCommandExecuted(event.getPlayer(), args, -1, -1));
            }
        }
    }

    @org.bukkit.event.EventHandler
    public void onItemUse(PlayerInteractEvent event) {
        for (Items item : GameRegistry.getRegisteredItems().values())
            if (event.getItem() != null)
                if (event.getItem().isSimilar(Item.getStackFromItem(item))) {
                    BlockPos pos = new BlockPos(0, 0, 0);
                    if (event.getClickedBlock() != null)
                        pos = new BlockPos(event.getClickedBlock().getX(), event.getClickedBlock().getY(), event.getClickedBlock().getZ());
                    item.onItemUse(event.getPlayer(), pos, event.getBlockFace(), event.getAction(), event.getHand());
                    item.onUpdate(event.getPlayer());
                }
    }

    @org.bukkit.event.EventHandler
    public void customAnvilRecipe(PrepareAnvilEvent event) {
        ItemStack[] contents = event.getInventory().getContents();
        if (contents[0] != null) {
            for (int i = 0; i < GameRegistry.getRegisteredAnvilRecipes().size(); i++) {
                if (Item.getStackFromItem(GameRegistry.getRegisteredAnvilRecipes().get(i).getItemLeft()).equals(contents[0])) {
                    if (GameRegistry.getRegisteredAnvilRecipes().get(i).getItemRight() != null) {
                        if (contents[1] != null && Item.getStackFromItem(GameRegistry.getRegisteredAnvilRecipes().get(i).getItemRight()).equals(contents[1])) {
                            event.setResult(Item.getStackFromItem(GameRegistry.getRegisteredAnvilRecipes().get(i).getItem()));
                        }
                    } else if (contents[1] == null) {
                        event.setResult(Item.getStackFromItem(GameRegistry.getRegisteredAnvilRecipes().get(i).getItem()));
                    }
                }
            }
        }
    }

    @org.bukkit.event.EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

    }
}