/**
 * Создал Андрей Антонов 17.08.2023 12:16
 **/
package http.com;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpExample {

    private static final String APYKEY = "feSbo2gUicXaHd2tIZa1gIqyVqUSbsyh";
    private static final String BASE_URL = "http://dataservice.accuweather.com";


    public static void main(final String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        int cityCount = 50;

        Request request = new Request.Builder()
                .url(BASE_URL + "/currentconditions/v1/topcities/" + cityCount + "?apikey=" + APYKEY)
                .build();

        System.out.println("Sending rq... " + request);

        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println("Receive rq... " + response);

            String responseString = response.body().string();
            System.out.println("Receive rq... " + responseString);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
