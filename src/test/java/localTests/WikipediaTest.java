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
            $(AppiumBy.xpath("//android.widget.LinearLayout[3]")).click();
            //     $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView")).click();
            //     $(AppiumBy.className("android.widget.LinearLayout")).click();
            $$(AppiumBy.className("android.widget.TextView")).get(1)
                    .shouldHave(Condition.text("You can make reading lists from articles you want " +
                            "to read later, even when you’re offline. " +
                            "Login to your Wikipedia account to sync your reading lists. Join Wikipedia"));
        });
        step("Make a reports", () -> {
            $(AppiumBy.xpath(("//android.widget.LinearLayout[4]"))).click();
            $(AppiumBy.className("android.widget.TextView"))
                    .shouldHave(Condition.text("Send anonymous data"));
            $(AppiumBy.xpath("//android.widget.Button[@text='GET STARTED']")).click();
        });
        step("Open main page", () -> {
            $(AppiumBy.className("android.widget.TextView"))
                    .shouldHave(Condition.text("SEARCH"));
            $(AppiumBy.className("android.widget.TextView")).click();
        });
        step(" Search  page with text QA", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("QA");
            $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(Condition.text("QUALITY ASSURANCE"));
        });
    }
}