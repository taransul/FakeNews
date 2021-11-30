package com.example.fakenews.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fakenews.R
import com.example.fakenews.databinding.Fragment1Binding
import com.example.fakenews.presentation.recycler.News
import com.example.fakenews.presentation.recycler.NewsAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class NewsFragment : Fragment(R.layout.fragment1) {

    private val adapter by lazy { NewsAdapter() }
    private val viewModel by viewModel<NewsFragmentViewModel>()

    val binding: Fragment1Binding by viewBinding(Fragment1Binding::bind)

    private val transmittingFilteredList: TransmittingFilteredList =
        object : TransmittingFilteredList {
            override fun passesFilteredList(filter: List<News>, selectionInformation: String) {
                viewModel.loadMessages(filter)
                binding.textView.text = selectionInformation
            }
        }
    private val radioGroupFragment = RadioGroupFragment.newInstance2(transmittingFilteredList)

    companion object {
        fun newInstance() = NewsFragment()
        const val TAG = "TAG"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObserves(viewModel.transmittingFilteredList)
        initObserves(viewModel.newsList)
        viewModel.newsList()
        binding.list.adapter = adapter
        binding.imageView.setOnClickListener {
            radioGroupFragment.show(childFragmentManager, RadioGroupFragment.TAG)
        }
    }

    private fun initObserves(observeLiveData: LiveData<List<News>>) {
        observeLiveData.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
            binding.list.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }
}