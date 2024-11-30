package com.example.paktai

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paktai.adapter.MenuAdapter
import com.example.paktai.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment : BottomSheetDialogFragment(){
    private lateinit var binding:FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)

        binding.buttonBack.setOnClickListener{
            dismiss()
        }
        val menuCountryName = listOf("ระนอง","กระบี่","สุราษฎร์ธานี","พังงา","สตูล","ชุมพร","ตรัง","นครศรีธรรมราช","ปัตตานี","พัทลุง","ภูเก็ต","ยะลา","สงขลา","นราธิวาส")
        val menuImage = listOf(
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
        val adapter = MenuAdapter(
            ArrayList(menuCountryName),
            ArrayList(menuImage)
        )
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}