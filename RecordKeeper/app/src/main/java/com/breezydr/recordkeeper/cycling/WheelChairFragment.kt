package com.breezydr.recordkeeper.cycling

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.breezydr.recordkeeper.databinding.FragmentWheelchairBinding
import com.breezydr.recordkeeper.editrecord.EditRecordActivity
import com.breezydr.recordkeeper.editrecord.INTENT_EXTRA_SCREEN_DATA

class WheelChairFragment : Fragment() {

    private lateinit var binding: FragmentWheelchairBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWheelchairBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    override fun onResume() {
        super.onResume()
        displayRecords()
    }

    private fun displayRecords() {
        val cyclingPreferences = requireContext().getSharedPreferences(FILENAME, Context.MODE_PRIVATE)

        binding.textViewLongestRideValue.text = cyclingPreferences.getString("Longest Ride record", null)
        binding.textViewLongestRideDate.text = cyclingPreferences.getString("Longest Ride date", null)
        binding.textViewBiggestClimbValue.text = cyclingPreferences.getString("Biggest Climb record", null)
        binding.textViewBiggestClimbDate.text = cyclingPreferences.getString("Biggest Climb date", null)
        binding.textViewBestSpeedValue.text = cyclingPreferences.getString("Best Average Speed record", null)
        binding.textViewBestSpeedDate.text = cyclingPreferences.getString("Best Average Speed date", null)

    }

    private fun setupClickListeners() {
        binding.containerLongestRide.setOnClickListener { launchEditCyclingRecordScreen("Longest Ride", "Distance") }
        binding.containerBiggestClimb.setOnClickListener { launchEditCyclingRecordScreen("Biggest Climb", "Height") }
        binding.containerBestSpeed.setOnClickListener { launchEditCyclingRecordScreen("Best Average Speed", "Average Speed") }

    }

    private fun launchEditCyclingRecordScreen(record: String, recordFieldHint: String) {
        val intent = Intent(context, EditRecordActivity::class.java)
        intent.putExtra(INTENT_EXTRA_SCREEN_DATA, EditRecordActivity.ScreenData(record, FILENAME, recordFieldHint))
        startActivity(intent)
    }

    companion object {
        const val FILENAME = "cycling"
    }

}
