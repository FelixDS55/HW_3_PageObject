package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;



public class RegistrationPagePOWithFaker extends RandomUtils{

    RegistrationPage registrationFormPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();
    Faker faker = new Faker();

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void formTests(){
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().subscriberNumber(10);
        String gender = getRandomGender();
        String day = getRandomDay();
        String month = getRandomMonth();
        String year = getRandomYear();
        String subject = "Maths";
        String picture = "src/test/resources/1.png";
        String namePic = "1.png";
        String address = faker.address().fullAddress();
        String state = "NCR";
        String city = getRandomCity();
        String hobbies = "Sports";


        registrationFormPage.openPage()

                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDay(day, month, year)
                .setSubjects(subject)
                .setHobbies()
                .setPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .setSubmit();

        registrationFormPage.verifyResultsModalAppears()
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", phone)
                .verifyResults("Date of Birth", day + " " + month + "," + year)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobbies)
                .verifyResults("Picture", namePic)
                .verifyResults("Address", address)
                .verifyResults("State and City", state + " " + city)
                .closeTable();

    }
}
