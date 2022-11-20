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
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void formTests(){

        registrationFormPage.openPage()
                .setFirstName("Mike")
                .setLastName("Turilov")
                .setEmail("example@google.com")
                .setGender("Other")
                .setPhone("9001546995")
                .setBirthDay("30", "July", "2008")
                .setSubjects("Maths")
                .setHobbies()
                .setPicture()
                .setAddress("Some Address")
                .setState("NCR")
                .setCity("Delhi");


        $("#submit").click();

        registrationFormPage.verifyResultsModalAppears()
                .verifyResults("Student Name", "Mike" + " Turilov")
                .verifyResults("Student Email", "example@google.com")
                .verifyResults("Gender", "Other")
                .verifyResults("Mobile", "9001546995")
                .verifyResults("Date of Birth", "30 July,2008")
                .verifyResults("Subjects", "Maths")
                .verifyResults("Hobbies", "Sports")
                .verifyResults("Picture", "1.png")
                .verifyResults("Address", "Some Address")
                .verifyResults("State and City", "NCR Delhi");



        $("#closeLargeModal").click();

    }
}
