package edu.festu.yulia.ponomarchuk.retrofitsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.festu.yulia.ponomarchuk.retrofitsample.databinding.ItemBinding
import edu.festu.yulia.ponomarchuk.retrofitsample.network.InfoModel

class RVAdapter : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    private var list: MutableList<InfoModel> = mutableListOf()

    fun setList(list: MutableList<InfoModel>) {
        this.list = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = list[position].title
        holder.description.text = list[position].description
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(binding: ItemBinding):RecyclerView.ViewHolder(binding.root){
        val title = binding.titleField
        val description = binding.descriptionField
    }
}