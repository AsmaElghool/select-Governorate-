package com.example.testlocation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testlocation.adapter.AdapterGovernorate
import com.example.testlocation.OnGovernorateSelectedListener
import com.example.testlocation.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentBottomSheetBinding
    private lateinit var adapter: AdapterGovernorate
    private var selectedItem: String? = null

    private var governorateSelectedListener: OnGovernorateSelectedListener? = null
    private var dataList: List<String> = mutableListOf()
    val governoratesList = listOf(
        "القاهرة ",
        "الوادي الجديد",
        "المنيا",
        "المنوفية",
        "مطروح",
        "كفر الشيخ",
        "قنا",
        "القليوبية",
        "الفيوم",
        "الغربية",
        "شمال سيناء",
        "الشرقية",
        "السويس",
        "سوهاج",
        "دمياط",
        "الدقهلية",
        "الجيزة",
        "جنوب سيناء",
        "بورسعيد",
        "بني سويف",
        "البحيرة",
        "البحر الأحمر"
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AdapterGovernorate(governoratesList) { selectedGovernorate ->
            selectedItem = selectedGovernorate
//            governorateSelectedListener?.onGovernorateSelected(selectedGovernorate)
            val action = BottomSheetFragmentDirections.actionBottomSheetFragmentToHomeFragment(selectedItem)
            findNavController().navigate(action)
        }
        dataList = governoratesList
        binding.recyclerViewGovernorate.adapter = adapter
        binding.recyclerViewGovernorate.layoutManager = LinearLayoutManager(context)
        setUpSearchView()
    }

    private fun setUpSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText)
                return true
            }
        })
    }

    private fun filter(query: String?) {
        val filteredList = mutableListOf<String>()

        if (!query.isNullOrBlank()) {
            for (item in governoratesList) {
                if (item.contains(query, ignoreCase = true)) {
                    filteredList.add(item)
                }
            }
        } else {
            filteredList.addAll(governoratesList)
        }
        adapter.updateData(filteredList)
    }

    fun setOnGovernorateSelectedListener(listener: OnGovernorateSelectedListener) {
        governorateSelectedListener = listener
    }

    fun getItemSelected(): String? {
        return selectedItem
    }

}