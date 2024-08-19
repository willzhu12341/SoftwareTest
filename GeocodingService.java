import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class GeocodingService {
    private static final String API_URL = "http://api.map.baidu.com/geocoder?address=%s&output=json&key=%s";
    private static final String API_KEY = "KXKl8X055KJTomFnjRWoF3CdOntl9y7V";

    public String getLatitude(String address) throws IOException {
        String encodedAddress = URLEncoder.encode(address, "UTF-8");
        URL resjson = new URL(String.format(API_URL, encodedAddress, API_KEY));

        try (BufferedReader in = new BufferedReader(new InputStreamReader(resjson.openStream()))) {
            StringBuilder sb = new StringBuilder();
            String res;
            while ((res = in.readLine()) != null) {
                sb.append(res.trim());
            }
            return sb.toString();
        }
    }
}