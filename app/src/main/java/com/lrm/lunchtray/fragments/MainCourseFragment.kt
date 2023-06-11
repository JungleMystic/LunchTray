package com.lrm.lunchtray.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.lrm.lunchtray.R
import com.lrm.lunchtray.databinding.FragmentMainCourseBinding
import com.lrm.lunchtray.model.OrderViewModel

class MainCourseFragment : Fragment() {

    private var _binding: FragmentMainCourseBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainCourseBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.sharedViewModel = sharedViewModel

        binding.backIcon.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.cancelButton.setOnClickListener {
            sharedViewModel.resetOrder()
            findNavController().navigate(R.id.action_mainCourseFragment_to_startFragment)
        }

        binding.nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainCourseFragment_to_sideDishFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}