package com.example.banklineandroid.ui.statement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banklineandroid.databinding.ActivityExtratoBinding
import com.example.banklineandroid.ui.data.remote.Estado
import com.example.banklineandroid.ui.domain.Correntista
import com.google.android.material.snackbar.Snackbar

class ExtratoActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_CORRENTISTA_ID ="com.example.banklineandroid.ui.statement.EXTRA_CORRENTISTA_ID"
    }

    private  val correntistaId by  lazy {
        intent.getParcelableExtra<Correntista>(EXTRA_CORRENTISTA_ID)
            ?: throw IllegalArgumentException();
    }
    private  val bidding by lazy {
        ActivityExtratoBinding.inflate(layoutInflater)
    }

    private  val viewModel by viewModels<BanklineViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bidding.root)

       bidding.idRcyView.layoutManager = LinearLayoutManager(this)
        findItensRicView();
    }
    private fun findItensRicView(){
        viewModel.findBanklineExtrato(correntistaId).observe(this) {estado ->
                when(estado){
                    is Estado.Sucesso ->{
                        bidding.idRcyView.adapter = estado.data?.let { ExtratoAdapter(it) }
                        bidding.idSwipeRefresh.isRefreshing = false
                    }
                    is Estado.Erro ->{
                       estado.mensagem?.let { Snackbar.make(
                           bidding.idRcyView, it, Snackbar.LENGTH_LONG).show()
                       }

                         bidding.idSwipeRefresh.isRefreshing =false
                    }
                        Estado.Wait -> bidding.idSwipeRefresh.isRefreshing =true
                }

        }
    }
}