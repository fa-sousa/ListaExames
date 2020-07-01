package com.fsconsultoria.desafiofleury.service;

import com.fsconsultoria.desafiofleury.model.ListExames;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetApi {

    @GET ("results")
    Call<List<ListExames>> getAllResults(@Path("name") String name);

}
