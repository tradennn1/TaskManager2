package com.tradennn1.taskmanager2.ui.onBoarding

import android.R
import android.net.http.SslCertificate.saveState
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.tradennn1.taskmanager2.Prefs
import com.tradennn1.taskmanager2.databinding.FragmentOnBoardingBinding
import me.relex.circleindicator.CircleIndicator3


class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnBoardingAdapter(findNavController(),requireContext())
        binding.viewPager.adapter = adapter
        binding.skip.setOnClickListener {
            Prefs(requireContext()).saveState()
            findNavController().navigateUp()
        }
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        val indicator : CircleIndicator3? = activity?.findViewById<CircleIndicator3>(binding.indicator.id)
        indicator?.setViewPager(binding.viewPager)

    }

}