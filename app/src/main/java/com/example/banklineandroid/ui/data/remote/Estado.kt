package com.example.banklineandroid.ui.data.remote

sealed class Estado<out T>{
    data class Sucesso <out R> (val  data :R? =null): Estado<R?>()
    data class Erro (val mensagem : String? = null) :Estado<Nothing>()
    object Wait : Estado<Nothing>()
}