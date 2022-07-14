package com.example.pharmaniaga.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pharmaniaga.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetCartFragment : BottomSheetDialogFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet_cart, container, false)
    }

    companion object {
        const val TAG = "BottomSheetCartFragment"
    }
}