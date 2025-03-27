package dev.anabelen;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CharacterTest {

    @Test
    public void testCharacterCreation_InitialHealth() {
        Character warrior = new Character(Character.CharacterType.MELEE);
        assertEquals(1000, warrior.getHealth());
    }

    @Test
    public void testDealDamage_ReducesTargetHealth() {
        Character warrior = new Character(Character.CharacterType.MELEE);
        Character archer = new Character(Character.CharacterType.RANGED);
        warrior.dealDamage(archer, 200, 1);
        assertEquals(800, archer.getHealth());
    }

    @Test
    public void testDealDamage_SelfDamage() {
        Character warrior = new Character(Character.CharacterType.MELEE);
        warrior.dealDamage(warrior, 200, 1);
        assertEquals(1000, warrior.getHealth());
    }

    @Test
    public void testDealDamage_DamageIncreasedWhenTargetLowerLevel() {
    Character highLevel = new Character(Character.CharacterType.MELEE, 10);
    Character lowLevel = new Character(Character.CharacterType.MELEE, 1);
    highLevel.dealDamage(lowLevel, 200, 1);
    assertEquals(700, lowLevel.getHealth());
}
}
