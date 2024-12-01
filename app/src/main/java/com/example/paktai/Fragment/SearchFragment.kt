package com.example.paktai.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paktai.R
import com.example.paktai.adapter.MenuAdapter
import com.example.paktai.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter : MenuAdapter
    private val originalMenuCountry = listOf("ระนอง","ระนอง","ระนอง","ระนอง","ระนอง","ระนอง","ระนอง","ระนอง",)
    private val originalMenuCountryName = listOf("วัดวารีบรรพต","ทุ่งโปรงทอง","เกาะเสม็ด","เกาะทะลุ","น้ำตกหงาว","เกาะพยาม","น้ำตกปุญญบาล","บ่อน้ำร้อนรักษะวาริน")
    private val originalMenuGuideName = listOf("สมชาย อินทราพร","สุดา วัฒนานนท์","ภูมิ ศรีสวัสดิ์","อมรรัตน์ รัตนากร","นาวา ชัยภักดี","จิราภรณ์ มณีรัตน","ธนพล จันทร์ศรี","ลัดดา สุวรรณา")
    private val originalMenuItemPrice = listOf("10,000 บาท","10,000 บาท","10,000 บาท","10,000 บาท","10,000 บาท","10,000 บาท","10,000 บาท","10,000 บาท")
    private val originalMenuImage = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6,
        R.drawable.menu7,
        R.drawable.menu8)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private val filterMenuCountry = mutableListOf<String>()
    private val filterMenuCountryName = mutableListOf<String>()
    private val filterMenuGuideName = mutableListOf<String>()
    private val filterMenuItemPrice = mutableListOf<String>()
    private val filterMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filterMenuCountry,filterMenuCountryName,filterMenuGuideName,filterMenuItemPrice,filterMenuImage)
        binding.SearchMenuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.SearchMenuRecyclerView.adapter = adapter

        setupSearchView()
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filterMenuCountry.clear()
        filterMenuGuideName.clear()
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
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
        TODO("Not yet implemented")
    }

    private fun filterMenuItems(query: String) {
        filterMenuCountry.clear()
        filterMenuGuideName.clear()
        filterMenuGuideName.clear()
        filterMenuItemPrice.clear()
        filterMenuImage.clear()

        originalMenuCountry.forEachIndexed { index, countryName ->
            if (countryName.contains(query,ignoreCase = true)){
                filterMenuCountry.add(originalMenuCountry[index])
                filterMenuCountryName.add(countryName)
                filterMenuGuideName.add(originalMenuGuideName[index])
                filterMenuItemPrice.add(originalMenuItemPrice[index])
                filterMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}

private fun android.widget.SearchView.setOnQueryTextListener(onQueryTextListener: SearchView.OnQueryTextListener) {
    TODO("Not yet implemented")
}
