package com.tradennn1.taskmanager2.ui.Profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.tradennn1.taskmanager2.Prefs
import com.tradennn1.taskmanager2.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private lateinit var prefOnBoarding:Prefs


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefOnBoarding = Prefs(requireContext())
        initLauncher()
        initListener()
        saveAge()
    }

    private fun saveAge() {
        binding.tvName.setText(prefOnBoarding.getAge())
        binding.tvName.addTextChangedListener{
            prefOnBoarding.saveAges(binding.tvName.text.toString())
        }
        binding.tvAge.setText(prefOnBoarding.getAge())
        binding.tvAge.addTextChangedListener{
            prefOnBoarding.saveAges(binding.tvAge.text.toString())
        }


    }


private fun initListener() {
    binding.profileImage.setOnClickListener {
        val intent = Intent()
        intent.action = Intent.ACTION_PICK
        intent.type = "image/*"
        launcher.launch(intent)
    }
}

private fun initLauncher() {
    launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == AppCompatActivity.RESULT_OK) {
            val image = it.data?.data
            if (image != null) {
                binding.profileImage.setImageURI(image)
                prefOnBoarding.saveImage(image.toString())
            }
        }
    }
    Glide.with(binding.profileImage).load(prefOnBoarding.getImage()).into(binding.profileImage)
}
}