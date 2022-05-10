package com.example.banklineandroid.ui.statement



import android.database.DataSetObservable
import android.service.autofill.Dataset
import android.util.ArraySet
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.banklineandroid.R
import com.example.banklineandroid.databinding.ActivityExtratoItemBinding
import com.example.banklineandroid.ui.domain.Movimentacao
import com.example.banklineandroid.ui.domain.TipoMovimentacao

class ExtratoAdapter (private val  dataSet:List<Movimentacao>) :
        RecyclerView.Adapter<ExtratoAdapter.ViewHolder>() {

    class ViewHolder(private val  binding: ActivityExtratoItemBinding)
        :RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Movimentacao) = with(binding) {
            idTxvDescricao.text = item.descricao
            idTxvValor.text = item.valor.toString()
            idTxvData.text = item.dataHora
            val tipoMov = if (TipoMovimentacao.Receitas == item.tipoMovimentacao)
                R.drawable.ic_receita else R.drawable.ic_despesa
            idImgView.setImageResource(tipoMov);

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityExtratoItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)
    }

    override fun getItemCount()= dataSet.size

}