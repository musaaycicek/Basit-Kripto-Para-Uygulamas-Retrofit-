package com.example.retrofitkriptopara.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitkriptopara.adapter.RecyclerViewAdapter
import com.example.retrofitkriptopara.databinding.ActivityMainBinding
import com.example.retrofitkriptopara.model.CryptoModel
import com.example.retrofitkriptopara.service.CryptoAPI
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


//GET, POST, UPDATE, DELETE

//https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json

//https://api.nomics.com/v1/ prices?key=2187154b76945f2373394aa34f7dc98a


// Baz kısmını burada tanımladık.
private val BASE_URL = "https://raw.githubusercontent.com/"

// List oluşturduk.
private var cryptoModels: ArrayList<CryptoModel>? = null

private lateinit var binding: ActivityMainBinding
// Disposable=kullan at
private var compositeDisposable:CompositeDisposable?=null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        compositeDisposable=CompositeDisposable()

        loadData()



    }

    private fun loadData() {

        // Retrofit objesi oluşturduk.

        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(CryptoAPI::class.java)

        compositeDisposable?.add(retrofit.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(this::handleResponse)

        )



    }


    fun handleResponse(cryptoList:List<CryptoModel>){


        cryptoModels=ArrayList(cryptoList)


        cryptoModels?.let {
            binding.recyclerview.adapter=RecyclerViewAdapter(it,this@MainActivity)
            binding.recyclerview.layoutManager= LinearLayoutManager(MainActivity())
        }



    }



}