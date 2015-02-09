package com.kiroule.ocpupgradejava8.topic2_6;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Igor Baiborodine
 */
public class PredicateInterfaceExample {

    public static void main(String... args) {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez", "robot"),
                new FuturamaCharacter("Philip", "Fry", "human"),
                new FuturamaCharacter("Turanga", "Leela", "mutant"));

        System.out.println("Robots:");
        printCharactersBySpecies(characters, c -> c.getSpecies().equals("robot"));

        System.out.println("Mutants:");
        printCharactersBySpecies(characters, new MutantSpeciesPredicate());

        System.out.println("Humans:");
        printCharactersBySpecies(characters, c -> c.getSpecies().equals("human"),
                c -> System.out.println(c.getFirstName() + " " + c.getLastName().toUpperCase()));
    }

    public static void printCharactersBySpecies(List<FuturamaCharacter> characters,
                                             Predicate<FuturamaCharacter> predicate) {
        characters.stream()
                .filter(predicate::test)
                .forEach(c -> System.out.println(c.getFirstName() + " " + c.getLastName()));
    }

    public static void printCharactersBySpecies(List<FuturamaCharacter> characters,
                                                Predicate<FuturamaCharacter> predicate,
                                                Consumer<FuturamaCharacter> consumer) {
        characters.stream()
                .filter(predicate::test)
                .forEach(consumer::accept);
    }
}

class MutantSpeciesPredicate implements Predicate<FuturamaCharacter> {
    @Override
    public boolean test(FuturamaCharacter character) {
        return character.getSpecies().equals("mutant");
    }
}

class FuturamaCharacter {
    private String firstName;
    private String lastName;
    private String species = "human";

    public FuturamaCharacter(String firstName, String lastName, String species) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.species = species;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpecies() { return species; }
}
