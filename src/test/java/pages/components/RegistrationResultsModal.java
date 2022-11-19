package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {
    public void veifyModalAppears(){
        $(".modal-dialog").should(appear);
        $(".modal-dialog").shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResult(String key, String value){
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }


}

