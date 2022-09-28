package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {

    @Test
    void checkLocaleRus() {

        LocalizationService localizationService = new LocalizationServiceImpl();
        String actual = localizationService.locale(Country.RUSSIA);
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void checkLocaleUs() {

        LocalizationService localizationService = new LocalizationServiceImpl();
        String actual = localizationService.locale(Country.USA);
        String expected = "Welcome";
        Assertions.assertEquals(expected, actual);

    }

}