package com.example.todolist.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.todolist.databinding.DialogAddTaskBinding

class AddTaskDialogFragment(val onAdd: (String, String) -> Unit) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogAddTaskBinding.inflate(layoutInflater)

        return AlertDialog.Builder(requireContext())
            .setTitle("Thêm công việc mới")
            .setView(binding.root)
            .setPositiveButton("Thêm") { _, _ ->
                val title = binding.editTitle.text.toString()
                val desc = binding.editDescription.text.toString()
                onAdd(title, desc)
            }
            .setNegativeButton("Hủy", null)
            .create()
    }
}