package com.dlong.rep.dlpopwindow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dlong.rep.dlpopwindow.databinding.PopItemBinding

/**
 * 列表适配器
 * @author  dlong
 * created at 2019/3/14 1:45 PM
 */
class PopAdapter constructor(
        var mList: MutableList<DLPopItem> = mutableListOf(),
        var mListener: DLPopupWindow.OnItemClickListener
) : RecyclerView.Adapter<PopAdapter.ViewHolder>() {

    fun update(list: MutableList<DLPopItem>) {
        this.mList = list
        notifyDataSetChanged()
    }

    inner class ViewHolder constructor(
            val binding: PopItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(info: DLPopItem) {
            binding.popItem = info
            binding.iconColor = info.iconColorValue
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: PopItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.pop_item, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = this.mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val info = this.mList[position]
        holder.bind(info)

        holder.binding.clItem.setOnClickListener {
            mListener.onClick(position, info)
        }
    }
}