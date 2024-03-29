package com.breezydr.reminders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.breezydr.reminders.databinding.FragmentGeneralInfoBinding
import com.breezydr.reminders.databinding.FragmentPasswordsBinding

class GeneralInfoFragment: Fragment() {
    private lateinit var binding: FragmentGeneralInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGeneralInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}