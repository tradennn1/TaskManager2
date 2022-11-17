package com.tradennn1.taskmanager2.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tradennn1.taskmanager2.R
import com.tradennn1.taskmanager2.databinding.FragmentTaskBinding
import com.tradennn1.taskmanager2.databinding.ItemTaskBinding

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }
}