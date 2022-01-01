package fr.birdo.easycraftapi.inventory;

import fr.birdo.easycraftapi.item.Items;

public class GuiButton {

    private final int index;
    private final int pos;
    private final Items item;

    public GuiButton(Items item, int id, int pos) {
        this.index = id;
        this.pos = pos;
        this.item = item;
    }

    public int getId() {
        return this.index;
    }

    public Items getItem() {
        return this.item;
    }

    public int getPos() {
        return this.pos;
    }
}
