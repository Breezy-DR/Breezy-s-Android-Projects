package com.breezydr.getitdone.ui.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.breezydr.getitdone.databinding.FragmentTasksBinding
import data.GetItDoneDatabase
import data.Task
import data.TaskDao
import kotlin.concurrent.thread

class TasksFragment: Fragment(), TasksAdapter.TaskUpdatedListener {
    private lateinit var binding: FragmentTasksBinding
    private val taskDao: TaskDao by lazy {
        GetItDoneDatabase.getDatabase(requireContext()).getTaskDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchAllTasks()

    }

    fun fetchAllTasks() {
        thread {
            val tasks = taskDao.getAllTasks()
            requireActivity().runOnUiThread {
                binding.recyclerView.adapter = TasksAdapter(
                    tasks = tasks,
                    listener = this
                )
            }
        }
    }

    override fun onTaskUpdated(task: Task) {
        thread {
            taskDao.updateTask(task)
        }
    }
}