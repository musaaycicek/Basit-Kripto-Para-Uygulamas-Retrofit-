package com.example.retrofitkriptopara.model

import com.google.gson.annotations.SerializedName

//  Eğer "val currency: String" gelen veri parametresi ile aynı olursa  @SerializedName("currency") kullanmamıza gerek yok.

data class CryptoModel(
    // Gelen değerlerin parametre isimleri (Serial kısmı) aynı olmalı
   // @SerializedName("currency")
    val currency: String,
    //@SerializedName("price")
    val price: String) {




}