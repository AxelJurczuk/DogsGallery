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
import com.example.android.dogsgallery.R
import com.example.android.dogsgallery.data.Result


class OverViewFragment : Fragment() {

    private val viewModel: DogsViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val dogsObserver = Observer<Result>{
            when(it) {
                is Result.Success -> {
                    Log.i("dogsList", it.list.toString())
                    Toast.makeText(requireContext(), "fragment working", Toast.LENGTH_SHORT).show()
                }
                is Result.Failure -> Toast.makeText(requireContext(),
                        "Something went wrong",
                        Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.getListLiveData().observe(viewLifecycleOwner,dogsObserver)

        return inflater.inflate(R.layout.fragment_over_view, container, false)
    }

}