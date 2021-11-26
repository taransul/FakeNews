package com.example.fakenews.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fakenews.R
import com.example.fakenews.data.DataSource
import com.example.fakenews.presentation.recycler.News
import com.example.fakenews.presentation.recycler.NewsAdapter
import kotlinx.android.synthetic.main.fragment1.*
import org.koin.android.viewmodel.ext.android.viewModel

class NewsFragment : Fragment() {

    private val onChooseFilter: OnChooseFilter = object : OnChooseFilter {
        override fun chooseFilter(filter: List<News>, selectionInformation: String) {
            viewModel.loadMessages(filter)

            textView.text = selectionInformation
        }
    }

    private val radioGroupFragment = RadioGroupFragment.newInstance2(onChooseFilter)

    companion object {
        fun newInstance() = NewsFragment()

        const val TAG = "TAG"
    }

    private val adapter by lazy { NewsAdapter() }
    private val dataSource by lazy { DataSource() }

    private val viewModel: NewsFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.fragment1, container, false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObserves()

        list.adapter = adapter

        imageView.setOnClickListener {
            radioGroupFragment.show(childFragmentManager, RadioGroupFragment.TAG)
        }

        viewModel.loadMessages(dataSource.list)
    }

    private fun initObserves() {
        viewModel.onFilterChoose.observe(viewLifecycleOwner) { messages ->
            adapter.submitList(messages)
            list.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }
}