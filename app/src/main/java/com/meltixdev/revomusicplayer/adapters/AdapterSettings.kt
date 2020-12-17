package com.meltixdev.revomusicplayer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meltixdev.revomusicplayer.R
import com.meltixdev.revomusicplayer.databinding.ItemSettingsBinding
import com.meltixdev.revomusicplayer.dataclasses.DataItemSettings

class AdapterSettings(
        var settingsList: List<DataItemSettings>,
        var listener: OnItemClickListener
) : RecyclerView.Adapter<AdapterSettings.SettingsViewHolder>() {

    private lateinit var binding: ItemSettingsBinding

    inner class SettingsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position : Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.OnItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_settings, parent, false)
        return SettingsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return settingsList.size
    }

    override fun onBindViewHolder(holder: SettingsViewHolder, position: Int) {
        binding = ItemSettingsBinding.bind(binding.root)

        holder.itemView.apply {
            binding.rvTitle.text = settingsList[position].stringTitle
            binding.rvDescription.text = settingsList[position].stringDescription
            binding.rvIcon.setImageResource(settingsList[position].itemIcon)
        }
    }

    interface OnItemClickListener {
        fun OnItemClick(position: Int)
    }
}
