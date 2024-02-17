package ru.sample.duckapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val baseUrl = "https://random-d.uk/api/v2"

        val imageView = findViewById<ImageView>(R.id.imageView)
        val button = findViewById<Button>(R.id.button)
        val numberInput = findViewById<EditText>(R.id.duckNumberInput)

        val circularProgressDrawable = CircularProgressDrawable(this)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()


        button.setOnClickListener {
            var inputNumber = 0;
            try {
                inputNumber = numberInput.text.toString().toInt()
            } catch (_: Exception) {

            }
            val duckSearchNumber = if (inputNumber == 0) Random.nextInt(1, 200) else inputNumber

            val imgUrl = "${baseUrl}/${duckSearchNumber}.jpg"
            Glide.with(this)
                .load(imgUrl)
                .placeholder(circularProgressDrawable)
                .into(imageView)
        }


    }
}