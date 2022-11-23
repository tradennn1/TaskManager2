package com.tradennn1.taskmanager2.ui.task

//import App
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.tradennn1.taskmanager2.App
import com.tradennn1.taskmanager2.R
import com.tradennn1.taskmanager2.databinding.FragmentTaskBinding
import com.tradennn1.taskmanager2.databinding.ItemTaskBinding
import com.tradennn1.taskmanager2.ui.home.adapter.model.Task

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            if (binding.edTitle.text.toString().isNotEmpty()) {
                saveTask()
            } else {
                binding.edTitle.error = getString(R.string.error_titile)
            }
        }
    }

    private fun saveTask() {
        val data = Task(
            title = binding.edTitle.text.toString(),
            desc = binding.edDesc.text.toString()
        )
        App.db.taskDao().insert(data)
        findNavController().navigateUp()
    }
}