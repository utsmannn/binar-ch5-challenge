package com.utsman.binarchallengefive

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.load(url: String) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .into(this)
}

fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Context.intentTo(clazz: Class<*>, beforeStart: (Intent) -> Unit) {
    val intent = Intent(this, clazz)
    beforeStart.invoke(intent)
    startActivity(intent)
}

/*
fun main() {
    val suits = listOf("Batu", "Kertas", "Gunting")
    val random = java.util.Random()

    println("Pilih: Batu (0), Kertas (1), Gunting (2)")
    val playerChoice = readLine()!!.toInt()
    val computerChoice = random.nextInt(3)

    println("Pemain memilih: ${suits[playerChoice]}")
    println("Komputer memilih: ${suits[computerChoice]}")

    when {
        playerChoice == computerChoice -> println("Seri!")
        (playerChoice + 1) % 3 == computerChoice -> println("Pemain Menang!")
        else -> println("Komputer Menang!")
    }
}*/
