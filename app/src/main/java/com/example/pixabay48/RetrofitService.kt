package com.example.pixabay48

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
   companion object{
       var retrofit = Retrofit.Builder().baseUrl("https://pixabay.com/")
         .addConverterFactory(GsonConverterFactory.create()).build()

      var api = retrofit.create(PixaApi::class.java)

   }


}