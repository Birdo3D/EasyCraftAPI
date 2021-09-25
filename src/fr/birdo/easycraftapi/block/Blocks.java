package fr.birdo.easycraftapi.block;

import fr.birdo.easycraftapi.creativetab.CreativeTabs;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class Blocks {

    public static Blocks STONE = new Blocks(Material.STONE, 1).setCreativeTab(CreativeTabs.BLOCKS);
    public static Blocks GRANITE = new Blocks(Material.GRANITE, 2).setCreativeTab(CreativeTabs.BLOCKS);
    public static Blocks POLISHED_GRANITE = new Blocks(Material.POLISHED_GRANITE, 3).setCreativeTab(CreativeTabs.BLOCKS);
    public static Blocks DIORITE = new Blocks(Material.DIORITE, 4).setCreativeTab(CreativeTabs.BLOCKS);
    public static Blocks POLISHED_DIORITE = new Blocks(Material.POLISHED_DIORITE, 5).setCreativeTab(CreativeTabs.BLOCKS);
    public static Blocks ANDESITE = new Blocks(Material.ANDESITE, 6).setCreativeTab(CreativeTabs.BLOCKS);
    public static Blocks POLISHED_ANDESITE = new Blocks(Material.POLISHED_ANDESITE, 7).setCreativeTab(CreativeTabs.BLOCKS);

    private Material material;
    private int meta = 0;
    private int materialMeta;
    private int index;
    private final List<CreativeTabs> creativeTabs = new ArrayList<>();

    public Blocks() {

    }

    public Blocks(Material material, int id) {
        this.material = material;
        this.index = id;
    }

    public Blocks setMaterialMetadata(int metadata) {
        this.materialMeta = metadata;
        return this;
    }

    public int getMaterialMeta() {
        return this.materialMeta;
    }

    public Blocks setMetadata(int metadata) {
        this.meta = metadata;
        return this;
    }

    public int getMeta() {
        return this.meta;
    }

    public int getId() {
        return this.index;
    }

    public Material getMaterial() {
        return this.material;
    }

    public boolean isInCreativeTab(CreativeTabs tab) {
        return this.creativeTabs.contains(tab);
    }

    public Blocks setCreativeTab(CreativeTabs tab) {
        this.creativeTabs.add(tab);
        return this;
    }
}
