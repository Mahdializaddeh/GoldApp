package info.alirezaahmadi.goldapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import info.alirezaahmadi.goldapp.databinding.ActivityFullScreenBinding

class FullScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startActivity(Intent(this, MainActivity::class.java))

    }

}