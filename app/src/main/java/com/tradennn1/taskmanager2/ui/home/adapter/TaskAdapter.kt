package com.tradennn1.taskmanager2.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tradennn1.taskmanager2.databinding.ItemTaskBinding
import com.tradennn1.taskmanager2.ui.home.adapter.model.Task

class TaskAdapter() :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private val tasks: ArrayList<Task> = arrayListOf()

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

        holder.bind(tasks[position])
    }

    fun addTask(task: Task) {
        tasks.add(0, task)
        notifyItemChanged(0)
    }

    fun addTasks(newTasks: List<Task>) {
        this.tasks.clear()
        this.tasks.addAll(newTasks)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return tasks.size

    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.tvTitle.text = task.title
            binding.tvDesc.text = task.desc
        }
    }

}
