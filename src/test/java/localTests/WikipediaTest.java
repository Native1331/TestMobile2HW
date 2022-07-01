package localTests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class WikipediaTest extends TestBase {

    @Tag("android")
    @Test
    void openApp() {

        step("Open Wikipedia app", () -> {
            $(AppiumBy.id("org.wikipedia:id/option_label"))
      //        $(AppiumBy.className("android.widget.TextView[2]"))
                  .shouldHave(Condition.text("English"));
            $(AppiumBy.className("android.widget.ImageView")).click();
            $(AppiumBy.className("android.widget.LinearLayout")).click();
        });
        step("Choose another language", () -> {
            $(AppiumBy.className("android.widget.LinearLayout")).click();
            $(AppiumBy.xpath("//android.widget.TextView[@text = 'ADD LANGUAGE']")).click();
            $$(AppiumBy.className("android.widget.LinearLayout")).get(2).click();
            back();
            $$(AppiumBy.xpath("//android.widget.TextView")).get(3)
                    .shouldHave(Condition.text("Русский"));
        });
        step("Make a syncing", () -> {
            $$(AppiumBy.className("android.widget.LinearLayout")).get(2).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView")).click();
            $(AppiumBy.className("android.widget.LinearLayout")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView"))
                    .shouldHave(Condition.text("Вы можете создавать списки для чтения из статей, которые вы хотите " +
                            "прочитать позже, даже если вы находитесь в офлайне. \n" +
                            "Авторизуйтесь с помощью учётной записи Википедии для синхронизации ваших списков для" +
                            " чтения. Происоединяйтесь к Википедии"));
        });
        step("Make a reports", () -> {
            $(AppiumBy.xpath(("//android.widget.LinearLayout[4]"))).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/switchView"))
                    .shouldHave(Condition.text("Отправлять отчёты об использовании"));
            $(AppiumBy.xpath("//android.widget.Button[@text='НАЧАТЬ']")).click();
        });
        step("Open main page", () -> {
            $(AppiumBy.className("android.widget.TextView"))
                    .shouldHave(Condition.text("Поиск по Википедии"));
            $(AppiumBy.className("android.widget.TextView")).click();
        });
        step(" Search  page with text Инженер по тестированию", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("Инженер по тестированию");
            $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(Condition.text("Тестирование"));
        });
    }
    }
