package com.utsman.binarchallengefive.vscom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.utsman.binarchallengefive.Suit
import com.utsman.binarchallengefive.databinding.ActivityVscomBinding

class VscomActivity : AppCompatActivity() {

    private val binding: ActivityVscomBinding by lazy {
        ActivityVscomBinding.inflate(layoutInflater)
    }

    private var currentSuitPlayer: Suit? = null
    private var currentSuitCom: Suit? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupPlayerAction()
    }

    private fun setupPlayerAction() {
        binding.tvGuntingPlayer.setOnClickListener {
            currentSuitPlayer = Suit.GUNTING
            setupComAction()
        }

        binding.tvRockPlayer.setOnClickListener {
            currentSuitPlayer = Suit.ROCK
            setupComAction()
        }

        binding.tvPaperPlayer.setOnClickListener {
            currentSuitPlayer = Suit.PAPER
            setupComAction()
        }
    }

    private fun setupComAction() {
        currentSuitCom = getArraySuit().random()
        postAction()
    }

    private fun postAction() {
        val textResult = when (currentSuitPlayer) {
            Suit.GUNTING -> playerGuntingSelected()
            Suit.PAPER -> playerPaperSelected()
            else -> playerRockSelected()
        }


        binding.tvResult.text = "Kamu $textResult, komputer memilih $currentSuitCom"
    }

    private fun playerGuntingSelected(): String {
        return when (currentSuitCom) {
            Suit.GUNTING -> "seri"
            Suit.ROCK -> "kalah"
            else -> "menang"
        }
    }

    private fun playerRockSelected(): String {
        return when (currentSuitCom) {
            Suit.GUNTING -> "menang"
            Suit.ROCK -> "seri"
            else -> "kalah"
        }
    }

    private fun playerPaperSelected(): String {
        return when (currentSuitCom) {
            Suit.GUNTING -> "kalah"
            Suit.ROCK -> "menang"
            else -> "seri"
        }
    }

    private fun getArraySuit(): List<Suit> {
        return listOf(Suit.GUNTING, Suit.ROCK, Suit.PAPER)
    }
}