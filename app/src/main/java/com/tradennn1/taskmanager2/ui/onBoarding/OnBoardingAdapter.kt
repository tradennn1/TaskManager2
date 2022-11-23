package com.tradennn1.taskmanager2.ui.onBoarding

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.tradennn1.taskmanager2.databinding.ItemOnBoardingBinding
import com.tradennn1.taskmanager2.ui.home.adapter.model.OnBoard

class OnBoardingAdapter(val navController: NavController, context: Context) : Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val arrayList = arrayListOf<OnBoard>(
        OnBoard("https://img.gazeta.ru/files3/957/10301957/00-pic905-895x505-58873.jpg", "Italy", "Rome"),
        OnBoard("https://7daytravel.ru/wp-content/uploads/2019/02/7daytravel-england-02.jpg", "Great Britain", "London"),
        OnBoard("https://topvoyager.com/wp-content/uploads/2021/01/most-famous-attractions-1-1.jpg", "France", "Paris")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder   {
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

    override fun getItemCount(): Int = 3

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.btnStart.isVisible = adapterPosition == arrayList.lastIndex
            binding.tvTitle.text = onBoard.title
            binding.tvDesc.text = onBoard.desc
            Glide.with(binding.ivImage).load(onBoard.image).into(binding.ivImage)

            binding.btnStart.setOnClickListener {

                navController.navigateUp()
            }

        }
    }
}