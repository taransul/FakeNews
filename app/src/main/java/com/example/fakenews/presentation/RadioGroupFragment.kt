package com.example.fakenews.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fakenews.R
import com.example.fakenews.data.DataSource
import com.example.fakenews.presentation.enums.AuthorEnum
import com.example.fakenews.presentation.enums.DateEnum
import com.example.fakenews.presentation.enums.TopicEnum
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment2.*

class RadioGroupFragment(
    private val onChooseFilter: OnChooseFilter
) : BottomSheetDialogFragment() {

    private val dataSource by lazy { DataSource() }

    companion object {
        const val TAG = "FirstFragment"

        fun newInstance2(onChooseFilter: OnChooseFilter) =
            RadioGroupFragment(onChooseFilter)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment2, container, false)

    override fun onResume() {
        super.onResume()
        initRadioGroup()
    }

    private fun initRadioGroup() {

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.topicRadioButton -> {

                    dateRadioButton.visibility = View.GONE
                    authorRadioButton.visibility = View.GONE

                    radioGroup2.visibility = View.VISIBLE

                    radioButton1.text = TopicEnum.GAME.topic
                    radioButton2.text = TopicEnum.ECONOMY.topic
                    radioButton3.text = TopicEnum.TECHNOLOGIES.topic
                    radioButton4.text = TopicEnum.POLITICS.topic

                    radioGroup2.setOnCheckedChangeListener { _, checkedId2 ->
                        when (checkedId2) {
                            R.id.radioButton1 -> {
                                passFilterTopic(TopicEnum.GAME.topic)
                            }
                            R.id.radioButton2 -> {
                                passFilterTopic(TopicEnum.ECONOMY.topic)
                            }
                            R.id.radioButton3 -> {
                                passFilterTopic(TopicEnum.TECHNOLOGIES.topic)
                            }
                            R.id.radioButton4 -> {
                                passFilterTopic(TopicEnum.POLITICS.topic)
                            }
                        }
                    }
                }

                R.id.authorRadioButton -> {

                    dateRadioButton.visibility = View.GONE
                    topicRadioButton.visibility = View.GONE

                    radioGroup2.visibility = View.VISIBLE

                    radioButton1.text = AuthorEnum.AUTHOR1.author
                    radioButton2.text = AuthorEnum.AUTHOR2.author
                    radioButton3.text = AuthorEnum.AUTHOR3.author
                    radioButton4.text = AuthorEnum.AUTHOR4.author

                    radioGroup2.setOnCheckedChangeListener { _, checkedId2 ->
                        when (checkedId2) {
                            R.id.radioButton1 -> {
                                passFilterAuthor(AuthorEnum.AUTHOR1.author)
                            }
                            R.id.radioButton2 -> {
                                passFilterAuthor(AuthorEnum.AUTHOR2.author)
                            }
                            R.id.radioButton3 -> {
                                passFilterAuthor(AuthorEnum.AUTHOR3.author)
                            }
                            R.id.radioButton4 -> {
                                passFilterAuthor(AuthorEnum.AUTHOR4.author)
                            }
                        }
                    }
                }

                R.id.dateRadioButton -> {

                    authorRadioButton.visibility = View.GONE
                    topicRadioButton.visibility = View.GONE

                    radioGroup2.visibility = View.VISIBLE

                    radioButton1.text = DateEnum.TODAY.date
                    radioButton2.text = DateEnum.RECENTLY.date
                    radioButton3.text = DateEnum.WEEK.date
                    radioButton4.text = DateEnum.OLD.date

                    radioGroup2.setOnCheckedChangeListener { _, checkedId2 ->
                        when (checkedId2) {
                            R.id.radioButton1 -> {
                                passFilterDate(DateEnum.TODAY.date)
                            }
                            R.id.radioButton2 -> {
                                passFilterDate(DateEnum.RECENTLY.date)
                            }
                            R.id.radioButton3 -> {
                                passFilterDate(DateEnum.WEEK.date)
                            }
                            R.id.radioButton4 -> {
                                passFilterDate(DateEnum.OLD.date)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun passFilterTopic(enumString: String) {
        onChooseFilter.chooseFilter(
            dataSource.list.filter { it.topic == enumString }, enumString
        )
        dismiss()
        radioGroup.clearCheck()
    }

    private fun passFilterAuthor(enumString: String) {
        onChooseFilter.chooseFilter(
            dataSource.list.filter { it.author == enumString }, enumString
        )
        dismiss()
        radioGroup.clearCheck()
    }

    private fun passFilterDate(enumString: String) {
        onChooseFilter.chooseFilter(
            dataSource.list.filter { it.date == enumString }, enumString
        )
        dismiss()
        radioGroup.clearCheck()
    }
}