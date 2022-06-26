package localTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;

public class TestBase {
    String firstElement="org.wikipedia.alpha:id/00000000-0000-0133-ffff-ffff00000073";

    String secondElement="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/" +
            "android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView" +
            "/android.widget.LinearLayout[4]/android.widget.ImageView";

    String thirdElement="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/" +
            "android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/" +
            "android.widget.LinearLayout[5]";

    String fourthElement="//android.widget.HorizontalScrollView[@content-desc=Шаг 3 из 4]/" +
            "android.widget.LinearLayout/android.widget.LinearLayout[4]";
    String fifthElement="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/ +" +
            "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/ +" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/ +" +
            "android.view.ViewGroup/androidx.viewpager.widget.ViewPager/ +" +
            "androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/ +" +
            "android.view.ViewGroup/android.widget.FrameLayout/ +" +
            "androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/ +" +
            "androidx.cardview.widget.CardView/android.widget.TextView";
    String sixthElement="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/" +
            "android.view.ViewGroup/android.widget.HorizontalScrollView/android.widget.LinearLayout/" +
            "android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[2]";
    String sevenElement="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/" +
            "android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]";



    @BeforeAll
    public static void setup() {
        Configuration.browser = LocalMobileDriver.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());

        open();
    }

    @AfterEach
    public void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        step("Close driver", Selenide::closeWebDriver);
    }
}

