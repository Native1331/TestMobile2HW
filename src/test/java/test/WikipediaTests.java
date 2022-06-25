package test;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class WikipediaTests extends TestBase {
    @Test
    void openApp() {
        back();
        step("Open Wikipedia app", () -> {
            $(AppiumBy.id("org.wikipedia:id/bottomOffset")).click();// Продолжить
            $(AppiumBy.id("org.wikipedia:id/bottomOffset")).click();
            $(AppiumBy.id("org.wikipedia:id/bottomOffset")).click();
            $(AppiumBy.id("org.wikipedia:id/bottomOffset")).click(); // Начать
        });
        step("Verify content found", () ->
                $(AppiumBy.id("org.wikipedia:id/feed_view"))
                        .shouldHave(Condition.text("Самое читаемое")));


        back();
        step(" Save title", () -> {
            $(AppiumBy.id("org.wikipedia:id/navigation_bar_item_icon_view")).click();
        });
        step("Verify content found", () ->
                $(AppiumBy.id("org.wikipedia:idandroid.view.ViewGroup"))
                        .shouldHave(Condition.text("Сохранённое")));

        back();
        step("Open Elon Musk page", () -> {
            $(AppiumBy.id("org.wikipedia:id/android.view.ViewGroup")).click();
        });
        step("Verify content found", () ->
                $(AppiumBy.id("org.wikipedia:id/footerActionButton"))
                        .shouldHave(Condition.text("Elon Musk")));

        back();
        step("Open Top Gun: Maverick page", () -> {
            $(AppiumBy.id("org.wikipedia:id/android.view.ViewGroup")).click();
        });
        step("Verify content found", () ->
                $(AppiumBy.id("org.wikipedia:id/footerActionButton"))
                        .shouldHave(Condition.text("Top Gun: Maverick")));


    }
}
   /** MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView");
el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.ImageView");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("Перейти вверх");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("org.wikipedia:id/bottomOffset");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("org.wikipedia:id/secondaryTextView");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementById("org.wikipedia:id/bottomOffset");
        el7.click();
        MobileElement el8 = (MobileElement) driver.findElementById("org.wikipedia:id/bottomOffset");
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementById("org.wikipedia:id/bottomOffset");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("org.wikipedia:id/bottomOffset");
        el10.click();
        MobileElement el11 = (MobileElement) driver.findElementByXPath("//android.widget.HorizontalScrollView[@content-desc=\"Шаг 3 из 4\"]/android.widget.LinearLayout/android.widget.LinearLayout[4]");
        el11.click();
        MobileElement el12 = (MobileElement) driver.findElementById("org.wikipedia:id/secondaryTextView");
        el12.click();
        MobileElement el13 = (MobileElement) driver.findElementById("org.wikipedia:id/secondaryTextView");
        el13.click();
        MobileElement el14 = (MobileElement) driver.findElementById("org.wikipedia:id/switchView");
        el14.click();
        MobileElement el15 = (MobileElement) driver.findElementById("org.wikipedia:id/bottomOffset");
        el15.click();
        MobileElement el16 = (MobileElement) driver.findElementByXPath("//android.widget.HorizontalScrollView[@content-desc=\"Шаг 3 из 4\"]/android.widget.LinearLayout/android.widget.LinearLayout[4]");
        el16.click();
        MobileElement el17 = (MobileElement) driver.findElementById("org.wikipedia:id/bottomOffset");
        el17.click();
        MobileElement el18 = (MobileElement) driver.findElementByXPath("//android.widget.HorizontalScrollView[@content-desc=\"Шаг 3 из 4\"]/android.widget.LinearLayout/android.widget.LinearLayout[4]");
        el18.click();
        el18.click();
        MobileElement el19 = (MobileElement) driver.findElementById("org.wikipedia:id/fragment_onboarding_done_button");
        el19.click();
        MobileElement el22 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/androidx.cardview.widget.CardView/android.widget.TextView");
        el22.click();
        MobileElement el23 = (MobileElement) driver.findElementById("org.wikipedia:id/search_src_text");
        el23.sendKeys("QA Engineer");
        MobileElement el24 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[2]");
        el24.click();
        MobileElement el25 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]");
        el25.click();**/

