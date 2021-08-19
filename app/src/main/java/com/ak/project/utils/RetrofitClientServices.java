package com.ak.project.utils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Mayank on 13,August,2021
 */
public class RetrofitClientServices {

    private static Retrofit retrofit;
   // public static final String BASE_URL = "http://10.0.2.2/akshay/";
    public static final String BASE_URL = "http://10.0.2.2/akshay/";
    private static final String ROOT_URL = "http://10.0.2.2/akshay/Api.php?apicall=";
    public static final String URL_REGISTER = ROOT_URL + "signup";
    public static final String URL_LOGIN = ROOT_URL + "login";


    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public interface Api  {

        @FormUrlEncoded
        @POST("booking.php")
        Call<ResponseBody> booking(
                @Field("type") String type,
                @Field("date") String date
        );
    }
}