package com.example.fakenews.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fakenews.R
import com.example.fakenews.data.DataSource
import com.example.fakenews.databinding.Fragment1Binding
import com.example.fakenews.presentation.recycler.News
import com.example.fakenews.presentation.recycler.NewsAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class NewsFragment : Fragment(R.layout.fragment1) {

    val binding: Fragment1Binding by viewBinding()

    private val onChooseFilter: OnChooseFilter = object : OnChooseFilter {
        override fun chooseFilter(filter: List<News>, selectionInformation: String) {
            viewModel.loadMessages(filter)

            binding.textView.text = selectionInformation
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

        binding.list.adapter = adapter

        binding.imageView.setOnClickListener {
            radioGroupFragment.show(childFragmentManager, RadioGroupFragment.TAG)
        }

        viewModel.loadMessages(dataSource.list)
    }

    private fun initObserves() {
        viewModel.onFilterChoose.observe(viewLifecycleOwner) { messages ->
            adapter.submitList(messages)
            binding.list.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }
}