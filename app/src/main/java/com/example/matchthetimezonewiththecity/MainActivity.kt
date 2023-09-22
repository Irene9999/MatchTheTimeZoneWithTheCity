package com.example.matchthetimezonewiththecity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.matchthetimezonewiththecity.ui.theme.MatchTheTimeZoneWithTheCityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MatchTheTimeZoneWithTheCityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MatchTheTimeZoneWithTheCityTheme {
        Greeting("Android")
    }
}
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playButton = findViewById<Button>(R.id.playButton)
        playButton.setBackgroundColor(Color.parseColor("#FFC0CB")) // Розовый цвет
        playButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:orientation="vertical"
android:background="#000080"> <!-- Темно-синий цвет -->

<TextView
android:id="@+id/gameTitle"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Match the time zone with the city"
android:textSize="24sp"
android:textColor="#FFFFFF" />

<Button
android:id="@+id/playButton"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Играть" />
</LinearLayout>
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val playButton = findViewById<Button>(R.id.playButton)
        playButton.setBackgroundColor(Color.parseColor("#FFC0CB")) // Розовый цвет
        playButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:orientation="vertical"
android:background="#000080"> <!-- Темно-синий цвет -->

<!-- Изображение часов с временем 2:51 -->
<ClockView
android:id="@+id/clockView"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_gravity="center"
android:layout_marginTop="16dp" />

<!-- Кнопка 1 -->
<Button
android:id="@+id/button1"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Кнопка 1"
android:layout_gravity="center"
android:layout_marginTop="16dp" />

<!-- Кнопка 2 -->
<Button
android:id="@+id/button2"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Кнопка 2"
android:layout_gravity="center"
android:layout_marginTop="16dp" />
</LinearLayout>

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Устанавливаем время "00:10"
        val timeTextView = findViewById<TextView>(R.id.timeTextView)
        timeTextView.text = "00:10"

        // Добавляем часы, показывающие "2:51"
        val clockLayout = findViewById<LinearLayout>(R.id.clockLayout)
        val clockView = ClockView(this)
        clockView.setTime(2, 51)
        clockLayout.addView(clockView)

        // Добавляем три циферблата часов в один ряд
        val cityClocksLayout = findViewById<LinearLayout>(R.id.cityClocksLayout)
        addCityClock(cityClocksLayout, "9:00", "City 1")
        addCityClock(cityClocksLayout, "5:00", "City 2")
        addCityClock(cityClocksLayout, "6:00", "City 3")

        // Добавляем еще три циферблата часов в один ряд
        val moreCityClocksLayout = findViewById<LinearLayout>(R.id.moreCityClocksLayout)
        addCityClock(moreCityClocksLayout, "7:00", "City 4")
        addCityClock(moreCityClocksLayout, "8:00", "City 5")
        addCityClock(moreCityClocksLayout, "12:00", "City 6")
    }

    private fun addCityClock(layout: LinearLayout, time: String, city: String) {
        val cityClockView = CityClockView(this)
        cityClockView.setTime(time)
        cityClockView.setCity(city)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.gravity = Gravity.CENTER
        cityClockView.layoutParams = params

        layout.addView(cityClockView)
    }
}
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:orientation="vertical"
android:background="#000080"> <!-- Темно-синий цвет -->

<TextView
android:id="@+id/timeTextView"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:textSize="48sp"
android:textColor="#FFFFFF"
android:text="00:00"
android:layout_gravity="center"
android:paddingTop="16dp" />

<LinearLayout
android:id="@+id/clockLayout"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:orientation="horizontal"
android:gravity="center"
android:paddingTop="16dp" />

<LinearLayout
android:id="@+id/cityClocksLayout"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:orientation="horizontal"
android:gravity="center"
android:paddingTop="16dp" />

<LinearLayout
android:id="@+id/moreCityClocksLayout"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:orientation="horizontal"
android:gravity="center"
android:paddingTop="16dp" />
</LinearLayout>


class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Устанавливаем время на часах
        val clockView = findViewById<ClockView>(R.id.clockView)
        clockView.setTime(2, 51)

        // Устанавливаем время на циферблате
        val clockFaceView = findViewById<ClockView>(R.id.clockFaceView)
        clockFaceView.setTime(9, 0)

        // Находим и настраиваем кнопки
        val answerButton = findViewById<Button>(R.id.answerButton)
        val okButton = findViewById<Button>(R.id.okButton)

        answerButton.setBackgroundColor(Color.WHITE) // Белый цвет
        okButton.setBackgroundColor(Color.parseColor("#FFC0CB")) // Розовый цвет

        answerButton.text = "Укажите ответ"
        okButton.text = "ОК"
    }
}
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:orientation="vertical"
android:background="#000080"> <!-- Темно-синий цвет -->

<!-- Часы с временем 2:51 -->
<ClockView
android:id="@+id/clockView"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_gravity="center"
android:layout_marginTop="16dp" />

<!-- Циферблат с временем 9:00 -->
<ClockView
android:id="@+id/clockFaceView"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_gravity="center"
android:layout_marginTop="16dp" />

<!-- Кнопки -->
<LinearLayout
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:orientation="horizontal"
android:gravity="center"
android:layout_marginTop="16dp">

<Button
android:id="@+id/answerButton"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:textColor="#000000" />

<Button
android:id="@+id/okButton"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:textColor="#FFFFFF" />
</LinearLayout>
</LinearLayout>

