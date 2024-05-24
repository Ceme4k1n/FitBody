package com.example.fitness.setup_pages

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.fitness.R

class how_old_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_old_screen)

        val linearLayoutNumbers: LinearLayout = findViewById(R.id.linearLayoutNumbers)
        val selectedAgeTextView: TextView = findViewById(R.id.selectedAgeTextView)
        val horizontalScrollView: HorizontalScrollView = findViewById(R.id.horizontalScrollView_howoldPage)

        val typeface = ResourcesCompat.getFont(this, R.font.league_spartan_bold)

        for (i in 1..100) {
            val textView = TextView(this).apply {
                text = i.toString()
                textSize = 40f
                setTextColor(Color.WHITE)
                textAlignment = TextView.TEXT_ALIGNMENT_CENTER // Устанавливаем выравнивание по центру
                gravity = Gravity.CENTER // Устанавливаем выравнивание по центру

                setPadding(71, 50, 71, 2)
                typeface?.let { setTypeface(it) }
            }
            linearLayoutNumbers.addView(textView)
        }

        // начальное значение возраста
        selectedAgeTextView.text = "4"

        horizontalScrollView.viewTreeObserver.addOnScrollChangedListener {
            val scrollViewWidth = horizontalScrollView.width
            val scrollX = horizontalScrollView.scrollX

            // центр ScrollView
            val center = scrollX + scrollViewWidth / 2

            // Перебираем все элементы в LinearLayout и ищем ближайший к центру
            var closestChild: TextView? = null
            var minDistance = Int.MAX_VALUE

            for (i in 0 until linearLayoutNumbers.childCount) {
                val child = linearLayoutNumbers.getChildAt(i) as TextView
                val childCenterX = (child.left + child.right) / 2
                val distance = Math.abs(childCenterX - center)
                if (distance < minDistance) {
                    minDistance = distance
                    closestChild = child
                }
            }

            // Обновляем TextView с выбранным возрастом
            closestChild?.let {
                selectedAgeTextView.text = it.text.toString()
                // Установка черного цвета и размера 20sp для цифры в середине
                val normalPadding = 71 // обычные отступы
                val selectedPadding = 71 // отступы для выбранного элемента
                for (i in 0 until linearLayoutNumbers.childCount) {
                    val child = linearLayoutNumbers.getChildAt(i) as TextView
                    val params = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    if (child == closestChild) {
                        child.setTextColor(Color.BLACK)
                        child.textSize = 60f
                        child.setPadding(selectedPadding, 0, selectedPadding, 2)
                    } else {
                        child.setTextColor(Color.WHITE)
                        child.textSize = 40f
                        child.setPadding(normalPadding, 20, normalPadding, 2)
                    }
                    child.layoutParams = params
                }
            }
        }
    }
}
