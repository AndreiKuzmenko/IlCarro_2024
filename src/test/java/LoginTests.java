import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

@Test
    public void LoginPositive(){

    String email = "qwe777@gmail.com", password = "123@Qwe123";
    app.getUser().openLoginForm();
    app.getUser().fillLoginForm(email, password);
    app.getUser().submitLogin();
    Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
}
}
