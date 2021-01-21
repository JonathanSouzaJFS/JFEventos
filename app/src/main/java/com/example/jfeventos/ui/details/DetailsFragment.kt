package com.example.jfeventos.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.jfeventos.databinding.FragmentDetailsBinding
import com.example.jfeventos.model.Event
import com.example.jfeventos.utils.BidingUtils
import com.example.jfeventos.utils.NetworkResponse
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    private val viewModel by viewModel<DetailsViewModel>()
    private lateinit var mBinding: FragmentDetailsBinding
    private var loading = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getEventDetail(requireActivity(), arguments?.getLong("id") ?: 1L)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.getEventDetail(requireContext(), arguments?.getLong("id") ?: 1L)
            .observe(requireActivity(), {
                it?.let { resource ->
                    when (resource) {
                        is NetworkResponse.Success -> {
                            mBinding.progressBar.visibility = View.GONE
                            retrieveList(resource.data)
                            loading = false
                            //mBinding.swipeRefresh.isRefreshing = false
                        }
                        is NetworkResponse.Error -> {
                            mBinding.progressBar.visibility = View.GONE
                            Toast.makeText(requireContext(), resource.exception, Toast.LENGTH_LONG)
                                .show()
                            loading = false
                            //    mBinding.swipeRefresh.isRefreshing = false
                        }
                        is NetworkResponse.Loading -> {
                            mBinding.progressBar.visibility = View.VISIBLE
                        }
                    }
                }
            })
    }

    private fun retrieveList(event: Event) {
        mBinding.eventDateView.bind(event.date)
        mBinding.eventHourView.bind(event.date)
        BidingUtils.loadImageView(mBinding.ownerPhoto, event.image)
        mBinding.eventLocaleView.bind("Manaus", "Amazonas")
        mBinding.eventDescription.text = event.description
        mBinding.eventInfoLocale.text = event.latitude
    }

    override fun onRefresh() {
        TODO("Not yet implemented")
    }
}