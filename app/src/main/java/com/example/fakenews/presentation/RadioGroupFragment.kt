package com.example.fakenews.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fakenews.R
import com.example.fakenews.databinding.Fragment2Binding
import com.example.fakenews.presentation.enums.AuthorEnum
import com.example.fakenews.presentation.enums.DateEnum
import com.example.fakenews.presentation.enums.TopicEnum
import com.example.fakenews.presentation.recycler.News
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.android.viewmodel.ext.android.viewModel

class RadioGroupFragment(
    private val passesList: PassesList
) : BottomSheetDialogFragment() {

    private val binding: Fragment2Binding by viewBinding()
    private val viewModel: NewsFragmentViewModel by viewModel()
    private var copyList: List<News> = listOf()

    companion object {
        const val TAG = "FirstFragment"

        fun newInstance2(passesList: PassesList) =
            RadioGroupFragment(passesList)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment2, container, false)

    override fun onResume() {
        super.onResume()
        initObserveList()
        initRadioGroup()

    }

    private fun initRadioGroup() {
        binding.apply {
            radioGroup.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.topicRadioButton -> {

                        dateRadioButton.isVisible = false
                        authorRadioButton.isVisible = false

                        radioGroup2.isVisible = true

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

                        dateRadioButton.isVisible = false
                        topicRadioButton.isVisible = false

                        radioGroup2.isVisible = true

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

                        authorRadioButton.isVisible = false
                        topicRadioButton.isVisible = false

                        radioGroup2.isVisible = true

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
    }

    private fun passFilterTopic(enumString: String) {
        passesList.displaysListOnScreen(
            copyList.filter { it.topic == enumString }, enumString
        )
        dismiss()
        binding.radioGroup.clearCheck()
    }

    private fun passFilterAuthor(enumString: String) {
        passesList.displaysListOnScreen(

            copyList.filter { it.author == enumString }, enumString
        )
        dismiss()
        binding.radioGroup.clearCheck()
    }

    private fun passFilterDate(enumString: String) {
        passesList.displaysListOnScreen(
            copyList.filter { it.date == enumString }, enumString
        )
        dismiss()
        binding.radioGroup.clearCheck()
    }

    private fun initObserveList() {
        viewModel.newsList()
        viewModel.newsList.observe(viewLifecycleOwner) { list ->
            copyList = list
        }
    }
}