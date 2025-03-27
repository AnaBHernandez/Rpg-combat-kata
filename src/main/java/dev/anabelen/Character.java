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
        this.faction = null; // Inicializa la facción como null
    }

    public void joinFaction(String faction) {
        this.faction = faction; // Asigna la facción al personaje
    }

    public int getHealth() {
        return health; // Devuelve la salud actual
    }

    private void receivesDamage(int damage) {
        this.health = Math.max(0, this.health - damage); // Reduce la salud
        if (this.health == 0) {
            this.isAlive = false; // Marca el personaje como muerto si la salud es 0
        }
    }

    public void dealDamage(Character target, int damage, int distance) {
        // Verifica si el objetivo es válido para causar daño
        if (target == null || damage <= 0 || distance > this.attackRange || target == this ||
            (this.faction != null && this.faction.equals(target.faction)) || !this.isAlive) {
            return; // No se puede dañar a un aliado o a uno mismo o si está muerto
        }

        int modifiedDamage = damage;
        int levelDifference = this.level - target.level;

        System.out.println("Atacante (Nivel " + this.level + ") ataca a Objetivo (Nivel " + target.level + ")");
        System.out.println("Diferencia de niveles: " + levelDifference);
        System.out.println("Daño original: " + damage);

        if (levelDifference >= 5) {
            modifiedDamage = (int) (damage * 1.5); // Aumenta el daño si el atacante es significativamente más fuerte
            System.out.println("Daño modificado (aumentado): " + modifiedDamage);
        } else if (levelDifference <= -5) {
            modifiedDamage = (int) (damage * 0.5); // Reduce el daño si el objetivo es significativamente más fuerte
            System.out.println("Daño modificado (reducido): " + modifiedDamage);
        } else {
            System.out.println("Daño modificado: " + modifiedDamage);
        }

        target.receivesDamage(modifiedDamage); // Aplica el daño al objetivo
        System.out.println("Salud objetivo después del ataque: " + target.getHealth());
    }
}
