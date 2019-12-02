package com.example.likemypost

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {
    var up: Int = 0
    var down: Int = 0
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        Log.d("MainActivity", "onCreate")



        imageViewUp.setOnClickListener {
            up++
            textViewUp.text = up.toString()
        }

        imageViewDown.setOnClickListener {
            down++
            textViewDown.text = down.toString()
        }
    }

    override fun onStart() {
        Log.d("MainActivity", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity", "onResume")
        //Retrieve counters from the SharedPref
        up = sharedPreferences.getInt(getString(R.string.thumbs_up), 0)
        down = sharedPreferences.getInt(getString(R.string.thumbs_down),0)

        textViewUp.text = up.toString()
        textViewDown.text = down.toString()
        super.onResume()
    }

    override fun onPause() {
        Log.d("MainActivity", "onPause")
        with(sharedPreferences.edit()) {
            putInt(getString(R.string.thumbs_up), up)
            putInt(getString(R.string.thumbs_down), down)
            apply()
        }
        super.onPause()
    }

    override fun onStop() {
        Log.d("MainActivity", "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("MainActivity", "onDestroy")
        super.onDestroy()
    }
}
