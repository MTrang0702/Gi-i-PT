package com.example.tinhtoan

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Dùng layout XML

        val editTextA = findViewById<EditText>(R.id.editTextA)
        val editTextB = findViewById<EditText>(R.id.editTextB)
        val editTextC = findViewById<EditText>(R.id.editTextC)
        val buttonSolve = findViewById<Button>(R.id.buttonSolve)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonSolve.setOnClickListener {
            try {
                val a = editTextA.text.toString().toDouble()
                val b = editTextB.text.toString().toDouble()
                val c = editTextC.text.toString().toDouble()

                val result = if (a == 0.0) {
                    if (b == 0.0) {
                        if (c == 0.0) "Phương trình có vô số nghiệm."
                        else "Phương trình vô nghiệm."
                    } else {
                        val x = -c / b
                        "Phương trình bậc nhất. Nghiệm x = $x"
                    }
                } else {
                    val delta = b * b - 4 * a * c
                    if (delta > 0) {
                        val x1 = (-b + Math.sqrt(delta)) / (2 * a)
                        val x2 = (-b - Math.sqrt(delta)) / (2 * a)
                        "Phương trình có 2 nghiệm phân biệt:\nx1 = $x1\nx2 = $x2"
                    } else if (delta == 0.0) {
                        val x = -b / (2 * a)
                        "Phương trình có nghiệm kép: x = $x"
                    } else {
                        "Phương trình vô nghiệm (delta < 0)"
                    }
                }

                textViewResult.text = result
            } catch (e: Exception) {
                e.printStackTrace() // hoặc Log.e("Error", e.message.toString())
                textViewResult.text = "Vui lòng nhập đúng định dạng số."
            }
        }
    }
}
