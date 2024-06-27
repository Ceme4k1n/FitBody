package com.example.fitness.setup_pages

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.fitness.R
import com.example.fitness.login_singin.Users_dannie

class how_old_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var user = Users_dannie()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_old_screen)

        val linearLayoutNumbers: LinearLayout = findViewById(R.id.linearLayoutNumbers)
        val selectedAgeTextView: TextView = findViewById(R.id.selectedAgeTextView)
        val horizontalScrollView: HorizontalScrollView = findViewById(R.id.horizontalScrollView_howoldPage)

        val button_back : TextView = findViewById(R.id.textback_button_howoldPage)
        val button_continue : TextView = findViewById(R.id.button_continue_howoldPage)
        val phone_howold = intent.extras?.getString("phone_to_howold") ?: "No message found"
        val sex_howold  = intent.extras?.getString("sex_to_howold") ?: "No message found"
        val nickname_howold=intent.extras?.getString("nickname_to_howold") ?: "No message found"
        var user_email= intent.extras?.getString("email_to_howold") ?: "No message found"
        button_continue.setOnClickListener {
            var intent2 = Intent(this, select_weight_screen::class.java)
            intent2.putExtra("phone_to_weight",phone_howold)
            intent2.putExtra("sex_to_weight",sex_howold)
            intent2.putExtra("age_to_weight",selectedAgeTextView.text.toString())
            intent2.putExtra("nickname_to_weight",nickname_howold)
            intent2.putExtra("email_to_weight",user_email)
            startActivity(intent2)
        }


        button_back.setOnClickListener {
            var intent = Intent(this, select_gender_screen::class.java)
            startActivity(intent)
        }



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
                user.age=selectedAgeTextView.text.toString()
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
                        child.setPadding(selectedPadding, -20, selectedPadding, 2)
                    } else {
                        child.setTextColor(Color.WHITE)
                        child.textSize = 40f
                        child.setPadding(normalPadding, -20, normalPadding, 2)
                    }
                    child.layoutParams = params
                }
            }
        }
    }
}
