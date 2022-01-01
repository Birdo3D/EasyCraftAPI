package fr.birdo.easycraftapi.inventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class InventoryHelper {

    public static int getNb(Material material, HumanEntity humanEntity) {
        Inventory inventory = humanEntity.getInventory();
        List<Integer> items = new ArrayList<>();
        List<Integer> ca = new ArrayList<>();
        int nb = 0;
        int a = 0, b = 36;
        while (a < b) {
            if (inventory.getItem(a) != null && inventory.getItem(a).getType() == material) {
                items.add(inventory.getItem(a).getAmount());
                ca.add(a);
                nb = nb + inventory.getItem(a).getAmount();
            }
            a++;
        }
        return nb;
    }

    public static void sell_1(Material material, HumanEntity humanEntity) {
        Inventory inventory = humanEntity.getInventory();
        List<Integer> items = new ArrayList<>();
        List<Integer> ca = new ArrayList<>();
        int nb = 0;
        int a = 0, b = 36;
        while (a < b) {
            if (inventory.getItem(a) != null && inventory.getItem(a).getType() == material) {
                items.add(inventory.getItem(a).getAmount());
                ca.add(a);
                nb = nb + inventory.getItem(a).getAmount();
            }
            a++;
        }
        if (nb >= 1) {
            int i = 0;
            if (items.get(0) == 1) {
                int cas = ca.get(0);
                inventory.clear(cas);
            } else {
                ItemStack itemselling = new ItemStack(material, items.get(0) - 1);
                inventory.setItem(ca.get(0), itemselling);
            }
            i++;
        } else {
            ((CommandSender) humanEntity).sendMessage(ChatColor.RED + "Tu n'a pas de " + material.name() + " dans ton inventaire");
        }
    }

    public static void sell_64(Material material, HumanEntity humanEntity) {
        List<Integer> items = new ArrayList<>();
        List<Integer> ca = new ArrayList<>();
        Inventory inventory = humanEntity.getInventory();
        int nb = 0;
        int a = 0, b = 36;
        while (a < b) {
            if (inventory.getItem(a) != null && inventory.getItem(a).getType() == material) {
                items.add(inventory.getItem(a).getAmount());
                ca.add(a);
                nb = nb + inventory.getItem(a).getAmount();
            }
            a++;
        }

        if (nb >= 64) {
            int nb_sell = 64;
            int i = 0;
            while (nb_sell > 0) {
                if (nb_sell < items.get(i)) {
                    ItemStack itemselling = new ItemStack(material, items.get(i) - nb_sell);
                    inventory.setItem(ca.get(i), itemselling);
                } else {
                    int cas = ca.get(i);
                    inventory.clear(cas);
                }
                nb_sell = nb_sell - items.get(i);
                i++;
            }
        } else {
            ((CommandSender) humanEntity).sendMessage(ChatColor.RED + "Tu n'a pas asser de " + material.name());
            ((CommandSender) humanEntity).sendMessage(ChatColor.RED + "Il te manque " + Integer.toString(64 - nb) + " " + material.name());
        }
    }

    public static void sell(Material material, HumanEntity humanEntity, int count) {
        List<Integer> items = new ArrayList<>();
        List<Integer> ca = new ArrayList<>();
        Inventory inventory = humanEntity.getInventory();
        int nb = 0;
        int a = 0, b = 36;
        while (a < b) {
            if (inventory.getItem(a) != null && inventory.getItem(a).getType() == material) {
                items.add(inventory.getItem(a).getAmount());
                ca.add(a);
                nb = nb + inventory.getItem(a).getAmount();
            }
            a++;
        }
        if (nb >= count) {
            int nb_sell = count;
            int i = 0;
            while (nb_sell > 0) {
                if (nb_sell < items.get(i)) {
                    ItemStack itemselling = new ItemStack(material, items.get(i) - nb_sell);
                    inventory.setItem(ca.get(i), itemselling);
                } else {
                    int cas = ca.get(i);
                    inventory.clear(cas);
                }
                nb_sell = nb_sell - items.get(i);
                i++;
            }
        } else {
            humanEntity.sendMessage(ChatColor.RED + "Tu n'a pas asser de " + material.name());
            humanEntity.sendMessage(ChatColor.RED + "Il te manque " + Integer.toString(count - nb) + " " + material.name());
        }
    }
}
