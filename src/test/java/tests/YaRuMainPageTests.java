package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class YaRuMainPageTests extends TestBase {

    @Test
    @AllureId("12740")
    @DisplayName("Проверка отображения логотипа в левом верхнем углу")
    @Story("Отображение элементов")
    @Owner("allure8")
    @Feature("ya.ru - Страница поиска")
    public void LogoPresenceTest() {
        step("Открыть сайт ya.ru", () -> {
            open("");
        });
        step("Проверить наличие логотипа (красный круг со стилизованной буквой Я) в левом верхнем углу", () -> {
            $x("//*[@data-statlog='headline.logo']").shouldBe(Condition.visible);
        });
    }

    @Test
    @AllureId("12741")
    @DisplayName("Проверка отображения плейсхолдера в строке запроса")
    @Story("Отображение элементов")
    @Owner("allure8")
    @Feature("ya.ru - Страница поиска")
    public void placeholderPresenceTest() {
        step("Открыть сайт ya.ru", () -> {
            open("");
        });
        step("Проверить наличие плейсхолдера найдётся всё в строке поискового запроса", () -> {
            $("input.search3__input").shouldHave(Condition.attribute("placeholder", "найдётся всё"));
        });
    }
}
