package com.vishnu.dagger.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.vishnu.dagger.R
import com.vishnu.dagger.ui.home.HomeActivity
import kotlinx.coroutines.*


private lateinit var mScope: CoroutineScope

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(intent)

        }, 2000)

    }
}