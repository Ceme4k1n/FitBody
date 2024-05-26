package com.example.fitness.setup_pages

import android.content.Intent
import android.os.Bundle
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.updateLayoutParams
import com.example.fitness.R

class select_weight_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_weight_screen)

        val linearLayoutNumbers: LinearLayout = findViewById(R.id.linearLayoutPalochki)
        val selectedWeightTextView: TextView = findViewById(R.id.selectedWeight_selectWeight)
        val horizontalScrollView: HorizontalScrollView = findViewById(R.id.horizontalScrollView_selectWeight)

        val buttonBack: TextView = findViewById(R.id.textback_button_selectWeight)
        val buttonContinue: Button = findViewById(R.id.button_continue_selectWeight)

        buttonContinue.setOnClickListener {
            //var intent = Intent(this, goal_screen::class.java)
            //startActivity(intent)
        }

        buttonBack.setOnClickListener {
            val intent = Intent(this, how_old_screen::class.java)
            startActivity(intent)
        }

        // Добавляем изображения с разными размерами
        for (i in 1..151) {
            val imageView = ImageView(this).apply {
                setImageDrawable(ContextCompat.getDrawable(this@select_weight_screen, R.drawable.line_big))
                // Настраиваем размеры для больших и маленьких изображений
                val height = if ((i - 1) % 5 == 0) {
                    60 // высота для больших изображений
                } else {
                    40 // высота для маленьких изображений
                }
                layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, height.dpToPx())
                setPadding(70, 40, 70, 0)
            }
            linearLayoutNumbers.addView(imageView)
        }

        horizontalScrollView.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                horizontalScrollView.viewTreeObserver.removeOnGlobalLayoutListener(this)


                linearLayoutNumbers.setPadding(570, 0, 570, 0)

                selectedWeightTextView.text = "1"
            }
        })

        horizontalScrollView.viewTreeObserver.addOnScrollChangedListener {
            val scrollX = horizontalScrollView.scrollX

            // Количество символов прокрученных влево
            val scrolledSymbols = scrollX / 140

            // Обновляем TextView с выбранным весом
            selectedWeightTextView.text = (scrolledSymbols ).toString()
        }
    }

    // Extension function to convert dp to pixels
    private fun Int.dpToPx(): Int {
        val density = resources.displayMetrics.density
        return (this * density).toInt()
    }
}
