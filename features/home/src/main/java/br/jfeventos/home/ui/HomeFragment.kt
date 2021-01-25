package br.jfeventos.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import br.jfeventos.common.utils.NetworkResponse
import br.jfeventos.common.utils.showDialogError
import br.jfeventos.common.utils.showNetworkError
import br.jfeventos.domain.model.Event
import br.jfeventos.home.EventAdapter
import br.jfeventos.home.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    private val viewModel by viewModel<HomeViewModel>()
    private lateinit var mBinding: FragmentHomeBinding
    private lateinit var adapter: EventAdapter

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
    }

    private fun setupRecyclerView() {
        mBinding.recyclerViewEvents.layoutManager = LinearLayoutManager(requireContext())
        mBinding.recyclerViewEvents.setHasFixedSize(true)
    }

    private fun setupRecyclerViewAdapter() {
        adapter = EventAdapter(requireContext(), arrayListOf()) {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(it.id)
            requireView().findNavController().navigate(action)
        }
        mBinding.recyclerViewEvents.adapter = adapter
    }

    private fun setupObservers() {

        viewModel.loading.observe(requireActivity(), { loading ->
            if (loading) {
                mBinding.progressBar.visibility = View.VISIBLE
            } else {
                mBinding.progressBar.visibility = View.GONE
                mBinding.swipeRefresh.isRefreshing = false
            }
        })

        viewModel.getEvents(requireContext()).observe(requireActivity(), {
            it?.let { resource ->
                when (resource) {
                    is NetworkResponse.Success -> {
                        retrieveList(resource.data)
                    }
                    is NetworkResponse.Error -> {
                        showDialogError(requireContext(), resource.exception)
                    }
                    is NetworkResponse.NetworkError -> {
                        showNetworkError(requireContext()) {
                            viewModel.getEvents(requireActivity())
                        }
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