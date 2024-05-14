package profile.registation;

import profile.Anthropometry;
import profile.Country;
import profile.Gender;
import profile.Goal;
import profile.Profile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public final class RegistrationForm {
    private Scanner scanner;

    public RegistrationForm(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
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

        return new Profile(username, fullName, age, anthropometry, goals, gender, country);
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
        return getIntFromStream();
    }

    private Anthropometry getAnthropometry() {
        System.out.println("Now write your height:");
        int height = getIntFromStream();

        System.out.println("Now write your weight:");
        int weight = getIntFromStream();

        return new Anthropometry(height, weight);
    }

    private Country getCountry() {
        System.out.println("Now write your country:");
        while (true) {
            String countryName = scanner.nextLine();
            try {
                return Country.getFromString(countryName);
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
                return Gender.getFromString(gender);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid gender! Please enter a valid gender.");
            }
        }
    }

    private List<Goal> getGoals() {
        System.out.println(
            "Now choose what are your goals. Write down only the number of it. As you can choose more than one goal.");
        int idx = 1;
        Map<Integer, Goal> goals = new HashMap<>();
        for (Goal goal : Goal.values()) {
            System.out.println(idx + " " + goal.toString());
            goals.put(idx, goal);
            idx++;
        }

        String[] input = scanner.nextLine().split(" ");
        List<Goal> selectedGoals = new ArrayList<>();
        for (String number : input) {
            int num = Integer.parseInt(number);
            //Even though we add new goals, idx will always be the count of them
            if (num < 1 || num >= idx) {
                System.out.println("Invalid goal number: " + number);
            }

            selectedGoals.add(goals.get(num));
        }

        return List.copyOf(selectedGoals);
    }

    private int getIntFromStream() {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Wrong input! Please enter a valid one.");
                scanner.next();
            }
        }
    }
}
