package com.weirdideas.csivitapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface VitRestApi {

    @FormUrlEncoded
    @POST("/api/v2/{campus}/login")
    Call<LoginData> loginUser (@Path("campus") String campus,@Field("regno") String reg_number, @Field("mobile") String mobile, @Field("dob") String date_of_birth);

    @FormUrlEncoded
    @POST("/api/v2/{campus}/refresh")
    Call<VitData> updateUser (@Path("campus") String campus, @Field("regno") String reg_number, @Field("mobile") String mobile, @Field("dob") String date_of_birth);
}
