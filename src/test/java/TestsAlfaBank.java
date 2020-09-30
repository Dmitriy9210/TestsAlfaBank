import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static helpers.AttachmentsHelper.*;
import static helpers.DriverHelper.configureSelenide;
import static helpers.DriverHelper.getConsoleLogs;
import static io.qameta.allure.Allure.step;

@Story("Использование Lambda steps")
@Owner("Dmitriy")
@Tag("alfaTest")
public class TestsAlfaBank {


    @BeforeEach
    void setUp() {
        configureSelenide();
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));

        step("Open Site AlfaBank", () -> {
            open("https://alfabank.ru/");
        });
    }

    @Tag("clickTest")
    @Test
    void openPrivatePerson() {
        step("Open \"Частным лицам\"", () -> {
            $(".h1Cda9K").$(byText("Частным лицам")).click();
            $(".a2I4Oki.h1NqZY9").shouldHave(Condition.text("ДЕНЬГИ НА ЛЮБЫЕ ЦЕЛИ"));
        });
    }

    @Tag("clickTest")
    @Test
    void openIp() {
        step("Open \"Малому бизнесу и ИП\"", () -> {
            $(".h1Cda9K").$(withText("Малому бизнесу")).click();
            $("#Hide").shouldHave(Condition.text("Управляйте бизнесом"));
        });
    }

    @Tag("clickTest")
    @Test
    void openCorp() {
        step("Open \"Корпорациям\"", () -> {
            $(".h1Cda9K").$(withText("Корпорациям")).click();
            $(".sme-form", 0).shouldBe(Condition.visible);

        });
    }

    @Tag("searchTest")
    @Test
    void searchOnSite() {
        step("Open Search", () -> {
            $(".a3qH-MS").click();
            $(by("type", "search")).shouldBe(Condition.visible);
            $(by("type", "search")).setValue("Вклад" + Keys.ENTER);
            $("#ya-site-results").shouldHave(Condition.text("Вклады"));
        });
    }

    @AfterEach
    void closeAll() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        closeWebDriver();
    }
}