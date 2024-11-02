package com.abg.gesbball_firebase

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Jugador:AppCompatActivity() {

    private lateinit var db: DatabaseReference
    private lateinit var texto: TextView
    private lateinit var puntos: TextView
    private lateinit var tlibresA:TextView
    private lateinit var tlibresT:TextView
    private lateinit var faltasN:TextView
    private lateinit var faltasT:TextView
    private lateinit var asistencias:TextView
    private lateinit var rebotesA:TextView
    private lateinit var rebotesD:TextView
    private lateinit var contraataque:TextView
    private lateinit var robos:TextView
    private lateinit var perdidas:TextView
    private lateinit var volver:ImageButton

    private var partidos=0
    private var pt:Float=0.0f
    private var tlA=0
    private var tlT=0
    private var fn:Float=0.0f
    private var ft:Float=0.0f
    private var asi:Float=0.0f
    private var rbA:Float=0.0f
    private var rbD:Float=0.0f
    private var cnt:Float=0.0f
    private var rob:Float=0.0f
    private var per:Float=0.0f

    private var opcion=""
    private var partidoN=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jugador)
        volver=findViewById(R.id.BT_VOLVER)
        texto=findViewById(R.id.TEXTO)
        puntos=findViewById(R.id.PUNTOS)
        tlibresA=findViewById(R.id.TIROSLIBRESA)
        tlibresT=findViewById(R.id.TIROSLIBREST)
        faltasN=findViewById(R.id.FALTASN)
        faltasT=findViewById(R.id.FALTAST)
        asistencias=findViewById(R.id.ASISTENCIAS)
        rebotesA=findViewById(R.id.REBOTESA)
        rebotesD=findViewById(R.id.REBOTESD)
        contraataque=findViewById(R.id.CONTRAATAQUE)
        robos=findViewById(R.id.ROBOS)
        perdidas=findViewById(R.id.PERDIDAS)
        db= FirebaseDatabase.getInstance().getReference("Estadisticas")
        fetchData()

        //Volvemos a MenuSwish para escoger otro jugador
        volver.setOnClickListener {
            val intent = Intent(this, MenuSwish::class.java)
            startActivity(intent)
        }

    }

    //Recorremos la base de datos
    private fun fetchData() {
        val sharedPreferences: SharedPreferences = getSharedPreferences("Partido", MODE_PRIVATE)
        val partidoGuardado = sharedPreferences.getString("partido", "") ?: ""
        val sharedPreferences2 = getSharedPreferences("Swish", MODE_PRIVATE)
        opcion = sharedPreferences2.getString("swish","").toString()
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var dataToShowJG1 = ""
                for (jugadorSnap in snapshot.children) {
                    val jugador = jugadorSnap.getValue(EstadisticasDB::class.java)
                    jugador?.let {
                        //Si el nombre del jugador es igual al elegido, mostramos su estadística y la de todos sus partidos
                        if (it.nombre.toString()==opcion) {
                                    partidos+=1
                                    dataToShowJG1 += "${it.partido} - ${it.fecha}\n\n" +
                                            "Ha anotado ${it.puntos} puntos, con una anotación de ${it.tlibresA} - ${it.tlibresT} en tiros libres. " +
                                            " Ha cometido ${it.faltas} faltas, de las cuales ${it.faltasT} han sido técnicas. " +
                                            "Sumando a sus estadísticas ${it.asistencias} asistencias," +
                                            "${it.rebotesA} rebotes en ataque y ${it.rebotesD} en defensa," +
                                            " ha generado ${it.contraataque} contraataques, ${it.robos} robos y ${it.perdidas} perdidas de balón\n\n"
                                    pt+=it.puntos!!
                                    tlA+=it.tlibresA!!
                                    tlT+=it.tlibresT!!
                                    fn+=it.faltas!!
                                    ft+=it.faltasT!!
                                    asi+=it.asistencias!!
                                    rbA+=it.rebotesA!!
                                    rbD+=it.rebotesD!!
                                    cnt+=it.contraataque!!
                                    rob+=it.robos!!
                                    per+=it.perdidas!!
                        }
                    }
                }
                //Hacemos la media de las estadícticas y las mostramos
                puntos.text=String.format("%.2f", (pt/partidos))
                tlibresA.text=tlA.toString()
                tlibresT.text=tlT.toString()
                faltasN.text=String.format("%.2f", (fn/partidos))
                faltasT.text=String.format("%.2f", (ft/partidos))
                asistencias.text=String.format("%.2f", (asi/partidos))
                rebotesA.text=String.format("%.2f", (rbA/partidos))
                rebotesD.text=String.format("%.2f", (rbD/partidos))
                contraataque.text=String.format("%.2f", (cnt/partidos))
                robos.text=String.format("%.2f", (rob/partidos))
                perdidas.text=String.format("%.2f", (per/partidos))
                texto.text = dataToShowJG1
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }
}