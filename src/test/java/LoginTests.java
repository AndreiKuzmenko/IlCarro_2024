import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void precondition()  {
        if (app.getUser().isLogged()){
        app.getUser().logout();}
    }

@Test
    public void LoginPositive(){
//User user = new User("qwe777@gmail.com","123@Qwe123");
    User user = new User()
            .withEmail("qwe777@gmail.com")
            .withPassword("123@Qwe123");

    app.getUser().openLoginForm();
    app.getUser().fillLoginForm(user.getEmail(), user.getPassword());
    app.getUser().submitLogin();
    Assert.assertTrue(app.getUser().isLoggedSuccess());
}
    @Test
    public void LoginPositiveUser(){
//User user = new User("qwe777@gmail.com","123@Qwe123");
        User user = new User()
                .withEmail("qwe777@gmail.com")
                .withPassword("123@Qwe123");

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
       // Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }
    @AfterMethod
    public void postcondition(){
     app.getUser().clickOkButton();
    }
}
