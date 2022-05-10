package com.example.banklineandroid.ui.domain

data class Movimentacao(
    val idMovimentacao: Int,
    val  dataHora :String,
    val descricao:String,
    val tipoMovimentacao :TipoMovimentacao,
    val valor :Double,
      //TODO idConta-> IdCorrentista
    val idCorrentista: Int
)
