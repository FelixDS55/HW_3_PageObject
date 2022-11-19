package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("[id=firstName]"),
            lastNameInput = $("[id=lastName]"),
            EmailInput = $("[id=userEmail"),
            genderInput = $("#genderWrapper"),
            numberInput = $("[id=userNumber]");
    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value){
        EmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhone(String value){
        numberInput.setValue(value);
        return this;
    }
}
