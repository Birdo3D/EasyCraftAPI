package fr.birdo.easycraftapi.advancement;

public class Advancement {

    private String id;
    private String name;
    private AdvancementType type;

    public Advancement(String id, AdvancementType type) {
        this.id = id;
        this.type = type;
        this.name = "";
    }

    public Advancement(String name, String id, AdvancementType type) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public AdvancementType getType() {
        return this.type;
    }

    public String getId() {
        return this.id;
    }

    public String getName(){
        return this.name;
    }
}