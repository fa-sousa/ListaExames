package com.fsconsultoria.desafiofleury.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://5bfbefa5cf9d29001345c529.mockapi.io/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    GetApi service = retrofit.create(GetApi.class);

}
