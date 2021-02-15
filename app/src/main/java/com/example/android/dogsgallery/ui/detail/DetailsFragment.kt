package com.example.android.dogsgallery.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.android.dogsgallery.databinding.FragmentDetailsBinding
import com.squareup.picasso.Picasso


class DetailsFragment : Fragment() {
    private var _binding:FragmentDetailsBinding?=null
    private val binding get() = _binding!!
    private val args:DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       Picasso.get()
           .load(args.pictureUrl)
           .fit()
           .centerCrop()
           .into(binding.ivDog)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}