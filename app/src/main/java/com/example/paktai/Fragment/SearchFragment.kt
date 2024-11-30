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
    private  lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val originalmenuCountryName = listOf("วัดวารีบรรพต","ทุ่งโปรงทอง","เกาะเสม็ด","เกาะทะลุ","น้ำตกหงาว","เกาะพยาม","น้ำตกปุญญบาล","บ่อน้ำร้อนรักษะวาริน")
    private val originalmenuImage = listOf(
        R.drawable.ranong,
        R.drawable.krabi,
        R.drawable.surat_thani,
        R.drawable.phang_nga,
        R.drawable.satun,
        R.drawable.chumphon,
        R.drawable.trang,
        R.drawable.nakhon_si_thammarat,
        R.drawable.pattani,
        R.drawable.phatthalung,
        R.drawable.phuket,
        R.drawable.yala,
        R.drawable.songkhla,
        R.drawable.narathiwat
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filterMenuCountryName = mutableListOf<String>()
    private val filterMenuCountryImage = mutableListOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filterMenuCountryName,filterMenuCountryImage)
        binding.SearchMenuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.SearchMenuRecyclerView.adapter = adapter

        setupSearchView()
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filterMenuCountryName.clear()
        filterMenuCountryImage.clear()

        filterMenuCountryName.addAll(originalmenuCountryName)
        filterMenuCountryImage.addAll(originalmenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuCountryName(newText)
                return true
            }

            private fun filterMenuCountryName(newText: String) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun filterMenuItems(query: String?) {

        originalmenuImage.forEachIndexed{index, countryName ->
            if(countryName.contains(query,ignoreCase = true)){
                filterMenuCountryName.add(originalmenuCountryName[index])
                filterMenuCountryImage.add(originalmenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}

private fun android.widget.SearchView.setOnQueryTextListener(onQueryTextListener: SearchView.OnQueryTextListener) {
}

private fun Int.contains(query: String?, ignoreCase: Boolean): Boolean {
    TODO("Not yet implemented")
}
