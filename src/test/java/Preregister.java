import ru.pom.stella.burger.PageRegistration;
import org.junit.BeforeClass;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class Preregister {

    protected static Map<String, String> map;

    @BeforeClass
    public static void precondition() {


        PageRegistration pageRegistration = open("http://stellarburgers.nomoreparties.site/register", PageRegistration.class);
        map = pageRegistration.registrationUser();
    }
}