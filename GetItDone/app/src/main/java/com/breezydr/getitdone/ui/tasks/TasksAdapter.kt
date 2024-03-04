package com.breezydr.getitdone.ui.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.breezydr.getitdone.databinding.ItemTaskBinding
import com.google.android.material.checkbox.MaterialCheckBox
import data.Task

class TasksAdapter(private val tasks: List<Task>, private val listener: TaskUpdatedListener): RecyclerView.Adapter<TasksAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemTaskBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    inner class ViewHolder(private val binding: ItemTaskBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.textViewTitle.text = task.title
            binding.textViewDetails.text = task.description
            binding.checkbox.addOnCheckedStateChangedListener { _, state ->
                val updatedTask = when (state) {
                    MaterialCheckBox.STATE_CHECKED -> {
                        task.copy(isComplete = true)
                    }
                    else -> {
                        task.copy(isComplete = false)

                    }
                }
                listener.onTaskUpdated(updatedTask)
            }

            binding.toggleStar.addOnCheckedStateChangedListener { _, state ->
                val updatedTask = when (state) {
                    MaterialCheckBox.STATE_CHECKED -> {
                        task.copy(isStarred = true)
                    }
                    else -> {
                        task.copy(isStarred = false)

                    }
                }
                listener.onTaskUpdated(updatedTask)
            }
        }
    }

    interface TaskUpdatedListener {
        fun onTaskUpdated(task: Task)
    }


}