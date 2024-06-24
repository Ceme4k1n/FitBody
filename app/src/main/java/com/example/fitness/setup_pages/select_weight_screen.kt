package com.example.fitness.setup_pages

import android.content.Intent
import android.os.Bundle
import android.view.ViewTreeObserver
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.fitness.R

class select_weight_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_weight_screen)

        val linearLayoutNumbers: LinearLayout = findViewById(R.id.linearLayoutPalochki)
        val selectedWeightTextView: TextView = findViewById(R.id.selectedWeight_selectWeight)
        val horizontalScrollView: HorizontalScrollView = findViewById(R.id.horizontalScrollView_selectWeight)
        val buttonBack: TextView = findViewById(R.id.textback_button_selectWeight)
        val buttonContinue: TextView = findViewById(R.id.button_continue_selectWeight)
        val phone_weight=intent.extras?.getString("phone_to_weight") ?: "No message found"
        val sex_weight=intent.extras?.getString("sex_to_howold") ?: "No message found"
        val age_weight=intent.extras?.getString("age_to_weight") ?: "No message found"
        val weight :Int =0 //доделать
        buttonContinue.setOnClickListener {
            var intent3 = Intent(this, goal_screen::class.java)
            intent3.putExtra("phone_to_goal",phone_weight)
            intent3.putExtra("sex_to_goal",sex_weight)
            intent3.putExtra("phone_to_goal",age_weight)
            intent3.putExtra("weight_to_goal",weight) //доделать
            startActivity(intent3)
        }

        buttonBack.setOnClickListener {
            val intent = Intent(this, how_old_screen::class.java)
            startActivity(intent)
        }

        // Добавляем изображения с разными размерами
        for (i in 1..150) {
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

                val scrollViewWidth = horizontalScrollView.width
                val symbolWidth = 70 * 2

                // Установка начальных отступов для центровки изображений
                val initialPadding = (scrollViewWidth / 2) - (symbolWidth / 2)
                linearLayoutNumbers.setPadding(initialPadding, 0, initialPadding, 0)

                // Начальное значение для selectedWeightTextView
                selectedWeightTextView.text = "1"
            }
        })

        horizontalScrollView.viewTreeObserver.addOnScrollChangedListener {
            val scrollX = horizontalScrollView.scrollX

            // Ширина одного символа в пикселях
            val symbolWidth = 70 * 2 // сумма левого и правого отступа (padding)

            // Количество символов прокрученных влево
            val scrolledSymbols = scrollX / symbolWidth

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
