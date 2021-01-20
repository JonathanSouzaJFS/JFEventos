package com.example.jfeventos.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.jfeventos.databinding.FragmentHomeBinding
import com.example.jfeventos.model.Event
import com.example.jfeventos.utils.NetworkResponse
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    private val viewModel by viewModel<HomeViewModel>()
    private lateinit var mBinding: FragmentHomeBinding
    private lateinit var adapter: EventAdapter
    private var loading = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()
        setupRecyclerViewAdapter()
        viewModel.getEvents(requireActivity())
        setupObservers()
        mBinding.swipeRefresh.setOnRefreshListener(this)
        setHasOptionsMenu(true)
    }

    private fun setupRecyclerView() {
        mBinding.recyclerViewEvents.layoutManager = LinearLayoutManager(requireContext())
        mBinding.recyclerViewEvents.setHasFixedSize(true)
    }

    private fun setupRecyclerViewAdapter() {
        adapter = EventAdapter(requireContext(), arrayListOf()) {

        }
        mBinding.recyclerViewEvents.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getEvents(requireContext()).observe(requireActivity(), Observer {
            it?.let { resource ->
                when (resource) {
                    is NetworkResponse.Success -> {
                        mBinding.progressBar.visibility = View.GONE
                        retrieveList(resource.data)
                        loading = false
                        mBinding.swipeRefresh.isRefreshing = false
                    }
                    is NetworkResponse.Error -> {
                        mBinding.progressBar.visibility = View.GONE
                        Toast.makeText(requireContext(), resource.exception, Toast.LENGTH_LONG)
                            .show()
                        loading = false
                        mBinding.swipeRefresh.isRefreshing = false
                    }
                    is NetworkResponse.Loading -> {
                        mBinding.progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    private fun retrieveList(events: List<Event>) {
        adapter.apply {
            addEvent(events)
            notifyDataSetChanged()
        }
    }

    override fun onRefresh() {
        adapter.clearItems()
        viewModel.getEvents(requireActivity())
        setupObservers()
    }
}