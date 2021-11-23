package com.example.fakenews.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fakenews.R
import com.example.fakenews.data.DataOrientation
import com.example.fakenews.data.DataSource
import com.example.fakenews.domain.NewsInteractor
import com.example.fakenews.presentation.recycler.News
import com.example.fakenews.presentation.recycler.NewsAdapter
import kotlinx.android.synthetic.main.fragment1.*
import org.koin.android.viewmodel.ext.android.viewModel

class Fragment() : Fragment(),NewsInteractor{



    private val onChooseFilter: OnChooseFilter = object : OnChooseFilter {
        override fun chooseFilter(filter: List<News>) {
            Log.e("my","*****onChoose********\n$filter")
            loadMessages(filter)

        }
    }

    override fun loadMessages(filter: List<News>) {
        viewModel.loadMessages(filter)
    }

    companion object {
        fun newInstance() =
            com.example.fakenews.presentation.Fragment()
        const val TAG = "TAG"
    }

    private val adapter by lazy { NewsAdapter() }
    private val dataSource by lazy { DataSource() }
    private val viewModel: FragmentViewModel by viewModel()

   override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.fragment1, container, false
    )

    override fun onResume() {
        super.onResume()

        initObserves()


        list.adapter = adapter

        onChooseFilter.chooseFilter(dataSource.list)



    }

    private fun initObserves() {
        viewModel.onFilterChoose.observe(viewLifecycleOwner) { messages ->
            adapter.submitList(messages)

        }

        viewModel.listOrientation.observe(viewLifecycleOwner) { orientation ->
            list.layoutManager = LinearLayoutManager(requireContext(), orientation, false)
        }
    }





    private val orientation: DataOrientation = DataOrientation.VERTICAL

    override fun loadOrientation(): Int {
        return when (orientation) {
            DataOrientation.HORIZONTAL -> LinearLayout.HORIZONTAL
            else -> LinearLayout.VERTICAL
        }
    }



}