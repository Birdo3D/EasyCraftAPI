package fr.birdo.easycraftapi.item;

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
    public static Items DIAMOND = new Items(Material.DIAMOND, 22).setCreativeTab(CreativeTabs.MISCELLANEOUS);

    public static Items DIAM1OND = new Items(Material.DIAMOND, 8).setCreativeTab(CreativeTabs.BLOCKS);
    public static Items DIA1MOND = new Items(Material.DIAMOND, 9).setCreativeTab(CreativeTabs.BLOCKS);
    public static Items DIAM11OND = new Items(Material.DIAMOND, 10).setCreativeTab(CreativeTabs.BLOCKS);
    public static Items DI1AMOND = new Items(Material.DIAMOND, 11).setCreativeTab(CreativeTabs.BLOCKS);
    public static Items DIAMO1ND = new Items(Material.DIAMOND, 12).setCreativeTab(CreativeTabs.BLOCKS);
    public static Items DIAM11ON1D = new Items(Material.DIAMOND, 13).setCreativeTab(CreativeTabs.BLOCKS);
    public static Items D1IAM1OND = new Items(Material.DIAMOND, 14).setCreativeTab(CreativeTabs.BLOCKS);
    public static Items DIA1MO1ND = new Items(Material.DIAMOND, 15).setCreativeTab(CreativeTabs.BLOCKS);
    public static Items DIAM111ND = new Items(Material.DIAMOND, 16).setCreativeTab(CreativeTabs.BLOCKS);
    public static Items DIA5MO1ND = new Items(Material.DIAMOND, 17).setCreativeTab(CreativeTabs.BLOCKS);
    public static Items DIAM511ON1D = new Items(Material.DIAMOND, 18).setCreativeTab(CreativeTabs.BLOCKS);
    public static Items D1I5AM1OND = new Items(Material.DIAMOND, 19).setCreativeTab(CreativeTabs.BLOCKS);
    public static Items DIA1MO15ND = new Items(Material.DIAMOND, 20).setCreativeTab(CreativeTabs.BLOCKS);
    public static Items DIAM1115ND = new Items(Material.DIAMOND, 21).setCreativeTab(CreativeTabs.BLOCKS);

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

    public int getMaxStackSize(){
        return this.maxStackSize;
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
