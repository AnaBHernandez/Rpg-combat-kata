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

    public Character(CharacterType type, int level) {
        this.health = 1000;
        this.level = level;
        this.isAlive = true;
        this.type = type;
        this.attackRange = (type == CharacterType.MELEE) ? 2 : 20;
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
        if (target == null || damage <= 0 || distance > this.attackRange || target == this) {
            return;
        }

        int modifiedDamage = damage;
        int levelDifference = this.level - target.level;

        System.out.println("Atacante (Nivel " + this.level + ") ataca a Objetivo (Nivel " + target.level + ")");
        System.out.println("Diferencia de niveles: " + levelDifference);
        System.out.println("Daño original: " + damage);

        if (levelDifference >= 5) {
            modifiedDamage = (int) (damage * 1.5);
            System.out.println("Daño modificado (aumentado): " + modifiedDamage);
        } else {
            System.out.println("Daño modificado: " + modifiedDamage);
        }

        target.receivesDamage(modifiedDamage);
        System.out.println("Salud objetivo después del ataque: " + target.getHealth());
    }
}
