package com.example.banklineandroid.ui.statement

import androidx.lifecycle.ViewModel
import com.example.banklineandroid.ui.data.remote.BanklineRepositoy
import com.example.banklineandroid.ui.domain.Correntista

class BanklineViewModel:ViewModel() {

  fun findBanklineExtrato (contaId: Correntista) =
      BanklineRepositoy.findBankExtrato(contaId)
}