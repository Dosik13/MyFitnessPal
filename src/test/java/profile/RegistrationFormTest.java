package profile;

import org.junit.jupiter.api.Test;
import profile.registation.RegistrationForm;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationFormTest {

    @Test
    public void testRegister() {
        String input = "Pe7atN\nPetar\nIvanov\n20\n190\n75\nBulgaria\nmale\n3 4";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        RegistrationForm registrationForm = new RegistrationForm(inputStream);

        Profile profile = registrationForm.register();

        assertEquals("Pe7atN", profile.getUsername());
        assertEquals("Petar Ivanov", profile.getFullName());
        assertEquals(20, profile.getAge());
        assertEquals(190, profile.getAnthropometry().height());
        assertEquals(75, profile.getAnthropometry().weight());
        assertEquals(Country.BULGARIA, profile.getCountry());
        assertEquals(Gender.MALE, profile.getGender());
        assertTrue(profile.getGoals().contains(Goal.FAT_LOSS));
        assertTrue(profile.getGoals().contains(Goal.MUSCLE_GAIN));
    }
}
