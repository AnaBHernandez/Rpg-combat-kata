package dev.anabelen;

public class Character {
    private int health;
    private int level;
    private boolean isAlive;
    private int attackRange;
    private CharacterType type;

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

    public void dealDamage(Character target, int damage, int distance) {
        if (target == null || damage <= 0 || distance > attackRange) {
            return;
        }
        target.receivesDamage(damage);
}

    private void receivesDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
        if(this.health == 0) {
            this.isAlive = false;
        }
    }
}

