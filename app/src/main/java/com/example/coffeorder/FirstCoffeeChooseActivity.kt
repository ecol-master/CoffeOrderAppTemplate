package com.example.coffeorder

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class FirstCoffeeChooseActivity : AppCompatActivity() {

    private var coffeeSize = ""
    private var sugar = false
    private var milk = false
    private var sirop = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_coffee_choose_activity)
        coffeeSize = findViewById<RadioButton>(R.id.rbb1).text.toString()
        setRadioButton()
        setCheckBox()
        doOrder()
        checkChooseCoffee()
    }

    private fun setRadioButton() {
        findViewById<RadioButton>(R.id.rbb1).setOnClickListener {
            coffeeSize = (it as RadioButton).text.toString()
            findViewById<RadioButton>(R.id.rbb1).isChecked = true
            findViewById<RadioButton>(R.id.rbb2).isChecked = false
            findViewById<RadioButton>(R.id.rbb3).isChecked = false
        }
        findViewById<RadioButton>(R.id.rbb2).setOnClickListener {
            coffeeSize = (it as RadioButton).text.toString()
            findViewById<RadioButton>(R.id.rbb1).isChecked = false
            findViewById<RadioButton>(R.id.rbb2).isChecked = true
            findViewById<RadioButton>(R.id.rbb3).isChecked = false
        }
        findViewById<RadioButton>(R.id.rbb3).setOnClickListener {
            coffeeSize = (it as RadioButton).text.toString()
            findViewById<RadioButton>(R.id.rbb1).isChecked = false
            findViewById<RadioButton>(R.id.rbb2).isChecked = false
            findViewById<RadioButton>(R.id.rbb3).isChecked = true
        }
    }

    private fun setCheckBox() {
        findViewById<CheckBox>(R.id.checkBoxBG).setOnClickListener {
            sugar = !sugar
        }
        findViewById<CheckBox>(R.id.checkBoxV).setOnClickListener {
            milk = !milk
        }
        findViewById<CheckBox>(R.id.checkBoxC).setOnClickListener {
            sirop = !sirop
        }
    }


    private fun checkChooseCoffee() {
        val image1 = findViewById<ImageView>(R.id.imageView1)
        val image2 = findViewById<ImageView>(R.id.imageView2)
        val image3 = findViewById<ImageView>(R.id.imageView3)
        findViewById<RadioButton>(R.id.rb4).setOnClickListener {
            image1.visibility = View.VISIBLE
            image2.visibility = View.INVISIBLE
            image3.visibility = View.INVISIBLE
        }
        findViewById<RadioButton>(R.id.rb5).setOnClickListener {
            image1.visibility = View.INVISIBLE
            image2.visibility = View.VISIBLE
            image3.visibility = View.INVISIBLE
        }
        findViewById<RadioButton>(R.id.rb6).setOnClickListener {
            image1.visibility = View.INVISIBLE
            image2.visibility = View.INVISIBLE
            image3.visibility = View.VISIBLE
        }
    }


    private fun doOrder() {
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup1)
        findViewById<Button>(R.id.buttonSubmit).setOnClickListener {
            val coffeeType = findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text.toString()
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("coffeeType", coffeeType)
            intent.putExtra("coffeeSize", coffeeSize)
            intent.putExtra("sugar", sugar)
            intent.putExtra("milk", milk)
            intent.putExtra("sirop", sirop)
            startActivity(intent)
        }
    }
}