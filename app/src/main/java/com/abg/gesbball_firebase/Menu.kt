package com.abg.gesbball_firebase

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Menu: AppCompatActivity() {

    private lateinit var bt_partido:ImageButton
    private lateinit var bt_video:ImageButton
    private lateinit var bt_equipo:ImageButton
    private lateinit var bt_jugador:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)

        bt_partido=findViewById(R.id.BT_PARTIDO)
        bt_video=findViewById(R.id.BT_VIDEO)
        bt_equipo=findViewById(R.id.BT_EQUIPO)
        bt_jugador=findViewById(R.id.BT_JUGADOR)

        //Nos dirijimos a la ventana de partido
        bt_partido.setOnClickListener {
            val intent = Intent(this, MenuPartido::class.java)
            startActivity(intent)
        }

        //Nos dirijimos a la videoteca y guardamos la página de donde venimos
        bt_video.setOnClickListener {
            val banvid = "menu"
            val sharedPreferences2: SharedPreferences = getSharedPreferences("Pagina", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences2.edit()
            editor.putString("pagina",banvid)
            editor.apply()
            val intent = Intent(this, Videoteca::class.java)
            startActivity(intent)
        }

        //Nos dirijimos a la ventana de equipo
        bt_equipo.setOnClickListener {
            val intent = Intent(this, MenuEquipo::class.java)
            startActivity(intent)
        }

        //Nos dirijimos a la ventana de jugador
        bt_jugador.setOnClickListener {
            val intent = Intent(this, MenuSwish::class.java)
            startActivity(intent)
        }
    }
}