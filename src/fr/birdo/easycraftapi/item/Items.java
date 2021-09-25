package fr.birdo.easycraftapi.item;

import fr.birdo.easycraftapi.block.Blocks;
import fr.birdo.easycraftapi.creativetab.CreativeTabs;
import fr.birdo.easycraftapi.util.BlockPos;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Items {

    //Items
    public static Items DIAMOND = new Items(Material.DIAMOND, 9).setCreativeTab(CreativeTabs.MISCELLANEOUS);

    //Items Blocks
    public static Items STONE_ITEM = new ItemBlock(Blocks.STONE, Material.STONE);
    public static Items GRANITE_ITEM = new ItemBlock(Blocks.GRANITE, Material.GRANITE);
    public static Items POLISHED_GRANITE_ITEM = new ItemBlock(Blocks.POLISHED_GRANITE, Material.POLISHED_GRANITE);
    public static Items DIORITE_ITEM = new ItemBlock(Blocks.DIORITE, Material.DIORITE);
    public static Items POLISHED_DIORITE_ITEM = new ItemBlock(Blocks.POLISHED_DIORITE, Material.POLISHED_DIORITE);
    public static Items ANDESITE_ITEM = new ItemBlock(Blocks.ANDESITE, Material.ANDESITE);
    public static Items POLISHED_ANDESITE_ITEM = new ItemBlock(Blocks.POLISHED_ANDESITE, Material.POLISHED_ANDESITE);

    Material material;
    int id;
    int meta;
    String name;
    List<Enchantment> enchantments = new ArrayList<>();
    Map<Enchantment, Integer> enchantmentsLevel = new HashMap<>();
    List<CreativeTabs> creativeTabs = new ArrayList<>();
    List<String> lore = new ArrayList<>();
    boolean unbreakable;
    int maxStackSize = 64;
    int maxDamage;
    boolean hasSubtypes;

    public Items() {

    }

    public Items(Material material, int id) {
        this.material = material;
        this.id = id;
    }

    public Items setName(String name) {
        this.name = name;
        return this;
    }

    public Items setMaterialMeta(int meta) {
        this.meta = meta;
        return this;
    }

    public int getMaterialMeta() {
        return this.meta;
    }

    public Items addEnchant(Enchantment enchantment, int level) {
        this.enchantments.add(enchantment);
        this.enchantmentsLevel.put(enchantment, level);
        return this;
    }

    public Items setCreativeTab(CreativeTabs tab) {
        this.creativeTabs.add(tab);
        return this;
    }

    public Items setMaxStackSize(int maxStackSize) {
        this.maxStackSize = maxStackSize;
        return this;
    }

    public Items setMaxDamage(int maxDamageIn) {
        this.maxDamage = maxDamageIn;
        return this;
    }

    public Items setUnbreakable(boolean unbreakable) {
        this.unbreakable = unbreakable;
        return this;
    }

    public boolean isUnbreakable() {
        return this.unbreakable;
    }

    public int getId() {
        return id;
    }

    public void addInformation(List<String> tooltip) {
        this.lore = tooltip;
    }

    public List<String> getLore() {
        return this.lore;
    }

    public Items hasSubtypes(boolean hasSubtypes) {
        this.hasSubtypes = hasSubtypes;
        return this;
    }

    public int getMetadata(int damage) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public Material getMaterial() {
        return this.material;
    }

    public boolean isInCreativeTab(CreativeTabs tab) {
        return this.creativeTabs.contains(tab);
    }

    public boolean hasEnchantment() {
        return enchantments.size() != 0;
    }

    public List<Enchantment> getEnchantments() {
        return enchantments;
    }

    public int getEnchantmentLevel(Enchantment enchantment) {
        return this.enchantmentsLevel.get(enchantment);
    }

    public void onItemUse(Player player, World worldIn, BlockPos pos) {
    }

    public void onItemRightClick(World worldIn, Player playerIn) {
    }

    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
    }

    public void onCreated(ItemStack stack, World worldIn, Player playerIn) {
    }
}
