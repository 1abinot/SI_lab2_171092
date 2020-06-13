import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private final SILab2 obj = new SILab2();

    private List<String> addUserToList(String... user) {
        List<String> allUsers = new ArrayList<>();
        if (user[0] != null)
            allUsers.add(user[0]);
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
}
