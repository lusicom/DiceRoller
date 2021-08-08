package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
    }
    
    private fun rollDice() {

        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()


        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        val drawableResource = intToDrawable(diceRoll)
        val drawableResource2 = intToDrawable(diceRoll2)

        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)

        val sumResult = diceRoll + diceRoll2

        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = sumResult.toString()
    }

    private fun intToDrawable(diceRoll: Int) = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
    }

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }

}




