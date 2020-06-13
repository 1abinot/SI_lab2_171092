import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private final SILab2 obj = new SILab2();

    private List<String> addUserToList(String... user) {
        List<String> allUsers = new ArrayList<>();
        List<String> usersData = Arrays.asList(user);
        allUsers.addAll(usersData);
        return allUsers;
    }

    @Test
    void everyBranchTest() {
        //A,B - Q
        assertEquals(false, obj.function(null, addUserToList("null")));

        //A,B - C ; C - Q
        assertEquals(false, obj.function(new User("labinot", null, "labi.aziri1@gmail.com"), addUserToList("labinot", "null", "labi.aziri1@gmail.com")));

        //A,B - C ; C - D,E ; D,E - F ; F - Q
        assertEquals(false, obj.function(new User("labinot", "labinot", "labi.aziri1@gmail.com"), addUserToList("labinot", "labinot", "labi.aziri1@gmail.com")));

        //A,B - C ; C - D,E ; D,E - F ; F - G ; G - H ; H - I ; I - K ; K - M ; M - O ; O - Q
        assertEquals(false, obj.function(new User("labinot", "labinotttt", "labi.aziri1@gmail.com"), addUserToList("1abinot", "labinotttt", "labi.aziri1@gmail.com")));

        //A,B - C ; C - D,E ; D,E - F ; F - G ; G - H ; H - I ; I - J ; J - K ; K - L ; L - M ; M - N ; N - O ; O - P
        assertEquals(true, obj.function(new User("labinot", "Labi.1234", "labi.aziri1@gmail.com"), addUserToList("labinot", "Labinot.123", "labi.aziri1@gmail.com")));
    }

    @Test
    void multipleConditionsTest() {

        //user.getUsername()!=null && user.getPassword()!=null

        //T T
        assertEquals(true, obj.function(new User("labinot","Labi.1234","labi.aziri1@gmail.com"),addUserToList("labinot","labinot","labi.aziri1@gmail.com")));
        //T F
        assertEquals(false, obj.function(new User("labinot", "labi", "labi.aziri1@gmail.com"), addUserToList("labinot", "labi", "labi.aziri1@gmail.com")));
        //F X
        assertEquals(false,obj.function(new User("labinot","labi.123","labi.aziri1@gmail.com"),addUserToList("labinot","labi.123","labi.aziri1@gmail.com")));



        //!passwordLower.contains(user.getUsername().toLowerCase()) && password.length()>=8

        //T T
        assertEquals(true, obj.function(new User("labinot","Labi_123","labi.aziri1@gmail.com"),addUserToList("labinot","Labi_1234","labi.aziri1@gmail.com")));
        //T F
        assertEquals(false, obj.function(new User("labinot","Labi123","labi.aziri1@gmail.com"),addUserToList("labinot","Labi_123","labi.aziri1@gmail.com")));
        //F X
        assertEquals(false, obj.function(new User("labinot", "labinot", "labi.aziri1@gmail.com"), addUserToList("labinot", "labinot", "labi.aziri1@gmail.com")));


        //digit && upper && special

        //T T T
        assertEquals(true, obj.function(new User("labinot", "Labi_1234", "labi.aziri1@gmail.com"), addUserToList("labinot", "Labi_1234", "labi.aziri1@gmail.com")));
        //T T F
        assertEquals(false, obj.function(new User("labinot", "Labi1234", "labi.aziri1@gmail.com"), addUserToList("labinot", "Labi1234", "labi.aziri1@gmail.com")));
        //T F X
        assertEquals(false, obj.function(new User("labinot", "labi_1234", "labi.aziri1@gmail.com"), addUserToList("labinot", "labi_1234", "labi.aziri1@gmail.com")));
        //F X X
        assertEquals(false, obj.function(new User("labinot", "labinot_", "labi.aziri1@gmail.com"), addUserToList("labinot", "labinot_", "labi.aziri1@gmail.com")));
    }

}
