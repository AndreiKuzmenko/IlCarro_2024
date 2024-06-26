import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void precondition() {
        if (app.getUser().isLogged()) app.getUser().logout();
    }

    @Test
    public void registrationPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User()
                .withName("Joy")
                .withLastName("Klopp")
                .withEmail("joy_" + i + "@mail.com")
                .withPassword("$Asdf1234");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoggedSuccess());}

//
//    @AfterMethod
//    public void postcondition(){
//        app.getUser().clickOkButton();
//    }
}
