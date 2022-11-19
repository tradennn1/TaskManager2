package com.tradennn1.taskmanager2.ui.onBoarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tradennn1.taskmanager2.databinding.ItemOnBoardingBinding
import com.tradennn1.taskmanager2.ui.home.adapter.model.OnBoard

class OnBoardingAdapter : Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val arrayList = arrayListOf<OnBoard>(
        OnBoard("https://e7.pngegg.com/pngimages/250/100/png-clipart-linux-linux.png", "title", "description"),
        OnBoard("https://cdn-icons-png.flaticon.com/512/2/2235.png", "title", "description"),
        OnBoard("https://icones.pro/wp-content/uploads/2021/06/logo-windows-bleu.png", "title", "description")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int = arrayList.size

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.btnStart.isVisible = adapterPosition == arrayList.lastIndex
            binding.skip.isVisible = adapterPosition != arrayList.lastIndex
            binding.tvTitle.text = onBoard.title
            binding.tvDesc.text = onBoard.desc
        }
    }
}