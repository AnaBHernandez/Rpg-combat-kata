package dev.anabelen;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CharacterTest {

    @Test
    public void testCharacterCreation_InitialHealth() {
        Character warrior = new Character(Character.CharacterType.MELEE);
        assertEquals(1000, warrior.getHealth());
    }
}
