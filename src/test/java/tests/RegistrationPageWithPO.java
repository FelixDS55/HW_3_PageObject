package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class RegistrationPageWithPO {
    RegistrationPage registrationFormPage = new RegistrationPage();



    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void formTests(){

        registrationFormPage.openPage()
                .setFirstName("Mike")
                .setLastName("Turilov")
                .setEmail("example@google.com")
                .setGender("Other")
                .setPhone("9001546995")
                .setBirthDay("30", "July", "2008");



        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Maths");
        $("#subjectsInput").pressEnter();
        $("#subjectsInput").pressTab();
        $("#hobbies-checkbox-1").parent().click();
//        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#uploadPicture").uploadFile(new File("src/test/resources/1.png"));
        $("#currentAddress").setValue("Some Address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        registrationFormPage.verifyResultsModalAppears()
                .verifyResults("Student Name", "Mike" + " Turilov")
                .verifyResults("Student Email", "example@google.com")
                .verifyResults("Gender", "Other")
                .verifyResults("Mobile", "9001546995")
                .verifyResults("Date of Birth", "30 July,2008");


        $(".modal-content").shouldBe(Condition.visible);
        $(".modal-content").shouldHave(text("Maths"));
        $(".modal-content").shouldHave(text("Sports"));
        $(".modal-content").shouldHave(text("1.png"));
        $(".modal-content").shouldHave(text("Some Address"));
        $(".modal-content").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();

    }
}
