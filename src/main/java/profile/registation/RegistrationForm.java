package profile.registation;

import profile.Anthropometry;
import profile.Country;
import profile.Gender;
import profile.Goal;
import profile.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class RegistrationForm {
    private Scanner scanner;

    public RegistrationForm() {
        this.scanner = new Scanner(System.in);
    }

    public Profile register() {
        System.out.println("Create your account");

        String username = getUsername();
        String fullName = getFullName();
        int age = getAge();
        Anthropometry anthropometry = getAnthropometry();
        Country country = getCountry();
        Gender gender = getGender();
        List<Goal> goals = getGoals();

        return Profile.builder(username).setFullName(fullName).setAge(age).setAnthropometry(anthropometry)
            .setCountry(country).setGender(gender).setGoals(goals).build();
    }

    private String getUsername() {
        System.out.println("Write down your username:");
        String username = scanner.nextLine();
        System.out.println("Welcome to our app " + username);
        return username;
    }

    private String getFullName() {
        System.out.println("Now write your first name:");
        String firstName = scanner.nextLine();
        System.out.println("Now write your surname name:");
        String finalName = scanner.nextLine();
        return firstName + " " + finalName;
    }

    private int getAge() {
        System.out.println("Now write your age:");
        while (true) {
            if (scanner.hasNextInt()) {
                int age = scanner.nextInt();
                return age;
            } else {
                System.out.println("Wrong input! Please enter a valid age.");
                scanner.next();
            }
        }
    }

    private Anthropometry getAnthropometry() {
        System.out.println("Now write your height and weight:");
        while (true) {
            if (scanner.hasNextInt()) {
                int height = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    int weight = scanner.nextInt();
                    scanner.nextLine();
                    return new Anthropometry(height, weight);
                } else {
                    System.out.println("Wrong input! Please enter both valid height and weight.");
                    scanner.nextLine();
                }
            } else {
                System.out.println("Wrong input! Please enter both valid height and weight.");
                scanner.nextLine();
            }
        }
    }

    private Country getCountry() {
        System.out.println("Now write your country:");
        while (true) {
            String countryName = scanner.nextLine();
            try {
                return Country.getByCountryName(countryName);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid country name! Please enter a valid country name.");
            }
        }
    }

    private Gender getGender() {
        System.out.println("Now choose your gender (male or female):");
        while (true) {
            String gender = scanner.nextLine();
            try {
                return Gender.getByGender(gender);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid gender! Please enter a valid gender.");
            }
        }
    }

    private List<Goal> getGoals() {
        System.out.println(
            "Now choose what are your goals. Write down only the number of it. As u can choose more than one goal.");
        int idx = 1;
        for (Goal goal : Goal.values()) {
            System.out.println(idx + " " + goal.toString());
            idx++;
        }

        String[] input = scanner.nextLine().split(" ");
        List<Goal> selectedGoals = new ArrayList<>();
        for (String number : input) {
            switch (Integer.parseInt(number)) {
                case 1 -> selectedGoals.add(Goal.WEIGHT_LOSS);
                case 2 -> selectedGoals.add(Goal.WEIGHT_GAIN);
                case 3 -> selectedGoals.add(Goal.FAT_LOSS);
                case 4 -> selectedGoals.add(Goal.MUSCLE_GAIN);
                default -> System.out.println("Invalid goal number: " + number);
            }
        }

        return List.copyOf(selectedGoals);
    }
}
