package com.lrm.lunchtray.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.lrm.lunchtray.R
import com.lrm.lunchtray.databinding.FragmentSnacksBinding
import com.lrm.lunchtray.model.OrderViewModel

class SnacksFragment : Fragment() {

    private var _binding: FragmentSnacksBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSnacksBinding.inflate(inflater, container, false)

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
            findNavController().navigate(R.id.action_snacksFragment_to_startFragment)
        }

        binding.nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_snacksFragment_to_orderSummaryFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}