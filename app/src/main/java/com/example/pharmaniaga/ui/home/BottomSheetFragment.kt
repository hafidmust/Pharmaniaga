package com.example.pharmaniaga.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmaniaga.R
import com.example.pharmaniaga.model.Categorys
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var rvCategory : RecyclerView
    private lateinit var dataCategory : ArrayList<Categorys>

    private val list : ArrayList<Categorys> = arrayListOf(
        Categorys(size = "12 oz", description = "Special meal", price = "$25,999"),
        Categorys(size = "12 oz", description = "Special meal", price = "$25,999"),
        Categorys(size = "Custom", description = "Request by customer", price = ""),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCategory = view.findViewById(R.id.rv_category)
        rvCategory.setHasFixedSize(true)
        dataCategory = ArrayList()
        dataCategory.addAll(list)

        showRecyclerCategory()

    }

    private fun showRecyclerCategory() {
        rvCategory.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        val listCategoryAdapter = ListCategoryProductAdapter(dataCategory)
        rvCategory.adapter = listCategoryAdapter
    }

    companion object {
        const val TAG = "BottomSheetFragment"
    }
}