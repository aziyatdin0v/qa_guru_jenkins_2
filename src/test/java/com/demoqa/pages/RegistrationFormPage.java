package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;
import com.demoqa.pages.components.StateAndCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    private final static String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();
    private ResultsModal resultsModal = new ResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderSelect = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureUpload = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            submitButton = $("#submit");


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationFormPage setEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public RegistrationFormPage setGender(String gender) {
        genderSelect.$(byText(gender)).click();

        return this;
    }

    public RegistrationFormPage setPhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbies(String hobbies) {
        hobbiesInput.$(byText(hobbies)).click();

        return this;
    }

    public RegistrationFormPage setUploadPicture(String fileName) {
        pictureUpload.uploadFromClasspath(fileName);

        return this;
    }

    public RegistrationFormPage setCurrentAddress(String address) {
        currentAddress.setValue(address);

        return this;
    }

    public RegistrationFormPage setStateAndCity(String state, String city) {
        stateAndCityComponent.setLocation(state, city);

        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsModal.checkVisible();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsModal.checkResult(key, value);

        return this;
    }

    public RegistrationFormPage setSubmit() {
        submitButton.click();

        return this;
    }
}
