package com.example.paktai.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paktai.R
import com.example.paktai.adapter.MenuAdapter
import com.example.paktai.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter

    private val originalMenuCountry = listOf("ระนอง", "ระนอง", "ระนอง", "ระนอง", "ระนอง", "ระนอง", "ระนอง", "ระนอง")
    private val originalMenuCountryName = listOf("วัดวารีบรรพต", "ทุ่งโปรงทอง", "เกาะเสม็ด", "เกาะทะลุ", "น้ำตกหงาว", "เกาะพยาม", "น้ำตกปุญญบาล", "บ่อน้ำร้อนรักษะวาริน")
    private val originalMenuGuideName = listOf("สมชาย อินทราพร", "สุดา วัฒนานนท์", "ภูมิ ศรีสวัสดิ์", "อมรรัตน์ รัตนากร", "นาวา ชัยภักดี", "จิราภรณ์ มณีรัตน", "ธนพล จันทร์ศรี", "ลัดดา สุวรรณา")
    private val originalMenuItemPrice = listOf("10,000 บาท", "10,000 บาท", "10,000 บาท", "10,000 บาท", "10,000 บาท", "10,000 บาท", "10,000 บาท", "10,000 บาท")
    private val originalMenuImage = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6,
        R.drawable.menu7,
        R.drawable.menu8
    )

    private val filterMenuCountry = mutableListOf<String>()
    private val filterMenuCountryName = mutableListOf<String>()
    private val filterMenuGuideName = mutableListOf<String>()
    private val filterMenuItemPrice = mutableListOf<String>()
    private val filterMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        adapter = MenuAdapter(filterMenuCountry, filterMenuCountryName, filterMenuGuideName, filterMenuItemPrice, filterMenuImage)

        binding.SearchMenuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.SearchMenuRecyclerView.adapter = adapter

        setupSearchView()
        setupSpinner()
        showAllMenu()
        return binding.root
    }

    private fun setupSpinner() {
        val provinces = listOf(
            "--จังหวัด--", "ระนอง", "กระบี่", "สุราษฎร์ธานี", "พังงา", "สตูล",
            "ชุมพร", "ตรัง", "นครศรีธรรมราช", "ปัตตานี", "พัทลุง",
            "ภูเก็ต", "ยะลา", "สงขลา", "นราธิวาส"
        )

        val spinnerAdapter = ArrayAdapter(requireContext(), R.layout.spinner_dropdown_item, provinces)

        spinnerAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item) // ใช้ layout ที่กำหนดเองสำหรับ dropdown
        binding.categoryFilter.adapter = spinnerAdapter

        binding.categoryFilter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedProvince = parent?.getItemAtPosition(position).toString()
                if (selectedProvince == "--จังหวัด--") {
                    showAllMenu()
                } else {
                    filterMenuByProvince(selectedProvince)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun showAllMenu() {
        filterMenuCountry.clear()
        filterMenuCountryName.clear()
        filterMenuGuideName.clear()
        filterMenuItemPrice.clear()
        filterMenuImage.clear()

        filterMenuCountry.addAll(originalMenuCountry)
        filterMenuCountryName.addAll(originalMenuCountryName)
        filterMenuGuideName.addAll(originalMenuGuideName)
        filterMenuItemPrice.addAll(originalMenuItemPrice)
        filterMenuImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }
    private fun filterMenuByProvince(selectedProvince: String) {
        filterMenuCountry.clear()
        filterMenuCountryName.clear()
        filterMenuGuideName.clear()
        filterMenuItemPrice.clear()
        filterMenuImage.clear()

        // กรองข้อมูลตามจังหวัดที่เลือก
        originalMenuCountry.forEachIndexed { index, country ->
            if (country == selectedProvince) {
                filterMenuCountry.add(originalMenuCountry[index])
                filterMenuCountryName.add(originalMenuCountryName[index])
                filterMenuGuideName.add(originalMenuGuideName[index])
                filterMenuItemPrice.add(originalMenuItemPrice[index])
                filterMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    private fun filterMenuItems(query: String) {
        filterMenuCountry.clear()
        filterMenuCountryName.clear()
        filterMenuGuideName.clear()
        filterMenuItemPrice.clear()
        filterMenuImage.clear()

        originalMenuCountryName.forEachIndexed { index, country ->
            if (country.contains(query, ignoreCase = true)) {
                filterMenuCountry.add(originalMenuCountry[index])
                filterMenuCountryName.add(originalMenuCountryName[index])
                filterMenuGuideName.add(originalMenuGuideName[index])
                filterMenuItemPrice.add(originalMenuItemPrice[index])
                filterMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }
}