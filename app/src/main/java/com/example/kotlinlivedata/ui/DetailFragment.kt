package com.example.kotlinlivedata.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinlivedata.MedalViewModel

import com.example.kotlinlivedata.R
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {
    lateinit var medalViewModel: MedalViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_detail, container, false)

        medalViewModel = ViewModelProviders.of(activity!!).get(MedalViewModel::class.java)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        medalViewModel.numberOfGoldMedal.observe(activity!!, Observer<Int> { displayMedal() })
        medalViewModel.numberOfSilverMedal.observe(activity!!, Observer<Int> { displayMedal() })
        medalViewModel.numberOfBronzeMedal.observe(activity!!, Observer<Int> { displayMedal() })
    }

    fun displayMedal() {
        tvDetailGoldNumber.text = activity?.getString(
            R.string.number_of_gold_label,
            medalViewModel?.numberOfGoldMedal?.value
        )
        tvDetailSilverNumber.text = activity?.getString(
            R.string.number_of_silver_label,
            medalViewModel?.numberOfSilverMedal?.value
        )
        tvDetailBronzeNumber.text = activity?.getString(
            R.string.number_of_bronze_label,
            medalViewModel?.numberOfBronzeMedal?.value
        )
    }

}