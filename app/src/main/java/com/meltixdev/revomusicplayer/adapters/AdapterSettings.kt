package com.meltixdev.revomusicplayer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meltixdev.revomusicplayer.databinding.ItemSettingsBinding
import com.meltixdev.revomusicplayer.dataclasses.DataItemsSettings
import com.meltixdev.revomusicplayer.settings.ActivitySettings

class AdapterSettings(
        var settingsList: List<DataItemSettings>,
        var listener: OnItemClickListener
) : RecyclerView.Adapter<AdapterSettings.SettingsViewHolder>() {

    inner class SettingsViewHolder(private val binding: ItemSettingsBinding): RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position : Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.OnItemClick(position)
            }
        }

        fun bind(item: DataItemSettings) {
            binding.rvTitle.text = settingsList[position].stringTitle
            binding.rvDescription.text = settingsList[position].stringDescription
            binding.rvIcon.setImageResource(settingsList[position].itemIcon)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsViewHolder {
        val binding = ItemSettingsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SettingsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SettingsViewHolder, position: Int) {
        holder.bind(settingsList[position])
    }

    override fun getItemCount(): Int {
        return settingsList.size
    }

    override fun onBindViewHolder(holder: SettingsViewHolder, position: Int) {
        holder.bind(settingsList[position])
    }

    interface OnItemClickListener {
        fun OnItemClick(position: Int)
    }
}
