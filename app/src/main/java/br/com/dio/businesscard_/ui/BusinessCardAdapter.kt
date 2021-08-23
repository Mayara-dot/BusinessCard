package br.com.dio.businesscard_.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.dio.businesscard_.data.BusinessCard
import br.com.dio.businesscard_.databinding.ItemBusinessCardBinding

class BusinessCardAdapter : ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallBack()) {

    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind (item: BusinessCard) {
            binding.TVNome.text = item.nome
            binding.TVTelefone.text = item.telefone
            binding.TVEmail.text = item.email
            binding.TVEmpresa.text = item.empresa
            binding.MCVContent.setBackgroundColor(Color.parseColor(item.backgroundCardColor))
            binding.MCVContent.setOnClickListener {
                listenerShare(it)
            }
        }
    }
}


class DiffCallBack: DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem == newItem
    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem.id == newItem.id
}
//diff extensão que gerencia diferenças na lista