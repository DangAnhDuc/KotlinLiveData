package com.example.kotlinlivedata.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinlivedata.MedalViewModel
import com.example.kotlinlivedata.R
import kotlinx.android.synthetic.main.fragment_summary.*

class SummaryFragment : Fragment() {

    lateinit var medalViewModel: MedalViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var root =  inflater.inflate(R.layout.fragment_summary, container, false)

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
        var totalMedal: Int = medalViewModel?.numberOfGoldMedal?.value!!.plus(medalViewModel?.numberOfSilverMedal?.value!!).plus(medalViewModel?.numberOfBronzeMedal?.value!!)
        tvNumberOfMedal.text = activity?.getString(R.string.number_of_medal_label, totalMedal)
    }
}