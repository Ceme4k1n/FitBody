package com.example.fitness.workout

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.MediaController
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.R
import com.example.fitness.floating_menus.home_page_screen

class first_train_screen : AppCompatActivity() {
    private lateinit var video: VideoView
    private lateinit var btnPlay: TextView
    private lateinit var btnPause: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var timerText: TextView

    private var countDownTimer: CountDownTimer? = null
    private var isPlaying = false

    private val timecodes = listOf(
        0L, // Начало видео
        77000L,  // 1:17
        104000L, // 1:48
        138000L, // 2:18
        169000L, // 2:49
        199000L, // 3:19
        229000L, // 3:49
        260000L, // 4:20
        291000L, // 4:51
        321000L  // 5:21
    )
    private val timeDurations = listOf(
        80000L,             // От начала до 1:17
        111000L - 80000L,   // 1:17 - 1:47
        142000L - 111000L,  // 1:47 - 2:18
        173000L - 142000L,  // 2:19 - 2:49
        204000L - 174000L,  // 2:49 - 3:19
        234000L - 204000L,  // 3:19 - 3:50
        265000L - 235000L,  // 3:49 - 4:20
        295000L - 265000L,  // 4:20 - 4:51
        325000L - 295000L   // 4:51 - 5:21
    )
    private var currentSegmentIndex = 0
    private var timeLeft = timeDurations[0]  // Remaining time for the timer
    private var videoPausedPosition = 0      // Position of the video when paused

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_train_screen)

        val back_button : TextView = findViewById(R.id.text_train_trainPage)

        back_button.setOnClickListener{
            var intent = Intent(this, home_page_screen::class.java)
            startActivity(intent)
        }

        progressBar = findViewById(R.id.progressBar_trainPage)
        timerText = findViewById(R.id.timer_trainPage)

        btnPlay = findViewById(R.id.play_button_trainPage)
        btnPause = findViewById(R.id.pause_button_trainPage)

        video = findViewById(R.id.video_trainPage)
        video.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.sex))

        val mediaController = MediaController(this)
        video.setMediaController(mediaController)
        mediaController.setAnchorView(video)

        btnPlay.setOnClickListener {
            if (!isPlaying) {
                video.seekTo(videoPausedPosition)
                video.start()
                startTimer(timeLeft)
                isPlaying = true
            }
        }

        btnPause.setOnClickListener {
            if (isPlaying) {
                video.pause()
                videoPausedPosition = video.currentPosition
                pauseTimer()
                isPlaying = false
            }
        }
    }

    private fun startTimer(timeMillis: Long) {
        countDownTimer = object : CountDownTimer(timeMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = millisUntilFinished
                val secondsLeft = millisUntilFinished / 1000
                timerText.text = String.format("%02d:%02d", secondsLeft / 60, secondsLeft % 60)
                val progress = ((timeDurations[currentSegmentIndex] - millisUntilFinished).toFloat() /
                        timeDurations[currentSegmentIndex] * 100).toInt()
                progressBar.progress = progress
            }

            override fun onFinish() {
                timerText.text = "00:00"
                progressBar.progress = 100
                isPlaying = false
                video.pause()
                videoPausedPosition = video.currentPosition

                if (currentSegmentIndex < timeDurations.size - 1) {
                    currentSegmentIndex++
                    timeLeft = timeDurations[currentSegmentIndex]
                } else {
                    video.stopPlayback()
                }
            }
        }.start()
    }

    private fun pauseTimer() {
        countDownTimer?.cancel()
    }

    override fun onPause() {
        super.onPause()
        if (video.isPlaying) {
            video.pause()
            videoPausedPosition = video.currentPosition
            pauseTimer()
            isPlaying = false
        }
    }

    override fun onResume() {
        super.onResume()
        if (!isPlaying && videoPausedPosition > 0) {
            video.seekTo(videoPausedPosition)
            video.start()
            startTimer(timeLeft)
            isPlaying = true
        }
    }
}