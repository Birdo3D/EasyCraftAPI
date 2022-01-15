package fr.birdo.easycraftapi.advancement;

public enum AdvancementType {

    NORMAL(0),
    GOAL(1),
    CHALLENGE(2);

    private int id;

    AdvancementType(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}