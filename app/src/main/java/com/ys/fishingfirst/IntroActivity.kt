package com.ys.fishingfirst

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val introText = findViewById<TextView>(R.id.introText)
        val ani = AnimationUtils.loadAnimation(this,R.anim.intro_logo)
        introText.startAnimation(ani)

        Executors.newSingleThreadScheduledExecutor().schedule({
            startActivity(Intent(this,MainActivity::class.java))
            finish() // 인트로 엑티비티 종료.
        }, 5, TimeUnit.SECONDS)

    }
}