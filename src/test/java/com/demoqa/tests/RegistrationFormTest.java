package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.properties.SystemProperties;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.TestData.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormTest extends BaseTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    RegistrationFormPage checkTable = new RegistrationFormPage();

    @Test
    void fillPracticeFormTest() {

        step("Open registrations form", () -> {
            registrationFormPage.openPage();
        });

        step("Fill form", () -> {
            registrationFormPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setPhoneNumber(phoneNumber)
                    .setBirthDate(day, month, year)
                    .setSubjects(subject)
                    .setHobbies(hobbies)
                    .setCurrentAddress(address)
                    .setStateAndCity(state, city)
                    .setSubmit();
            if (!SystemProperties.browser().equals("firefox")) {
                registrationFormPage.setUploadPicture(picture);
            }
        });

        step("Check form results", () -> {
            checkTable.checkResultsTableVisible()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", phoneNumber)
                    .checkResult("Date of Birth", day + " " + month + "," + year)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobbies)
                    .checkResult("Address", address)
                    .checkResult("State and City", state + " " + city);
            if (!SystemProperties.browser().equals("firefox")) {
                checkTable.setUploadPicture(picture);
            }
        });
    }
}
