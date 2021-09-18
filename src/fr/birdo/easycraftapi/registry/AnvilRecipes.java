package fr.birdo.easycraftapi.registry;

import fr.birdo.easycraftapi.item.Items;

public class AnvilRecipes {

    static Items itemResult;
    static Items itemLeft;
    static Items itemRight;
    static int expCount;
    static int materialCount;
    static String customName;

    public static void add(Items itemResultIn) {
        itemResult = itemResultIn;
    }

    public AnvilRecipes setItemLeft(Items itemLeft) {
        this.itemLeft = itemLeft;
        return this;
    }

    public AnvilRecipes setItemRight(Items itemRight) {
        this.itemRight = itemRight;
        return this;
    }

    public AnvilRecipes setExpCount(int expCount) {
        this.expCount = expCount;
        return this;
    }

    public AnvilRecipes setMaterialCount(int materialCount) {
        this.materialCount = materialCount;
        return this;
    }

    public AnvilRecipes setCustomName(String customName) {
        this.customName = customName;
        return this;
    }

    public static Items getItem() {
        return itemResult;
    }

    public static Items getItemLeft() {
        return itemLeft;
    }

    public static Items getItemRight() {
        return itemRight;
    }

    public static int getExpCount() {
        return expCount;
    }

    public static int getMaterialCount() {
        return materialCount;
    }

    public static String getCustomName() {
        return customName;
    }
}
