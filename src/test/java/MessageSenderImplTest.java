import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTest {

    @Test
    void test_RuSend() {

        GeoService geoService = Mockito.mock(ru.netology.geo.GeoService.class);
        Mockito.when(geoService.byIp(Mockito.anyString()))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationService localizationService = Mockito.mock(ru.netology.i18n.LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSenderImpl messageSenderImpl = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.163.34.69");

        String expected = "Добро пожаловать";
        String actual = messageSenderImpl.send(headers);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test_EngSend() {

        GeoService geoService = Mockito.mock(ru.netology.geo.GeoService.class);
        Mockito.when(geoService.byIp(Mockito.anyString()))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        LocalizationService localizationService = Mockito.mock(ru.netology.i18n.LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSenderImpl messageSenderImpl = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.163.34.69");

        String expected = "Welcome";
        String actual = messageSenderImpl.send(headers);
        Assertions.assertEquals(expected, actual);
    }
}
