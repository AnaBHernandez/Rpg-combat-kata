package dev.anabelen;

public class Character {
    private int health;
    private int level;
    private boolean isAlive;
    private int attackRange;
    private CharacterType type;
    public Object getHealth;

    public enum CharacterType {
        MELEE,
        RANGED
    }

    public Character(CharacterType type) {
        this.health = 1000;
        this.level = 1;
        this.isAlive = true;
        this.type = type;
        this.attackRange = (type == CharacterType.MELEE) ? 2 : 20;
    }

    public int getHealth() {
        return health;
    }

}
