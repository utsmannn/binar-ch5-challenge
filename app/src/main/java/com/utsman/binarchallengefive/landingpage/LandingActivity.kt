package com.utsman.binarchallengefive.landingpage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.viewpager.widget.ViewPager
import com.utsman.binarchallengefive.MainActivity
import com.utsman.binarchallengefive.databinding.ActivityLandingBinding
import com.utsman.binarchallengefive.intentTo
import com.utsman.binarchallengefive.landingpage.fragment.LandingPageOneFragment
import com.utsman.binarchallengefive.landingpage.fragment.LandingPageThreeFragment
import com.utsman.binarchallengefive.landingpage.fragment.LandingPageTwoFragment
import com.utsman.binarchallengefive.toast

class LandingActivity : AppCompatActivity() {

    private val binding: ActivityLandingBinding by lazy {
        ActivityLandingBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val landingFragmentOne = LandingPageOneFragment()
        val landingFragmentTwo = LandingPageTwoFragment()
        val landingFragmentThree = LandingPageThreeFragment()

        val landingPageAdapter = LandingPagerAdapter(
            fragmentManager = supportFragmentManager,
            landingFragmentOne, landingFragmentTwo, landingFragmentThree
        )

        binding.vpLanding.adapter = landingPageAdapter
        binding.dotIndicator.attachTo(binding.vpLanding)

        binding.btnNext.setOnClickListener {
            val currentPosition = binding.vpLanding.currentItem
            binding.vpLanding.setCurrentItem(currentPosition + 1, true)
        }

        binding.vpLanding.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val isLastPosition = position == landingPageAdapter.count-1
                binding.btnNext.isVisible = !isLastPosition
            }
        })
    }
}