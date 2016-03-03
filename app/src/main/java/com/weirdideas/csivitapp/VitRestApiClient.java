package com.weirdideas.csivitapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by welcome on 3/2/2016.
 */
public class VitRestApiClient {
    private static VitRestApiClient ourInstance = new VitRestApiClient();

    Retrofit retrofit;

    public static VitRestApiClient getInstance() {
        return ourInstance;
    }

    private VitRestApi mApi;

    private VitRestApiClient() {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://vitacademics-rel.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mApi = retrofit.create(VitRestApi.class);
    }

    public VitRestApi getApi() {
        return mApi;
    }

    public void setApi(VitRestApi mApi) {
        this.mApi = mApi;
    }
}
