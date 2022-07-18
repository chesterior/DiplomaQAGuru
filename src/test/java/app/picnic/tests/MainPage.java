package app.picnic.tests;

import app.picnic.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPage extends TestBase {
    @Test
    @Description("First test")
    @DisplayName("Logo \"Picnic\" should exist")
    void generatedTest() {
        step("Open https://www.picnic.app/", () -> {
            open("https://www.picnic.app/");
        });

        step("check logo", () -> {
            $(".logo.transition-trigger").shouldBe(visible);
        });
    }

    @Test
    @Description("Second test")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open https://picnic.app/nl/", () ->
            open("https://picnic.app/nl/"));

        step("Page title should have text 'Picnic Online Supermarkt | Jouw dagelijkse boodschappen gratis bezorgd'", () -> {
            String expectedTitle = "Picnic Online Supermarkt | Jouw dagelijkse boodschappen gratis bezorgd";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Third test")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open https://picnic.app/nl/", () ->
            open("https://picnic.app/nl/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}