package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class YandexTests {
    @Test
    void yandexUnitFrameShouldOpenTest() {
        open("https://yandex.ru");

        $(byText("Настройка")).click();
        $(byText("Настроить блоки")).click();

        $(".hidden-blocks-popup__inside").shouldBe(enabled);
    }

    @Test
    void searchTest(){
        open("https://yandex.ru");
        $(".input__control").setValue("Selenide").pressEnter();
        $(".organic__url-text").shouldHave(text("Selenide"));
    }

    @Test
    void emptySearchTest(){
        open("https://yandex.ru");
        $(".input__control").setValue("").pressEnter();
        $(".misspell__message").shouldHave(text("Задан пустой поисковый запрос"));
    }

    @Test
    void checkConfidentialTest(){
        open("https://yandex.ru/legal/confidential/");
        $x("//h1").shouldHave(text("Политика конфиденциальности"));
    }
}
