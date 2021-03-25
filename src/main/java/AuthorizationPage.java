import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class AuthorizationPage {
    private By page = By.xpath("//div[@class='tocenter']/h1");
    private By userName = By.xpath("//input[@id='login']");
    private By passWord = By.xpath("//input[@id='pass']");
    private By signUp = By.xpath("//input[@value='Войти']");
    private By error = By.xpath("//div[@id='error']");
    private By changeUser = By.xpath("//a[@class='ua']");

    public AuthorizationPage open() {
        Selenide.open("/");
        return this;
    }

    public AuthorizationPage typeUserName(String username) {
        $(userName).val(username);
        return this;
    }

    public AuthorizationPage typePassword(String password) {
        $(passWord).val(password);
        return this;
    }

    public AuthorizationPage clickSignUp() {
        $(signUp).shouldBe().click();
        return this;
    }

    public boolean isError() {
        return $(error).shouldBe(Condition.visible).exists();//isDisplayed();
    }

    public boolean notError() {
        return $(changeUser).shouldHave(Condition.text("Сменить пользователя")).exists();
    }
    public AuthorizationPage autorization(String name,String password){
       typeUserName(name);
       typePassword(password);
       clickSignUp();
        return  this;
    }
}
