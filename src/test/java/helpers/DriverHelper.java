package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static org.openqa.selenium.logging.LogType.BROWSER;

public class DriverHelper {

    public static void configureSelenide() { // настраиваем браузер
//        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 11000;
        Configuration.headless = true;
        Configuration.browser = "chrome";
    }

    public static String getConsoleLogs() { // подключаемся к браузеру и берем логи из вкладки браузера
        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }
}
