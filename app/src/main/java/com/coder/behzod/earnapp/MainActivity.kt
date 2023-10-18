package com.coder.behzod.earnapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coder.behzod.earnapp.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private val intercellerAd:InterstitialAd?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdMob()

    }

    override fun onResume() {
        super.onResume()
        binding.adView.resume()
    }

    override fun onPause() {
        super.onPause()
        binding.adView.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.adView.destroy()
    }
    private fun initAdMob() {
        MobileAds.initialize(this)
        val adRequest=AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)
    }
}