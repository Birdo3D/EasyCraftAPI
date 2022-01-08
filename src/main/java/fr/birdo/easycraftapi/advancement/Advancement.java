package fr.birdo.easycraftapi.advancement;

public class Advancement {

    private String id;
    private AdvancementType type;

    public Advancement(String id, AdvancementType type) {
        this.id = id;
        this.type = type;
    }

    public AdvancementType getType() {
        return this.type;
    }

    public String getId() {
        return this.id;
    }
}