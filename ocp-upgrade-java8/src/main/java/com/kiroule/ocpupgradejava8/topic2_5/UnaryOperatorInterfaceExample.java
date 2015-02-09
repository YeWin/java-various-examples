package com.kiroule.ocpupgradejava8.topic2_5;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * @author Igor Baiborodine
 */
public class UnaryOperatorInterfaceExample {

    public static void main(String... args) {

        List<FuturamaCharacter> characters = Arrays.asList(
                new FuturamaCharacter("Bender", "Rodriguez"),
                new FuturamaCharacter("Philip", "Fry"),
                new FuturamaCharacter("Amy", "Wong")
        );

        UnaryOperator<String> toUpperCaseUnaryOperator = String::toUpperCase;
        for (FuturamaCharacter c : characters) {
            System.out.println("Full name: " + c.getFirstName() + " "
                    + toUpperCaseUnaryOperator.apply(c.getLastName()));
        }
        // the same, one-liner
        characters.forEach(c -> System.out.println("Full name: " + c.getFirstName()
                + " " + toUpperCaseUnaryOperator.apply(c.getLastName())));
    }
}

class FuturamaCharacter {

    private String firstName;
    private String lastName;

    public FuturamaCharacter(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}