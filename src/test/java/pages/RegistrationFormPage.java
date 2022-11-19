package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("[id=firstName]"),
            lastNameInput = $("[id=lastName]"),
            EmailInput = $("[id=userEmail"),
            genderInput = $("#genderWrapper"),
            numberInput = $("[id=userNumber]");
    public RegistrationFormPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value){
        EmailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value){
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setPhone(String value){
        numberInput.setValue(value);
        return this;
    }
}
