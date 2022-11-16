import com.test.springboot.user.UserManagementApp;
import com.test.springboot.user.controller.UserController;
import com.test.springboot.user.exception.*;
import com.test.springboot.user.model.User;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = UserManagementApp.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest {

    @Autowired
    private UserController userController;


    User user1 = new User("testtest1","testtest","2000-01-01","France","M","0101010101");
    User user2 = new User("testtest2","testtest","1950-01-01","France","F","0122334455");
    User user3 = new User("testtest3","testtest","1988-01-01","France","M","0101010101");

    User userWithoutBirthDate =  new User("userWithoutBirthDate","testtest",null,"France","M","0101010101");
    User userWithoutUsername =  new User(null,"testtest","2000-01-01","France","M","0101010101");
    User userWithoutPassword =  new User("userWithoutPassword",null,"2000-01-01","France","M","0101010101");
    User userWithoutResidenceCountry =  new User("userWithoutResidenceCountry","testtest","2000-01-01",null,"M","0101010101");

    User userUnder18 = new User("testtest","testtest","2010-01-01","France","M","0101010101");
    User userFromToronto =  new User("userWithoutBirthDate","testtest","2000-01-01","Toronto","M","0101010101");

    User userWithShortUsername =  new User("sh","testtest","2000-01-01","France","M","0101010101");
    User userWithWrongBirthDate =  new User("userWithWrongBirthDate","testtest","eee","France","M","0101010101");

    User userWithoutOptionalFields = new User("userWithoutOptionalFields","testtest","2000-01-01","France");
    @Test
    @Order(1)
    public void checkController() {
        assertNotNull(this.userController);
        this.userController.clean();
        Logger.getAnonymousLogger().info("Init test ok");
    }


    @Test
    @Order(2)
    public void checkValidInsertion(){
        try{
            this.userController.save(user1);
            this.userController.save(user2);
            this.userController.save(userWithoutOptionalFields);

            assertEquals(this.userController.getByUsername(user1.getUsername()).toString(),user1.toString());
            assertEquals(this.userController.getByUsername(user2.getUsername()).toString(),user2.toString());
            assertEquals(this.userController.getByUsername(userWithoutOptionalFields.getUsername()).toString(),userWithoutOptionalFields.toString());
            Logger.getAnonymousLogger().info("Valid insertion test OK");
        }
        catch(Exception e){
            Logger.getAnonymousLogger().info("Exception when trying to add new users" + e);
        }
    }


    @Test
    @Order(3)
    public void checkUserFields(){
        try{
            assertThrows(Under18Exception.class, () -> this.userController.save(userUnder18));
            assertThrows(MissingFieldException.class, () -> this.userController.save(userWithoutBirthDate));
            assertThrows(MissingFieldException.class, () -> this.userController.save(userWithoutPassword));
            assertThrows(MissingFieldException.class, () -> this.userController.save(userWithoutUsername));
            assertThrows(MissingFieldException.class, () -> this.userController.save(userWithoutResidenceCountry));
            assertThrows(FormatException.class, () -> this.userController.save(userWithShortUsername));
            assertThrows(UsernameUsedException.class, () -> this.userController.save(user1));
            assertThrows(FormatException.class, () -> this.userController.save(userWithWrongBirthDate));
            assertThrows(NotFrenchResidentException.class, () -> this.userController.save(userFromToronto));
            Logger.getAnonymousLogger().info("Fields checking test ok");

        }
        catch (Exception e){
            Logger.getAnonymousLogger().info(e.getStackTrace().toString());
        }
    }

    @Test
    @Order(4)
    public void checkRegisteredUser() throws Exception{
        try{
            assertEquals(this.userController.getAll().size(),3);
            Logger.getAnonymousLogger().info("Registered users test OK");
        }
        catch(NullPointerException e){
            throw e;
        }
        catch(Exception e){
            throw e;
        }
    }
}
