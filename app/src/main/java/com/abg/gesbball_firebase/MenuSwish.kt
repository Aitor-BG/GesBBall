package com.abg.gesbball_firebase

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MenuSwish: AppCompatActivity() {

    private lateinit var bt_jg1:Button
    private lateinit var bt_jg2:Button
    private lateinit var bt_jg3:Button
    private lateinit var bt_jg4:Button
    private lateinit var bt_jg5:Button
    private lateinit var bt_jg6:Button
    private lateinit var bt_jg7:Button
    private lateinit var bt_jg8:Button
    private lateinit var bt_jg9:Button
    private lateinit var bt_jg10:Button
    private lateinit var bt_jg11:Button
    private lateinit var bt_jg12:Button
    private lateinit var bt_jg13:Button
    private lateinit var bt_jg14:Button
    private lateinit var bt_jg15:Button
    private lateinit var volver: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menuswish)

        volver=findViewById(R.id.BT_VOLVER)
        bt_jg1=findViewById(R.id.BT_JG1)
        bt_jg2=findViewById(R.id.BT_JG2)
        bt_jg3=findViewById(R.id.BT_JG3)
        bt_jg4=findViewById(R.id.BT_JG4)
        bt_jg5=findViewById(R.id.BT_JG5)
        bt_jg6=findViewById(R.id.BT_JG6)
        bt_jg7=findViewById(R.id.BT_JG7)
        bt_jg8=findViewById(R.id.BT_JG8)
        bt_jg9=findViewById(R.id.BT_JG9)
        bt_jg10=findViewById(R.id.BT_JG10)
        bt_jg11=findViewById(R.id.BT_JG11)
        bt_jg12=findViewById(R.id.BT_JG12)
        bt_jg13=findViewById(R.id.BT_JG13)
        bt_jg14=findViewById(R.id.BT_JG14)
        bt_jg15=findViewById(R.id.BT_JG15)

        volver.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        /*Dependiendo el jugador que pulsemos vamos a la pestaña de Jugador con los datos del Jugador pulsado*/
        bt_jg1.setOnClickListener {
            val sharedPreferences: SharedPreferences = getSharedPreferences("Swish", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("swish",bt_jg1.text.toString())
            editor.apply()
            val intent = Intent(this, Jugador::class.java)
            startActivity(intent)
        }

        bt_jg2.setOnClickListener {
            val sharedPreferences: SharedPreferences = getSharedPreferences("Swish", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("swish",bt_jg2.text.toString())
            editor.apply()
            val intent = Intent(this, Jugador::class.java)
            startActivity(intent)
        }

        bt_jg3.setOnClickListener {
            val sharedPreferences: SharedPreferences = getSharedPreferences("Swish", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("swish",bt_jg3.text.toString())
            editor.apply()
            val intent = Intent(this, Jugador::class.java)
            startActivity(intent)
        }

        bt_jg4.setOnClickListener {
            val sharedPreferences: SharedPreferences = getSharedPreferences("Swish", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("swish",bt_jg4.text.toString())
            editor.apply()
            val intent = Intent(this, Jugador::class.java)
            startActivity(intent)
        }

        bt_jg5.setOnClickListener {
            val sharedPreferences: SharedPreferences = getSharedPreferences("Swish", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("swish",bt_jg5.text.toString())
            editor.apply()
            val intent = Intent(this, Jugador::class.java)
            startActivity(intent)
        }

        bt_jg6.setOnClickListener {
            val sharedPreferences: SharedPreferences = getSharedPreferences("Swish", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("swish",bt_jg6.text.toString())
            editor.apply()
            val intent = Intent(this, Jugador::class.java)
            startActivity(intent)
        }

        bt_jg7.setOnClickListener {
            val sharedPreferences: SharedPreferences = getSharedPreferences("Swish", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("swish",bt_jg7.text.toString())
            editor.apply()
            val intent = Intent(this, Jugador::class.java)
            startActivity(intent)
        }

        bt_jg8.setOnClickListener {
            val sharedPreferences: SharedPreferences = getSharedPreferences("Swish", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("swish",bt_jg8.text.toString())
            editor.apply()
            val intent = Intent(this, Jugador::class.java)
            startActivity(intent)
        }

        bt_jg9.setOnClickListener {
            val sharedPreferences: SharedPreferences = getSharedPreferences("Swish", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("swish",bt_jg9.text.toString())
            editor.apply()
            val intent = Intent(this, Jugador::class.java)
            startActivity(intent)
        }

        bt_jg10.setOnClickListener {
            val sharedPreferences: SharedPreferences = getSharedPreferences("Swish", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("swish",bt_jg10.text.toString())
            editor.apply()
            val intent = Intent(this, Jugador::class.java)
            startActivity(intent)
        }

        bt_jg11.setOnClickListener {
            val sharedPreferences: SharedPreferences = getSharedPreferences("Swish", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("swish",bt_jg11.text.toString())
            editor.apply()
            val intent = Intent(this, Jugador::class.java)
            startActivity(intent)
        }

        bt_jg12.setOnClickListener {
            val sharedPreferences: SharedPreferences = getSharedPreferences("Swish", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("swish",bt_jg12.text.toString())
            editor.apply()
            val intent = Intent(this, Jugador::class.java)
            startActivity(intent)
        }

        bt_jg13.setOnClickListener {
            val sharedPreferences: SharedPreferences = getSharedPreferences("Swish", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("swish",bt_jg13.text.toString())
            editor.apply()
            val intent = Intent(this, Jugador::class.java)
            startActivity(intent)
        }

        bt_jg14.setOnClickListener {
            val sharedPreferences: SharedPreferences = getSharedPreferences("Swish", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("swish",bt_jg14.text.toString())
            editor.apply()
            val intent = Intent(this, Jugador::class.java)
            startActivity(intent)
        }

        bt_jg15.setOnClickListener {
            val sharedPreferences: SharedPreferences = getSharedPreferences("Swish", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("swish",bt_jg15.text.toString())
            editor.apply()
            val intent = Intent(this, Jugador::class.java)
            startActivity(intent)
        }
    }
}