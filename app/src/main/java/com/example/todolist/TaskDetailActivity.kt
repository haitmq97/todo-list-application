package com.example.todolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.model.Task


class TaskDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaskDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val task = intent.getSerializableExtra("task") as? Task
        task?.let {
            binding.textTitle.setText(it.title)
            binding.textDescription.setText(it.description)
            binding.checkboxDone.isChecked = it.isDone

            binding.checkboxDone.setOnCheckedChangeListener { _, isChecked ->
                it.isDone = isChecked
            }
        }
    }
}