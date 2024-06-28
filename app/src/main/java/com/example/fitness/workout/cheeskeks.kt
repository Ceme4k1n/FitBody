package com.example.fitness.workout

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitness.R

class cheeskeks : AppCompatActivity() {

    private lateinit var video: VideoView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheeskeks)

        val save_res : TextView = findViewById(R.id.button_save_res_cheesPage)
        val back_button : TextView = findViewById(R.id.text_meal_plans_cheesPage)


        save_res.setOnClickListener {
            var intent = Intent(this, fruits::class.java)
            startActivity(intent)
            finish()
        }

        back_button.setOnClickListener {
            var intent = Intent(this, fruits::class.java)
            startActivity(intent)
            finish()
        }

        video = findViewById(R.id.video_chees_cheesPage)
        video.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.keks))
        video.pause()

        val mediaController = MediaController(this)
        video.setMediaController(mediaController)
        mediaController.setAnchorView(video)
    }
}