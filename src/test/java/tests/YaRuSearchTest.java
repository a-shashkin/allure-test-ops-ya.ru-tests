package tests;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class YaRuSearchTest extends TestBase {

    @Test
    @AllureId("12742")
    @DisplayName("Проверка отображения результатов поискового запроса")
    @Story("Поисковые запросы")
    @Owner("allure8")
    @Feature("ya.ru - Страница поиска")
    public void searchResultPresenceTest() {
        step("Открыть сайт ya.ru", () -> {
            open("");
        });
        step("Ввести запрос в строку поиска", () -> {
            $(".search3__input").sendKeys("GitHub");
            $(".search3__button").click();
        });
        step("Убедиться, что количество ссылок в результатах поиска больше 0", () -> {
            $$("li.serp-item").shouldBe(CollectionCondition.sizeGreaterThan(0));
        });
    }
}
