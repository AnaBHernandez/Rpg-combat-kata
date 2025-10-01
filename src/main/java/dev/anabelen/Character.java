package dev.anabelen;

public class Character {
    private int health;
    private int level;
    private boolean isAlive;
    private int attackRange;
    private CharacterType type;
    private String faction;

    public enum CharacterType {
        MELEE,
        RANGED
    }

    public Character(CharacterType type, int level) {
        this.health = 1000;
        this.level = level;
        this.isAlive = true;
        this.type = type;
        this.attackRange = (type == CharacterType.MELEE) ? 2 : 20;
        this.faction = null;
    }

    public void joinFaction(String faction) {
        this.faction = faction;
    }

    public String getFaction() {
        return faction;
    }

    public int getHealth() {
        return health;
    }

    private void receivesDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
        if (this.health == 0) {
            this.isAlive = false;
        }
    }

    public void dealDamage(Character target, int damage, int distance) {
        if (!canDealDamage(target, damage, distance)) {
            return;
        }

        int modifiedDamage = calculateModifiedDamage(damage, target);
        target.receivesDamage(modifiedDamage);
    }

    private boolean canDealDamage(Character target, int damage, int distance) {
        return target != null && 
               damage > 0 && 
               distance <= this.attackRange && 
               target != this && 
               this.isAlive && 
               !areAllies(target);
    }

    private boolean areAllies(Character target) {
        return this.faction != null && this.faction.equals(target.getFaction());
    }

    private int calculateModifiedDamage(int baseDamage, Character target) {
        int levelDifference = this.level - target.level;
        
        if (levelDifference >= 5) {
            return (int) (baseDamage * 1.5);
        } else if (levelDifference <= -5) {
            return (int) (baseDamage * 0.5);
        }
        
        return baseDamage;
    }
}
