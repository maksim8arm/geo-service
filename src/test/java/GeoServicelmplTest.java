import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import sun.jvm.hotspot.types.JBooleanField;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeoServicelmplTest {

    @Test
    void testIpNull() {

        GeoService geoService = new GeoServiceImpl();
        Location actual = geoService.byIp("111");
        Location expected = null;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIpLocal() {

        GeoService geoService = new GeoServiceImpl();
        Location actual = geoService.byIp("127.0.0.1");
        Location expected = new Location(null, null, null, 0);
        Assertions.assertEquals(expected.getCountry(), actual.getCountry());

    }

}


