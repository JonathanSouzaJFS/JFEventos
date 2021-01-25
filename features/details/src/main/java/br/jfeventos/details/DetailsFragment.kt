package br.jfeventos.details

import android.content.Context
import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.jfeventos.common.R
import br.jfeventos.common.utils.*
import br.jfeventos.details.databinding.FragmentDetailsBinding
import br.jfeventos.domain.model.CheckIn
import br.jfeventos.domain.model.Event
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {

    private val viewModel by viewModel<DetailsViewModel>()
    private lateinit var mBinding: FragmentDetailsBinding
    private var idEvent: Long? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        idEvent = arguments?.getLong("id")

        if (idEvent == null) {
            showDialogError(requireContext(), resources.getString(R.string.event_indefined))
            findNavController().popBackStack()
            return
        }
        viewModel.getEventDetail(requireActivity(), idEvent ?: 1L)
        setupEventDetailObserver()

        mBinding.eventCheckIn.bind(idEvent = idEvent ?: 1L, onCheckInSelected = { checkin ->
            viewModel.sendEventCheckIn(requireContext(), checkin)
            setupCheckInObserver(checkin)
        })
    }

    private fun setupEventDetailObserver() {

        viewModel.loading.observe(requireActivity(), { loading ->
            if (loading) {
                mBinding.progressBar.visibility = View.VISIBLE
            } else {
                mBinding.progressBar.visibility = View.GONE
            }
        })

        viewModel.getEventDetail(requireContext(), idEvent ?: 1L).observe(requireActivity(), {
            it?.let { resource ->
                when (resource) {
                    is NetworkResponse.Success -> {
                        retrieveEvent(resource.data)
                    }
                    is NetworkResponse.Error -> {
                        showDialogError(requireContext(), resource.exception)
                        findNavController().popBackStack()
                    }
                    is NetworkResponse.NetworkError -> {
                        showNetworkError(requireContext()) {
                            viewModel.getEventDetail(requireActivity(), idEvent ?: 1L)
                        }
                    }
                }
            }
        })
    }

    private fun setupCheckInObserver(checkin: CheckIn) {
        viewModel.sendEventCheckIn(requireContext(), checkin).observe(requireActivity(), {
            it?.let { resource ->
                when (resource) {
                    is NetworkResponse.Success -> {
                        showDialogSucess(requireContext(), resources.getString(R.string.checkin_label_sucess))
                    }
                    is NetworkResponse.Error -> {
                        showDialogError(requireContext(), resource.exception)
                    }
                    is NetworkResponse.NetworkError -> {
                        showNetworkError(requireContext()) {
                            viewModel.sendEventCheckIn(requireContext(), checkin)
                        }
                    }
                }
            }
        })
    }

    private fun setLocationEvent(context: Context, long: String, lat: String) = try {
        val geocoder = Geocoder(context, getBrazilianLocation())
        val addresses = geocoder.getFromLocation(lat.toDouble(), long.toDouble(), 1)
        mBinding.eventLocaleView.bind(addresses[0].subAdminArea, addresses[0].adminArea)
        mBinding.eventInfoLocale.text = addresses[0].getAddressLine(0)
    } catch (ex: Exception) {
        mBinding.eventInfoLocale.text = resources.getString(R.string.indefined)
    }

    private fun retrieveEvent(event: Event) {
        mBinding.eventDateView.bind(event.date)
        mBinding.eventHourView.bind(event.date)
        BidingUtils.loadImageView(mBinding.ownerPhoto, event.image)
        setLocationEvent(requireContext(), event.longitude, event.latitude)
        mBinding.eventDescription.text = event.description
    }
}