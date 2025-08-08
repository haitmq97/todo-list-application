package com.example.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.model.Task

class TaskAdapter (
    private val task: List<Task>,
    private val listener: OnTaskListener
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    interface OnTaskListener {
        fun onTaskClick(position: Int)
        fun onTaskLongClick(position: Int)
    }

    /*
    item_task.xml → ItemTaskBinding
    */
    inner class TaskViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickLstener {
                listener.onTaskClick(adapterPosition)
            }
            binding.root.setOnTaskLongClick{
                listener.onTaskLongClick(adapterPosition)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context))
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.binding.textTitle.text = task.title
        holder.binding.textStatus.text = if (task.isDone) "✓ Hoàn thành" else "Chưa hoàn thành"
    }

    override fun getItemCount() = tasks.size

}