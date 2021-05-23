package com.gdgu.game.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GenerateRandom {
    private static List<String> skillList;
    private static List<Character> rankList;
    private static Random random;

    static {
        skillList = Arrays.asList(
            "Alchemy",
            "Astrology",
            "Berserk",
            "Blacksmith",
            "Bluff",
            "Boxing",
            "Breath Control",
            "Calligraphy",
            "Camouflage",
            "Dancing",
            "Detect Lie",
            "Driving",
            "Electronics",
            "Etiqutte",
            "Enchanting",
            "Faming",
            "Flirting",
            "First-aid",
            "Fishing",
            "Gambling",
            "Hacking",
            "Haggling",
            "Healing",
            "Herbalism",
            "Interrogation",
            "Investigation",
            "Juggling",
            "Jumping",
            "Snipping",
            "Story Telling",
            "Stealth",
            "Shadow",
            "Tailor",
            "Weapon Master"
        );

        rankList = Arrays.asList('S', 'A', 'B', 'C', 'D', 'E', 'F');

        random = new Random();
    }

    public static List<String> skills() {
        Collections.shuffle(skillList);
        return Arrays.asList(skillList.get(0), skillList.get(1), skillList.get(2));
    }

    public static char rank() {
        return rankList.get(random.nextInt(7));
    }
}
