package fr.birdo.easycraftapi.util;

import fr.birdo.easycraftapi.Items;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class GuiText {

    private final String text;
    private final int pos;
    private Material material = Material.LIGHT_GRAY_STAINED_GLASS_PANE;

    public GuiText(String text, int pos, ChatColor textColor, boolean dark) {
        this.text = textColor + text;
        this.pos = pos;
        if (dark)
            this.material = Material.GRAY_STAINED_GLASS_PANE;
    }

    public int getPos() {
        return pos;
    }

    public Items getItem() {
        return new Items(material, -1).setName(text);
    }
}
