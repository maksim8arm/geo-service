package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;


class GeoServiceImplTest {

    @Test
    void checkByIpLocationRus() {

        GeoService geoService = new GeoServiceImpl();
        Location actual = geoService.byIp("172.");
        Location expected = new Location("Moscow", Country.RUSSIA, null, 0);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void checkByIpLocationUs() {

        GeoService geoService = new GeoServiceImpl();
        Location actual = geoService.byIp("96.");
        Location expected = new Location("New York", Country.USA, null, 0);
        Assertions.assertEquals(expected, actual);

    }


    @Test
    void byIpByNull() {

        GeoService geoService = new GeoServiceImpl();
        Location actual = geoService.byIp("111");
        Location expected = null;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void byIpByLocal() {

        GeoService geoService = new GeoServiceImpl();
        Location actual = geoService.byIp("127.0.0.1");
        Location expected = new Location(null, null, null, 0);
        Assertions.assertEquals(expected.getCountry(), actual.getCountry());

    }

}