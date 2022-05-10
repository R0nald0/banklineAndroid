package com.example.banklineandroid.ui.data.remote

import com.example.banklineandroid.ui.domain.Movimentacao
import retrofit2.http.GET
import retrofit2.http.Path


interface BanklineApi {

    @GET("movimentacpe/{id}")
     suspend fun findBankExtrato(@Path("id") idConta :Int) : List<Movimentacao>
}