package com.example.android.dogsgallery.ui.overview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.dogsgallery.R
import com.example.android.dogsgallery.data.Result
import com.example.android.dogsgallery.databinding.FragmentOverViewBinding


class OverViewFragment : Fragment() {

    private var _binding: FragmentOverViewBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DogsViewModel by viewModels()
    lateinit var adapter: DogsAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = FragmentOverViewBinding.inflate(inflater, container, false)
        val view = binding.root
        val dogsObserver = Observer<Result>{
            when(it) {
                is Result.Success -> {
                    adapter.dogsList = it.list
                    adapter.notifyDataSetChanged()
                }
                is Result.Failure -> Toast.makeText(requireContext(),
                        "Something went wrong",
                        Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.getListLiveData().observe(viewLifecycleOwner,dogsObserver)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter= DogsAdapter(requireContext())
        val recyclerView = binding.recyclerView
        recyclerView.adapter= adapter
        recyclerView.layoutManager= GridLayoutManager(requireContext(),2)
        recyclerView.setHasFixedSize(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}