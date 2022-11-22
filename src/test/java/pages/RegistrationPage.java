package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            numberInput = $("[id=userNumber]"),
            dateOfBirthDayInput = $("[id=dateOfBirthInput]"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbies-checkbox-1"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#stateCity-wrapper"),
            cityInput = $("#stateCity-wrapper"),
            submitInput = $("#submit"),
            closeInput = $("#closeLargeModal");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhone(String value) {
        numberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        dateOfBirthDayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.veifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResults(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;

    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies() {
        hobbiesInput.parent().click();
        return this;
    }

    public RegistrationPage setPicture(String value) {
        pictureInput.uploadFile(new File(value));
        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        $("#state").click();
        stateInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        $("#city").click();
        cityInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setSubmit() {
        submitInput.click();
        return this;
    }

    public RegistrationPage closeTable(){
        closeInput.click();
        return this;
    }

}


