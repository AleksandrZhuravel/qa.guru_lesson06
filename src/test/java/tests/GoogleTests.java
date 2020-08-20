package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


class GoogleTests {
    @Test
    void selenideSearchTest() {
        open("https://google.com");
     
        $(byName("q")).setValue("Selenide").pressEnter();
        
        $("html").shouldHave(text("ru.selenide.org"));
    }

    @Test
    void picturePageShouldOpenTest() {
        open("https://google.com");

        $(by("data-pid", "2")).click();
        $(byText("Картинки")).click();

        $(byTitle("Картинки Google")).shouldBe(visible);
    }

    @Test
    void googleApplicationsPopupShouldBeExpandedTest() {
        open("https://google.com");

        $(byTitle("Приложения Google")).click(); 
        
        $("iframe[role='presentation']").shouldBe(enabled); 
    }
}
