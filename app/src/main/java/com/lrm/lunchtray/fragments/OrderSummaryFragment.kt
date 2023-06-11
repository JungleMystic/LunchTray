package com.lrm.lunchtray.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.lrm.lunchtray.R
import com.lrm.lunchtray.databinding.FragmentOrderSummaryBinding
import com.lrm.lunchtray.model.OrderViewModel

class OrderSummaryFragment : Fragment() {

    private var _binding: FragmentOrderSummaryBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderSummaryBinding.inflate(inflater, container, false)

        sharedViewModel.calculateTaxAndTotal()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.sharedViewModel = sharedViewModel

        binding.backIcon.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.cancelOrder.setOnClickListener {
            sharedViewModel.resetOrder()
            findNavController().navigate(R.id.action_orderSummaryFragment_to_startFragment)
        }

        binding.submitOrder.setOnClickListener {
            sharedViewModel.resetOrder()
            Snackbar.make(binding.root, "Order Submitted!",Snackbar.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_orderSummaryFragment_to_startFragment)
        }
    }

}