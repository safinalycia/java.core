package DZ6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class Weather {
    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5days")
                .addPathSegment("289888_PC")
                .addQueryParameter("apikey", "ZwJQZQE9GadGoSBig7V8ZDuMrF9wK07L")
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        System.out.println(url.toString());

        Request requestHttp = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        String jsonResponse = client.newCall(requestHttp).execute().body().string();
        System.out.println(jsonResponse);


    }


    }

