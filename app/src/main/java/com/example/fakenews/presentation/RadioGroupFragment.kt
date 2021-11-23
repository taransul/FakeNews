package com.example.fakenews.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.fakenews.R
import com.example.fakenews.data.DataOrientation
import com.example.fakenews.data.DataSource
import com.example.fakenews.domain.NewsInteractor
import com.example.fakenews.presentation.recycler.News
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment1.*
import kotlinx.android.synthetic.main.fragment2.*
import org.koin.android.viewmodel.ext.android.viewModel
import kotlin.concurrent.fixedRateTimer

class RadioGroupFragment(private val onChooseFilter: OnChooseFilter) : BottomSheetDialogFragment() {

    private val dataSource by lazy { DataSource() }

    companion object {
        const val TAG = "FirstFragment"

        fun newInstance2(onChooseFilter: OnChooseFilter) = RadioGroupFragment(onChooseFilter)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment2, container, false)

    override fun onStart() {
        super.onStart()

        radioGroup.setOnCheckedChangeListener { _, checkedId ->

            when (checkedId) {
                R.id.dateRadioButton -> {

                    onChooseFilter.chooseFilter(dataSource.list.filter { it.topic == TopicEnum.Game.topic })
                    dismiss()

                }
                R.id.topicRadioButton -> {

                    onChooseFilter.chooseFilter(dataSource.list.filter { it.topic == TopicEnum.Technologies.topic })
                    dismiss()

                }
                R.id.authorRadioButton -> {

                    onChooseFilter.chooseFilter(dataSource.list.filter { it.topic == TopicEnum.Economy.topic })
                    dismiss()
                }
            }
        }
    }
}
