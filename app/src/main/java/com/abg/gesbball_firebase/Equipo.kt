package com.abg.gesbball_firebase

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.math.log

class Equipo:AppCompatActivity() {
    private lateinit var db: DatabaseReference
    private lateinit var texto:TextView

    private var opcion=""
    private var partidos=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.equipo)

        texto=findViewById(R.id.TV_TEXTO)
        db= FirebaseDatabase.getInstance().getReference("Estadisticas")

        fetchData()

    }

    //Recorremos la base de datos
    private fun fetchData() {
        val sharedPreferences: SharedPreferences = getSharedPreferences("Partido", MODE_PRIVATE)
        val partidoGuardado = sharedPreferences.getString("partido", "") ?: ""
        val sharedPreferences2 = getSharedPreferences("PartidoVer", MODE_PRIVATE)
        opcion = sharedPreferences2.getString("partidover","").toString()
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var dataToShowJG1 = ""
                //Recorremos los jugadores
                for (jugadorSnap in snapshot.children) {
                    val jugador = jugadorSnap.getValue(EstadisticasDB::class.java)
                    jugador?.let {
                        //Si el partido guardado es igual a la opción elegida mostramos el texto de
                        // como ha ido para cada jugador
                        Log.i("PartidoVER",opcion)
                        if (it.partido.toString().equals(opcion)) {
                            partidos+=1
                            dataToShowJG1 += "${it.fecha}\n${it.nombre}\n\n" +
                                    "Ha anotado ${it.puntos} puntos, con una anotación de ${it.tlibresA} - ${it.tlibresT} en tiros libres. " +
                                    " Ha cometido ${it.faltas} faltas, de las cuales ${it.faltasT} han sido técnicas. " +
                                    "Sumando a sus estadísticas ${it.asistencias} asistencias," +
                                    "${it.rebotesA} rebotes en ataque y ${it.rebotesD} en defensa," +
                                    " ha generado ${it.contraataque} contraataques, ${it.robos} robos y ${it.perdidas} perdidas de balón\n\n"
                        }
                    }
                }
                texto.text = dataToShowJG1
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }
}