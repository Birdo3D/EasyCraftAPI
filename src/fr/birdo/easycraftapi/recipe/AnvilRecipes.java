package fr.birdo.easycraftapi.recipe;

import fr.birdo.easycraftapi.item.Items;

public class AnvilRecipes {

    private final Items itemResult;
    private Items itemLeft;
    private Items itemRight;
    private int expCount;
    private int materialCount;

    public AnvilRecipes(Items itemResultIn){
        this.itemResult = itemResultIn;
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

    public Items getItem() {
        return this.itemResult;
    }

    public Items getItemLeft() {
        return this.itemLeft;
    }

    public Items getItemRight() {
        return this.itemRight;
    }

    public int getExpCount() {
        return this.expCount;
    }

    public int getMaterialCount() {
        return this.materialCount;
    }
}