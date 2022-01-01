package fr.birdo.easycraftapi.item;

import fr.birdo.easycraftapi.block.Blocks;
import fr.birdo.easycraftapi.creativetab.CreativeTabs;
import fr.birdo.easycraftapi.registry.GameRegistry;
import fr.birdo.easycraftapi.util.BlockPos;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class ItemBlock extends Items {

    private Blocks block;

    public ItemBlock(@Nonnull Blocks block, Material material) {
        super(material, block.getId());
        this.block = block;
        for (CreativeTabs tab : CreativeTabs.CREATIVE_TAB_ARRAY) {
            if (block.isInCreativeTab(tab))
                setCreativeTab(tab);
        }
    }

    public void onItemUse(Player player, World worldIn, BlockPos pos) {
        if (GameRegistry.getRegisteredBlocks().containsValue(this.block)) {
            if (worldIn.getBlockAt(pos.getX(), pos.getY(), pos.getZ()).getType() == Material.AIR) {
                worldIn.getBlockAt(pos.getX(), pos.getY(), pos.getZ()).setType(this.block.getMaterial());
                //set block data
                //remove item in inventory
            }
        } else {
            Bukkit.shutdown();
        }
    }
}