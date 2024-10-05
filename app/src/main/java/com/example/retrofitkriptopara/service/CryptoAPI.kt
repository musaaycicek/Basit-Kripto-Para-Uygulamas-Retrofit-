package com.example.retrofitkriptopara.service

import com.example.retrofitkriptopara.model.CryptoModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET


// URl nin diğer tarafını ana baz kısmı view da; diğer içerik kısmını interface get,post,update,delete içlerine yazıyoruz.
//https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json

//https://api.nomics.com/v1/ prices?key=2187154b76945f2373394aa34f7dc98a

interface CryptoAPI {

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getData():Observable<List<CryptoModel>>

  //  fun getData(): Call<List<CryptoModel>>





}