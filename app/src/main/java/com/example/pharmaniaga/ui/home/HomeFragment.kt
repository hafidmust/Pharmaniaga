package com.example.pharmaniaga.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmaniaga.ListProductAdapter
import com.example.pharmaniaga.R
import com.example.pharmaniaga.databinding.FragmentHomeBinding
import com.example.pharmaniaga.model.Product

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var rvProducts : RecyclerView
    private lateinit var imgCart : ImageView
    private val list = ArrayList<Product>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvProducts = binding.rvProducts
        rvProducts.setHasFixedSize(true)

        list.addAll(listProducts)
        showRecyclerList()
    }
    private val listProducts : ArrayList<Product>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPrice = resources.getStringArray(R.array.data_price)
            val dataPhoto = resources.obtainTypedArray(R.array.data_image)
            val listProduct = ArrayList<Product>()

            for (i in dataName.indices){
                val product = Product(dataName[i], dataDescription[i],dataPrice[i],dataPhoto.getResourceId(i, -1))
                listProduct.add(product)
            }

            return listProduct

        }

    private fun showRecyclerList(){
        rvProducts.layoutManager = GridLayoutManager(context,2)
        val listProductAdapter = ListProductAdapter(list)
        rvProducts.adapter = listProductAdapter

        listProductAdapter.setOnItemClickCallback(object : ListProductAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Product) {
                showSelectedProduct(data)
            }
        })
    }
    private fun showSelectedProduct(product: Product){
        val bottomSheet = BottomSheetFragment()
        bottomSheet.show(parentFragmentManager,BottomSheetFragment.TAG)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}