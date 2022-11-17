package com.tradennn1.taskmanager2.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tradennn1.taskmanager2.databinding.ItemTaskBinding
import com.tradennn1.taskmanager2.ui.home.adapter.model.Task

class TaskAdapter() :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private val task: ArrayList<Task> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {

        holder.bind(task[position])
    }

    override fun getItemCount(): Int {
        return task.size

    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {

        }
    }

}
