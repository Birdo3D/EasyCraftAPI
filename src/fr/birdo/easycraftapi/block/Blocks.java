package fr.birdo.easycraftapi.block;

import fr.birdo.easycraftapi.creativetab.CreativeTabs;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class Blocks {

    public static Blocks STONE = new Blocks(Material.STONE, 1).setCreativeTab(CreativeTabs.BLOCKS);

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
