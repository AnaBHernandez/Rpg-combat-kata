package dev.anabelen;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CharacterTest {

    @Test
    public void testCharacterCreation_InitialHealth() {
        Character warrior = new Character(Character.CharacterType.MELEE, 0);
        assertEquals(1000, warrior.getHealth());
    }

    @Test
    public void testDealDamage_ReducesTargetHealth() {
        Character warrior = new Character(Character.CharacterType.MELEE, 0);
        Character archer = new Character(Character.CharacterType.RANGED, 0);
        warrior.dealDamage(archer, 200, 1);
        assertEquals(800, archer.getHealth());
    }

    @Test
    public void testDealDamage_SelfDamage() {
        Character warrior = new Character(Character.CharacterType.MELEE, 0);
        warrior.dealDamage(warrior, 200, 1);
        assertEquals(1000, warrior.getHealth());
    }

    @Test
    public void testDealDamage_DamageIncreasedWhenTargetLowerLevel() {
        Character highLevel = new Character(Character.CharacterType.MELEE, 10);
        Character lowLevel = new Character(Character.CharacterType.MELEE, 1);

        System.out.println("Prueba: Atacante (Nivel 10) ataca a Objetivo (Nivel 1)");

        highLevel.dealDamage(lowLevel, 200, 1);

        System.out.println("Salud esperada del objetivo: 700");

        assertEquals(700, lowLevel.getHealth());
    }

    @Test
    public void testDealDamage_DamageReducedWhenTargetHigherLevel() {
        Character highLevel = new Character(Character.CharacterType.MELEE, 10);
        Character lowLevel = new Character(Character.CharacterType.MELEE, 1);
        lowLevel.dealDamage(highLevel, 200, 1);
        assertEquals(900, highLevel.getHealth());
    }
}
}
