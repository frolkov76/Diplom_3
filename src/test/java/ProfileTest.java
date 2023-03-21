import ru.pom.stella.burger.PageAuthorization;
import ru.pom.stella.burger.PageMainStellarBurgers;
import ru.pom.stella.burger.PagePersonalAccount;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class ProfileTest extends Preregister {
    private static PageMainStellarBurgers pageMainStellarBurgers;
    private static PageAuthorization pageAuthorization;

    public static void setPageAuthorization(PageAuthorization pageAuthorization) {
        ProfileTest.pageAuthorization = pageAuthorization;
    }


    @Before
    public void openSite() {
        pageMainStellarBurgers = open("https://stellarburgers.nomoreparties.site/", PageMainStellarBurgers.class);

        pageMainStellarBurgers.clickButtonPersonalAccount();
        PageAuthorization pageAuthorization = Selenide.page(PageAuthorization.class);
        pageAuthorization.checkLoginPage();
        pageAuthorization.setInputEmail(map.get("email"));
        pageAuthorization.setInputPassword(map.get("password"));
        pageAuthorization.clickButtonLogIn();
        pageMainStellarBurgers.clickButtonPersonalAccount();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Проверка выхода из аккаунта")
    public void logoutUserTest() {
//
        PagePersonalAccount pagePersonalAccount = Selenide.page(PagePersonalAccount.class);
        pagePersonalAccount.clickExitButton();
        pageAuthorization.checkLoginPage();
        Assert.assertTrue("Выход из аккаунта не выполнен", pageAuthorization.displayedButtonLoginPage());
    }

    @Test
    @DisplayName("Проверка перехода по клику на личный кабинет")
    public void goToYourPersonalAccountTest() {

        PagePersonalAccount pagePersonalAccount = Selenide.page(PagePersonalAccount.class);
        Assert.assertEquals("Имя пользователя в личном кабинете не соответствует ожидаемому", pagePersonalAccount.getInputAccountName(), map.get("name"));
    }

    @Test
    @DisplayName("Проверка перехода по клику на Конструктор")
    public void goToConstructorTest() {

        pageMainStellarBurgers.clickButtonConstructor();
        assertTrue("Переход по клику на конструктор не выполнен", pageMainStellarBurgers.checkTextAssembleTheBurger());
    }

    @Test
    @DisplayName("Проверка перехода по клику на логотип")
    public void goToLogoTest() {

        pageMainStellarBurgers.clickButtonLogoStellarBurgers();
        assertTrue("Переход по клику на логотип не выполнен", pageMainStellarBurgers.checkTextAssembleTheBurger());
    }

}
