package com.utsman.binarchallengefive.landingpage.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.utsman.binarchallengefive.MainActivity
import com.utsman.binarchallengefive.databinding.FragmentLandingPageThreeBinding
import com.utsman.binarchallengefive.intentTo
import com.utsman.binarchallengefive.load
import com.utsman.binarchallengefive.vscom.VscomActivity

class LandingPageThreeFragment : Fragment() {

    private var _binding: FragmentLandingPageThreeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLandingPageThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backgroundUrl = "https://images.unsplash.com/photo-1535223289827-42f1e9919769?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80"
        binding.imgBg.load(backgroundUrl)

        binding.btnStart.setOnClickListener {
            val name = binding.etName.text.toString()
            context?.intentTo(VscomActivity::class.java) { intent ->
                intent.putExtra("name", name)
            }
        }
    }
}