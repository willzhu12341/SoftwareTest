import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class GeocodingServiceTest {

    @Test
    public void testGetLatitude() throws IOException {
        GeocodingService apiTest = new GeocodingService();
        String address = "南京南京航空航天大学将军路校区";
        String result = apiTest.getLatitude(address);

        // 检查结果不为空
        assertNotNull(result);

        // 检查结果包含预期的关键字
        assertTrue(result.contains("status"));
        assertTrue(result.contains("result"));
        assertTrue(result.contains("location"));
        assertTrue(result.contains("lng"));
        assertTrue(result.contains("lat"));

        // 打印结果以便手动检查
        System.out.println("API Response: " + result);
    }
}