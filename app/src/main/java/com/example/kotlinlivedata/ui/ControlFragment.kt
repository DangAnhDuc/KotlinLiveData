package com.example.kotlinlivedata.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinlivedata.MedalViewModel

import com.example.kotlinlivedata.R
import kotlinx.android.synthetic.main.fragment_control.*

class ControlFragment : Fragment() , View.OnClickListener{
    lateinit var medalViewModel: MedalViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var root= inflater.inflate(R.layout.fragment_control, container, false)
        medalViewModel=ViewModelProviders.of(activity!!).get(MedalViewModel::class.java)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayMedal()

        btnGoldMinus.setOnClickListener(this)
        btnGoldPlus.setOnClickListener(this)
        btnSilverMinus.setOnClickListener(this)
        btnSilverPlus.setOnClickListener(this)
        btnBronzeMinus.setOnClickListener(this)
        btnBronzePlus.setOnClickListener(this)
    }
    fun displayMedal() {
        tvMainGoldNumber.text = medalViewModel?.numberOfGoldMedal?.value.toString()
        tvMainSilverNumber.text = medalViewModel?.numberOfSilverMedal.value.toString()
        tvMainBronzeNumber.text = medalViewModel?.numberOfBronzeMedal.value.toString()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            btnGoldMinus.id -> {
                medalViewModel?.numberOfGoldMedal.value = medalViewModel?.numberOfGoldMedal?.value?.minus(1)
                displayMedal()
            }
            btnGoldPlus.id -> {
                medalViewModel?.numberOfGoldMedal.value = medalViewModel?.numberOfGoldMedal?.value?.plus(1)
                displayMedal()
            }
            btnSilverMinus.id -> {
                medalViewModel?.numberOfSilverMedal.value = medalViewModel?.numberOfSilverMedal?.value?.minus(1)
                displayMedal()
            }
            btnSilverPlus.id -> {
                medalViewModel?.numberOfSilverMedal.value = medalViewModel?.numberOfSilverMedal?.value?.plus(1)
                displayMedal()
            }
            btnBronzeMinus.id -> {
                medalViewModel?.numberOfBronzeMedal.value = medalViewModel?.numberOfBronzeMedal?.value?.minus(1)
                displayMedal()
            }
            btnBronzePlus.id -> {
                medalViewModel?.numberOfBronzeMedal.value = medalViewModel?.numberOfBronzeMedal?.value?.plus(1)
                displayMedal()
            }
        }
    }
}