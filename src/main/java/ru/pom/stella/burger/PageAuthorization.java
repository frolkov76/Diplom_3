package ru.pom.stella.burger;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageAuthorization {
    //Строка для ввода email
    @FindBy(how = How.XPATH, using = ".//input [preceding-sibling::label [text() = 'Email']]")
    private SelenideElement inputEmail;

    //Строка для ввода пароля
    @FindBy(how = How.XPATH, using = ".//input [preceding-sibling::label [text() = 'Пароль']]")
    private SelenideElement inputPassword;

    //Кнопка Войти
    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Войти')]")
    private SelenideElement buttonLogIn;

    //Кнопка Восстановить пароль
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Восстановить пароль')]")
    private SelenideElement buttonRecoverPassword;

    //Кнопка перехода на форму регистрации
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Зарегистрироваться')]")
    private SelenideElement buttonGoToTheRegistrationForm;

    @FindBy(how = How.XPATH, using = "//h2[text()='Вход']")
    protected SelenideElement loginText;

    @Step("checkLoginPage")
    public void checkLoginPage() {
        loginText.shouldHave(Condition.text("Вход"));
    }
    @Step("displayedButtonLoginPage")
    public boolean displayedButtonLoginPage() {
        return buttonLogIn.isDisplayed();
    }
    @Step("setInputEmail")
    public void setInputEmail(String email) {

        inputEmail.setValue(email);
    }
    @Step("setInputPassword")
    public void setInputPassword(String password) {
        inputPassword.setValue(password);
    }
    @Step("clickButtonRecoverPassword")
    public void clickButtonRecoverPassword() {
        buttonRecoverPassword.click();
    }
    @Step("clickButtonLogIn")
    public void clickButtonLogIn() {
        buttonLogIn.click();
    }
    @Step("clickButtonGoToTheRegistrationForm")
    public void clickButtonGoToTheRegistrationForm() {
        buttonGoToTheRegistrationForm.click();
    }


}
