package com.example.banklineandroid.ui.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object BanklineRepositoy {
    private val TAG =javaClass.simpleName

   private val restApi by lazy {  Retrofit.Builder()
       .baseUrl("http://localhost:8080/")
       .addConverterFactory(GsonConverterFactory.create())
       .build()
       .create(BanklineApi::class.java)
   }
    fun findBankExtrato(contaId :Int ) = liveData {
         emit(Estado.Wait)
        try {
                emit(Estado.Sucesso(data = restApi.findBankExtrato(contaId )))
        }catch ( e:Exception){
           Log.e(TAG,e.message,e)
           emit(Estado.Erro(e.message))
         }
    }
}