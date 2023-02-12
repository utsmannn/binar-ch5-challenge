package com.utsman.binarchallengefive.landingpage.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.utsman.binarchallengefive.databinding.FragmentLandingPageOneBinding
import com.utsman.binarchallengefive.load

class LandingPageOneFragment : Fragment() {

    private var _binding: FragmentLandingPageOneBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLandingPageOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backgroundUrl = "https://images.unsplash.com/photo-1613626318906-68be0aef3334?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=800&q=80"
        binding.imgBg.load(backgroundUrl)
    }
}