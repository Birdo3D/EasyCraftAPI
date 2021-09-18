package fr.birdo.easycraftapi.item;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item {

    public static ItemStack getStackFromItem(Items item) {
        ItemStack itemStack = new ItemStack(item.getMaterial(), 1 , (byte)item.getMaterialMeta());
        ItemMeta itemStackMeta = itemStack.getItemMeta();
        itemStackMeta.setDisplayName(item.getName());
        itemStackMeta.setLore(item.getLore());
        itemStackMeta.setUnbreakable(item.isUnbreakable());
        /*if (item.hasEnchantment()) {
            for (int i = 0; i < item.getEnchantments().size(); i++)
                itemStackMeta.addEnchant(item.getEnchantments().get(i), item.getEnchantmentLevel(item.getEnchantments().get(i)), true);
        }*/
        itemStack.setItemMeta(itemStackMeta);
        return itemStack;
    }
}
