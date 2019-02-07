package com.burtwileysnyder;

import com.burtwileysnyder.api.FyydApi;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.Request;

public class FyydApiClient implements PodcastInterface {

    private static final String TAG = FyydApiClient.class.getSimpleName();
    public static final String FYYD_API_URL = "https://api.fyyd.de/0.2/";
    public static final String SEARCH_PODCAST_PATH = "search/podcast";

    OkHttpClient httpClient;

    public FyydApiClient(OkHttpClient client) {
        httpClient = client;
        init();
    }

    public FyydApiClient() {
        httpClient = new OkHttpClient();
        init();
    }

    private void init(){
        //quick test
        try {
            String response = this.searchPodcasts("news", "1");
            FyydApi fyyd = new Gson().fromJson(response, FyydApi.class);
            System.out.println(fyyd.getData().get(0).getTitle());

        }catch(IOException e){
            e.printStackTrace();
        }
    }


    @Override
    public String searchPodcasts(String title, String limit) throws IOException {

        //String url = FYYD_API_URL + SEARCH_PODCAST_PATH + "?title=" + title + "&limit=" + limit;
        String url = FYYD_API_URL + SEARCH_PODCAST_PATH + "?title=" + title + "&count=" + limit;

        System.out.println(url);
        String result = "";

        try {
            Request request = new Request.Builder().url(url).build();
            Response response = null;
            try {
                response = httpClient.newCall(request).execute();
                result = response.body().string();
            } finally {
                if (response != null) {
                    response.close();
                }
            }
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

    public static void main(String[] args) throws IOException {
        FyydApiClient fyyd2 = new FyydApiClient();
    }
}
