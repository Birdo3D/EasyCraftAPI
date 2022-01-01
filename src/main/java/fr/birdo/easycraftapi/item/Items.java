package fr.birdo.easycraftapi.item;

import fr.birdo.easycraftapi.creativetab.CreativeTabs;
import fr.birdo.easycraftapi.util.BlockPos;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Items {

    //Items
    public static Items DIAMOND = new Items(Material.DIAMOND, 0).setCreativeTab(CreativeTabs.MISCELLANEOUS);

    private Material material;
    private int id;
    private int meta;
    private String name;
    private final List<Enchantment> enchantments = new ArrayList<Enchantment>();
    private final Map<Enchantment, Integer> enchantmentsLevel = new HashMap<Enchantment, Integer>();
    private final Map<ItemFlag, Boolean> itemFlags = new HashMap<ItemFlag, Boolean>();
    private final List<CreativeTabs> creativeTabs = new ArrayList<CreativeTabs>();
    private List<String> lore = new ArrayList<String>();
    private boolean unbreakable;
    private int maxStackSize = 64;
    private int maxDamage;

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

    public Items hideEnchants(boolean hide) {
        this.itemFlags.put(ItemFlag.HIDE_ENCHANTS, hide);
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

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public Items setUnbreakable(boolean unbreakable, boolean hide) {
        this.unbreakable = unbreakable;
        this.itemFlags.put(ItemFlag.HIDE_UNBREAKABLE, hide);
        return this;
    }

    public int getMaxStackSize() {
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

    public Boolean hasItemFlag(ItemFlag itemFlag) {
        if (this.itemFlags.containsKey(itemFlag))
            return this.itemFlags.get(itemFlag);
        return false;
    }

    public List<Enchantment> getEnchantments() {
        return enchantments;
    }

    public int getEnchantmentLevel(Enchantment enchantment) {
        return this.enchantmentsLevel.get(enchantment);
    }

    public void onItemUse(Player player, BlockPos pos, BlockFace blockFace, Action action, EquipmentSlot hand) {
    }

    public void onUpdate(Entity entityIn) {
    }

    public void onTick(int tick) {
    }

    public void onCreated(Player playerIn, String type) {
    }
}