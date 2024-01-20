package com.example.testlocation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testlocation.OnGovernorateSelectedListener
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.testlocation.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class HomeFragment : Fragment(), OnGovernorateSelectedListener {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var bottomSheetDialog: BottomSheetDialog
    private lateinit var bottomSheetFragment: BottomSheetFragment

    val receivedSelectedItemText:HomeFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        binding.textViewInHomeFragment.text=receivedSelectedItemText.selectedItem
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvGovernorate.setOnClickListener {
            showbottomsheet()
        }
    }

    @SuppressLint("InflateParams")
    private fun showbottomsheet() {
        val dialogview = layoutInflater.inflate(R.layout.fragment_bottom_sheet, null)
        bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.setOnGovernorateSelectedListener(this)
        bottomSheetDialog.setContentView(dialogview)
        findNavController().navigate(R.id.action_homeFragment_to_bottom_sheetFragment)
        bottomSheetDialog.show()
    }

    override fun onGovernorateSelected(governorate: String) {
        binding.textViewInHomeFragment.text = governorate
        bottomSheetDialog.dismiss()

    }
}