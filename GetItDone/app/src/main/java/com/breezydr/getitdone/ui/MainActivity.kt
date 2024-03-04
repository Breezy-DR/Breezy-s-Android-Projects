package com.breezydr.getitdone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.breezydr.getitdone.databinding.ActivityMainBinding
import com.breezydr.getitdone.databinding.DialogAddTasksBinding
import com.breezydr.getitdone.ui.tasks.TasksFragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayoutMediator
import data.GetItDoneDatabase
import data.Task
import data.TaskDao
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: GetItDoneDatabase
    private val tasksFragment: TasksFragment = TasksFragment()
    private val taskDao: TaskDao by lazy { database.getTaskDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pager.adapter = PagerAdapter(this)
        TabLayoutMediator(binding.tabs, binding.pager) {tab, position ->
            tab.text = "Tasks"
        }.attach()

        binding.fab.setOnClickListener {

            showAddTaskDialog()
        }

        database = GetItDoneDatabase.getDatabase(this)





    }

    private fun showAddTaskDialog() {
        val dialogBinding = DialogAddTasksBinding.inflate(layoutInflater)

        // Use BottomSheetDialog

        val dialog = BottomSheetDialog(this)

        dialog.setContentView(dialogBinding.root)

        dialogBinding.buttonShowDetails.setOnClickListener {
            if (dialogBinding.editTextTaskDetails.visibility == View.VISIBLE) {
                dialogBinding.editTextTaskDetails.visibility = View.GONE
            } else {
                dialogBinding.editTextTaskDetails.visibility = View.VISIBLE
            }
        }
        dialogBinding.buttonSave.setOnClickListener {
            val task = Task(
                title = dialogBinding.editTextTaskTitle.text.toString(),
                description = dialogBinding.editTextTaskDetails.text.toString()
            )
            thread {
                taskDao.createTask(task)
            }
            dialog.dismiss()
            tasksFragment.fetchAllTasks()
        }
        dialog.show()
    }

    inner class PagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount() = 1

        override fun createFragment(position: Int): Fragment {
            return tasksFragment
        }

    }
}