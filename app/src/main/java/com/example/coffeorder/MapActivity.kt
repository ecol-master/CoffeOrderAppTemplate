package com.example.coffeorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        setMark()
    }

    private fun setMark() {
        findViewById<ImageView>(R.id.mark_1).setOnClickListener {
            val intent = Intent(this, SecondCoffeeChooseActivity::class.java)
            startActivity(intent)
        }
        findViewById<ImageView>(R.id.mark_2).setOnClickListener {
            val intent = Intent(this, SecondCoffeeChooseActivity::class.java)
            startActivity(intent)
        }
        findViewById<ImageView>(R.id.mark_3).setOnClickListener {
            val intent = Intent(this, SecondCoffeeChooseActivity::class.java)
            startActivity(intent)
        }
    }
}
