package com.abg.gesbball_firebase

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Partido : AppCompatActivity() {
    private lateinit var db: DatabaseReference
    private lateinit var db2: DatabaseReference

    private lateinit var ml:TextView
    private lateinit var mv:TextView

    private lateinit var jg1:TextView
    private lateinit var pt1:TextView
    private lateinit var tla1:TextView
    private lateinit var tlt1:TextView
    private lateinit var fpn1:TextView
    private lateinit var fpt1:TextView
    private lateinit var as1:TextView
    private lateinit var rba1:TextView
    private lateinit var rbd1:TextView
    private lateinit var ptc1:TextView
    private lateinit var rob1:TextView
    private lateinit var pe1:TextView

    private lateinit var jg2:TextView
    private lateinit var pt2:TextView
    private lateinit var tla2:TextView
    private lateinit var tlt2:TextView
    private lateinit var fpn2:TextView
    private lateinit var fpt2:TextView
    private lateinit var as2:TextView
    private lateinit var rba2:TextView
    private lateinit var rbd2:TextView
    private lateinit var ptc2:TextView
    private lateinit var rob2:TextView
    private lateinit var pe2:TextView

    private lateinit var jg3:TextView
    private lateinit var pt3:TextView
    private lateinit var tla3:TextView
    private lateinit var tlt3:TextView
    private lateinit var fpn3:TextView
    private lateinit var fpt3:TextView
    private lateinit var as3:TextView
    private lateinit var rba3:TextView
    private lateinit var rbd3:TextView
    private lateinit var ptc3:TextView
    private lateinit var rob3:TextView
    private lateinit var pe3:TextView

    private lateinit var jg4:TextView
    private lateinit var pt4:TextView
    private lateinit var tla4:TextView
    private lateinit var tlt4:TextView
    private lateinit var fpn4:TextView
    private lateinit var fpt4:TextView
    private lateinit var as4:TextView
    private lateinit var rba4:TextView
    private lateinit var rbd4:TextView
    private lateinit var ptc4:TextView
    private lateinit var rob4:TextView
    private lateinit var pe4:TextView

    private lateinit var jg5:TextView
    private lateinit var pt5:TextView
    private lateinit var tla5:TextView
    private lateinit var tlt5:TextView
    private lateinit var fpn5:TextView
    private lateinit var fpt5:TextView
    private lateinit var as5:TextView
    private lateinit var rba5:TextView
    private lateinit var rbd5:TextView
    private lateinit var ptc5:TextView
    private lateinit var rob5:TextView
    private lateinit var pe5:TextView

    private lateinit var btbanquillo:Button
    private lateinit var btfin:Button

    private lateinit var btpt12:ImageButton
    private lateinit var btpt13:ImageButton
    private lateinit var bttla1:ImageButton
    private lateinit var bttlt1:ImageButton
    private lateinit var btfpn1:ImageButton
    private lateinit var btfpt1:ImageButton
    private lateinit var btas1:ImageButton
    private lateinit var btrba1:ImageButton
    private lateinit var btrbd1:ImageButton
    private lateinit var btptc12:ImageButton
    private lateinit var btptc13:ImageButton
    private lateinit var btrob1:ImageButton
    private lateinit var btpe1:ImageButton

    private lateinit var btpt22:ImageButton
    private lateinit var btpt23:ImageButton
    private lateinit var bttla2:ImageButton
    private lateinit var bttlt2:ImageButton
    private lateinit var btfpn2:ImageButton
    private lateinit var btfpt2:ImageButton
    private lateinit var btas2:ImageButton
    private lateinit var btrba2:ImageButton
    private lateinit var btrbd2:ImageButton
    private lateinit var btptc22:ImageButton
    private lateinit var btptc23:ImageButton
    private lateinit var btrob2:ImageButton
    private lateinit var btpe2:ImageButton

    private lateinit var btpt32:ImageButton
    private lateinit var btpt33:ImageButton
    private lateinit var bttla3:ImageButton
    private lateinit var bttlt3:ImageButton
    private lateinit var btfpn3:ImageButton
    private lateinit var btfpt3:ImageButton
    private lateinit var btas3:ImageButton
    private lateinit var btrba3:ImageButton
    private lateinit var btrbd3:ImageButton
    private lateinit var btptc32:ImageButton
    private lateinit var btptc33:ImageButton
    private lateinit var btrob3:ImageButton
    private lateinit var btpe3:ImageButton

    private lateinit var btpt42:ImageButton
    private lateinit var btpt43:ImageButton
    private lateinit var bttla4:ImageButton
    private lateinit var bttlt4:ImageButton
    private lateinit var btfpn4:ImageButton
    private lateinit var btfpt4:ImageButton
    private lateinit var btas4:ImageButton
    private lateinit var btrba4:ImageButton
    private lateinit var btrbd4:ImageButton
    private lateinit var btptc42:ImageButton
    private lateinit var btptc43:ImageButton
    private lateinit var btrob4:ImageButton
    private lateinit var btpe4:ImageButton

    private lateinit var btpt52:ImageButton
    private lateinit var btpt53:ImageButton
    private lateinit var bttla5:ImageButton
    private lateinit var bttlt5:ImageButton
    private lateinit var btfpn5:ImageButton
    private lateinit var btfpt5:ImageButton
    private lateinit var btas5:ImageButton
    private lateinit var btrba5:ImageButton
    private lateinit var btrbd5:ImageButton
    private lateinit var btptc52:ImageButton
    private lateinit var btptc53:ImageButton
    private lateinit var btrob5:ImageButton
    private lateinit var btpe5:ImageButton

    private lateinit var bt1ptv:ImageButton
    private lateinit var bt2ptv:ImageButton
    private lateinit var bt3ptv:ImageButton

    private var puntosL = 0
    private var puntosV = 0
    private var cuarto = 0

    private var puntos1 = 0
    private var tlibreA1 = 0
    private var tlibreT1 = 0
    private var faltaP1 = 0
    private var faltaT1 = 0
    private var asistencia1 = 0
    private var rebotesA1 = 0
    private var rebotesD1 = 0
    private var contra1 = 0
    private var robos1 = 0
    private var perdida1 = 0

    private var puntos2 = 0
    private var tlibreA2 = 0
    private var tlibreT2 = 0
    private var faltaP2 = 0
    private var faltaT2 = 0
    private var asistencia2 = 0
    private var rebotesA2 = 0
    private var rebotesD2 = 0
    private var contra2 = 0
    private var robos2 = 0
    private var perdida2 = 0

    private var puntos3 = 0
    private var tlibreA3 = 0
    private var tlibreT3 = 0
    private var faltaP3 = 0
    private var faltaT3 = 0
    private var asistencia3 = 0
    private var rebotesA3 = 0
    private var rebotesD3 = 0
    private var contra3 = 0
    private var robos3 = 0
    private var perdida3 = 0

    private var puntos4 = 0
    private var tlibreA4 = 0
    private var tlibreT4 = 0
    private var faltaP4 = 0
    private var faltaT4 = 0
    private var asistencia4 = 0
    private var rebotesA4 = 0
    private var rebotesD4 = 0
    private var contra4 = 0
    private var robos4 = 0
    private var perdida4 = 0

    private var puntos5 = 0
    private var tlibreA5 = 0
    private var tlibreT5 = 0
    private var faltaP5 = 0
    private var faltaT5 = 0
    private var asistencia5 = 0
    private var rebotesA5 = 0
    private var rebotesD5 = 0
    private var contra5 = 0
    private var robos5 = 0
    private var perdida5 = 0

    private var isTimerRunning = false
    private var countDownTimer: CountDownTimer? = null
    private val totalSeconds: Long = 0
    private val isTimerRunning1 = false
    private val countDownTimer1: CountDownTimer? = null
    private val totalSeconds1: Long = 0
    private val tiempoInicial = 10 * 60
    private var tiempoRestante = tiempoInicial
    private var tiempoTotalJugado: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.partido)
        db = FirebaseDatabase.getInstance().getReference("Estadisticas")
        db2 = FirebaseDatabase.getInstance().getReference("Partido")

        ml = findViewById(R.id.TV_ML)
        mv = findViewById(R.id.TV_MV)

        jg1 = findViewById(R.id.JG1)
        pt1 = findViewById(R.id.PT1)
        tla1 = findViewById(R.id.TLA1)
        tlt1 = findViewById(R.id.TLT1)
        fpn1 = findViewById(R.id.FPN1)
        fpt1 = findViewById(R.id.FPT1)
        as1 = findViewById(R.id.AS1)
        rba1 = findViewById(R.id.RBA1)
        rbd1 = findViewById(R.id.RBD1)
        ptc1 = findViewById(R.id.PTC1)
        rob1 = findViewById(R.id.ROB1)
        pe1 = findViewById(R.id.PE1)

        jg2 = findViewById(R.id.JG2)
        pt2 = findViewById(R.id.PT2)
        tla2 = findViewById(R.id.TLA2)
        tlt2 = findViewById(R.id.TLT2)
        fpn2 = findViewById(R.id.FPN2)
        fpt2 = findViewById(R.id.FPT2)
        as2 = findViewById(R.id.AS2)
        rba2 = findViewById(R.id.RBA2)
        rbd2 = findViewById(R.id.RBD2)
        ptc2 = findViewById(R.id.PTC2)
        rob2 = findViewById(R.id.ROB2)
        pe2 = findViewById(R.id.PE2)

        jg3 = findViewById(R.id.JG3)
        pt3 = findViewById(R.id.PT3)
        tla3 = findViewById(R.id.TLA3)
        tlt3 = findViewById(R.id.TLT3)
        fpn3 = findViewById(R.id.FPN3)
        fpt3 = findViewById(R.id.FPT3)
        as3 = findViewById(R.id.AS3)
        rba3 = findViewById(R.id.RBA3)
        rbd3 = findViewById(R.id.RBD3)
        ptc3 = findViewById(R.id.PTC3)
        rob3 = findViewById(R.id.ROB3)
        pe3 = findViewById(R.id.PE3)

        jg4 = findViewById(R.id.JG4)
        pt4 = findViewById(R.id.PT4)
        tla4 = findViewById(R.id.TLA4)
        tlt4 = findViewById(R.id.TLT4)
        fpn4 = findViewById(R.id.FPN4)
        fpt4 = findViewById(R.id.FPT4)
        as4 = findViewById(R.id.AS4)
        rba4 = findViewById(R.id.RBA4)
        rbd4 = findViewById(R.id.RBD4)
        ptc4 = findViewById(R.id.PTC4)
        rob4 = findViewById(R.id.ROB4)
        pe4 = findViewById(R.id.PE4)

        jg5 = findViewById(R.id.JG5)
        pt5 = findViewById(R.id.PT5)
        tla5 = findViewById(R.id.TLA5)
        tlt5 = findViewById(R.id.TLT5)
        fpn5 = findViewById(R.id.FPN5)
        fpt5 = findViewById(R.id.FPT5)
        as5 = findViewById(R.id.AS5)
        rba5 = findViewById(R.id.RBA5)
        rbd5 = findViewById(R.id.RBD5)
        ptc5 = findViewById(R.id.PTC5)
        rob5 = findViewById(R.id.ROB5)
        pe5 = findViewById(R.id.PE5)

        btbanquillo = findViewById(R.id.BT_BANQUILLO)
        btfin=findViewById(R.id.fin)

        btpt12 = findViewById(R.id.BT_PT12)
        btpt13 = findViewById(R.id.BT_PT13)
        bttla1 = findViewById(R.id.BT_TLA1)
        bttlt1 = findViewById(R.id.BT_TLT1)
        btfpn1 = findViewById(R.id.BT_FPN1)
        btfpt1 = findViewById(R.id.BT_FPT1)
        btas1 = findViewById(R.id.BT_AS1)
        btrba1 = findViewById(R.id.BT_RBA1)
        btrbd1 = findViewById(R.id.BT_RBD1)
        btptc12 = findViewById(R.id.BT_PTC12)
        btptc13 = findViewById(R.id.BT_PTC13)
        btrob1 = findViewById(R.id.BT_ROB1)
        btpe1 = findViewById(R.id.BT_PE1)

        btpt22 = findViewById(R.id.BT_PT22)
        btpt23 = findViewById(R.id.BT_PT23)
        bttla2 = findViewById(R.id.BT_TLA2)
        bttlt2 = findViewById(R.id.BT_TLT2)
        btfpn2 = findViewById(R.id.BT_FPN2)
        btfpt2 = findViewById(R.id.BT_FPT2)
        btas2 = findViewById(R.id.BT_AS2)
        btrba2 = findViewById(R.id.BT_RBA2)
        btrbd2 = findViewById(R.id.BT_RBD2)
        btptc22 = findViewById(R.id.BT_PTC22)
        btptc23 = findViewById(R.id.BT_PTC23)
        btrob2 = findViewById(R.id.BT_ROB2)
        btpe2 = findViewById(R.id.BT_PE2)

        btpt32 = findViewById(R.id.BT_PT32)
        btpt33 = findViewById(R.id.BT_PT33)
        bttla3 = findViewById(R.id.BT_TLA3)
        bttlt3 = findViewById(R.id.BT_TLT3)
        btfpn3 = findViewById(R.id.BT_FPN3)
        btfpt3 = findViewById(R.id.BT_FPT3)
        btas3 = findViewById(R.id.BT_AS3)
        btrba3 = findViewById(R.id.BT_RBA3)
        btrbd3 = findViewById(R.id.BT_RBD3)
        btptc32 = findViewById(R.id.BT_PTC32)
        btptc33 = findViewById(R.id.BT_PTC33)
        btrob3 = findViewById(R.id.BT_ROB3)
        btpe3 = findViewById(R.id.BT_PE3)

        btpt42 = findViewById(R.id.BT_PT42)
        btpt43 = findViewById(R.id.BT_PT43)
        bttla4 = findViewById(R.id.BT_TLA4)
        bttlt4 = findViewById(R.id.BT_TLT4)
        btfpn4 = findViewById(R.id.BT_FPN4)
        btfpt4 = findViewById(R.id.BT_FPT4)
        btas4 = findViewById(R.id.BT_AS4)
        btrba4 = findViewById(R.id.BT_RBA4)
        btrbd4 = findViewById(R.id.BT_RBD4)
        btptc42 = findViewById(R.id.BT_PTC42)
        btptc43 = findViewById(R.id.BT_PTC43)
        btrob4 = findViewById(R.id.BT_ROB4)
        btpe4 = findViewById(R.id.BT_PE4)

        btpt52 = findViewById(R.id.BT_PT52)
        btpt53 = findViewById(R.id.BT_PT53)
        bttla5 = findViewById(R.id.BT_TLA5)
        bttlt5 = findViewById(R.id.BT_TLT5)
        btfpn5 = findViewById(R.id.BT_FPN5)
        btfpt5 = findViewById(R.id.BT_FPT5)
        btas5 = findViewById(R.id.BT_AS5)
        btrba5 = findViewById(R.id.BT_RBA5)
        btrbd5 = findViewById(R.id.BT_RBD5)
        btptc52 = findViewById(R.id.BT_PTC52)
        btptc53 = findViewById(R.id.BT_PTC53)
        btrob5 = findViewById(R.id.BT_ROB5)
        btpe5 = findViewById(R.id.BT_PE5)

        bt1ptv = findViewById(R.id.BT_1PTV)
        bt2ptv = findViewById(R.id.BT_2PTV)
        bt3ptv = findViewById(R.id.BT_3PTV)

        //Llamamos a las funciones fetchData y fetchPartidoData
        fetchData()
        fetchPartidoData()

        //Guardamos las estadísticas de los jugadores y nos dirigimos a la pestaña de Banquillo
        btbanquillo.setOnClickListener {
            val sharedPreferences = getSharedPreferences("Partido", MODE_PRIVATE)
            val partidoG = sharedPreferences.getString("partido", "")
            val clave = sharedPreferences.getString("clave", "")
            val l = sharedPreferences.getString("local", "")
            val v = sharedPreferences.getString("visitante", "")
            val fecha = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

            val jugador1 = if (jg1.text.isNotEmpty()) jg1.text.toString() else ""
            val puntos1 = if (pt1.text.isNotEmpty()) pt1.text.toString().toInt() else 0
            val tlibreA1 = if (tla1.text.isNotEmpty()) tla1.text.toString().toInt() else 0
            val tlibreT1 = if (tlt1.text.isNotEmpty()) tlt1.text.toString().toInt() else 0
            val faltaP1 = if (fpn1.text.isNotEmpty()) fpn1.text.toString().toInt() else 0
            val faltaT1 = if (fpt1.text.isNotEmpty()) fpt1.text.toString().toInt() else 0
            val asistencia1 = if (as1.text.isNotEmpty()) as1.text.toString().toInt() else 0
            val rebotesA1 = if (rba1.text.isNotEmpty()) rba1.text.toString().toInt() else 0
            val rebotesD1 = if (rbd1.text.isNotEmpty()) rbd1.text.toString().toInt() else 0
            val contra1 = if (ptc1.text.isNotEmpty()) ptc1.text.toString().toInt() else 0
            val robos1 = if (rob1.text.isNotEmpty()) rob1.text.toString().toInt() else 0
            val perdida1 = if (pe1.text.isNotEmpty()) pe1.text.toString().toInt() else 0

            val jugador2 = if (jg2.text.isNotEmpty()) jg2.text.toString() else ""
            val puntos2 = if (pt2.text.isNotEmpty()) pt2.text.toString().toInt() else 0
            val tlibreA2 = if (tla2.text.isNotEmpty()) tla2.text.toString().toInt() else 0
            val tlibreT2 = if (tlt2.text.isNotEmpty()) tlt2.text.toString().toInt() else 0
            val faltaP2 = if (fpn2.text.isNotEmpty()) fpn2.text.toString().toInt() else 0
            val faltaT2 = if (fpt2.text.isNotEmpty()) fpt2.text.toString().toInt() else 0
            val asistencia2 = if (as2.text.isNotEmpty()) as2.text.toString().toInt() else 0
            val rebotesA2 = if (rba2.text.isNotEmpty()) rba2.text.toString().toInt() else 0
            val rebotesD2 = if (rbd2.text.isNotEmpty()) rbd2.text.toString().toInt() else 0
            val contra2 = if (ptc2.text.isNotEmpty()) ptc2.text.toString().toInt() else 0
            val robos2 = if (rob2.text.isNotEmpty()) rob2.text.toString().toInt() else 0
            val perdida2 = if (pe2.text.isNotEmpty()) pe2.text.toString().toInt() else 0

            val jugador3 = if (jg3.text.isNotEmpty()) jg3.text.toString() else ""
            val puntos3 = if (pt3.text.isNotEmpty()) pt3.text.toString().toInt() else 0
            val tlibreA3 = if (tla3.text.isNotEmpty()) tla3.text.toString().toInt() else 0
            val tlibreT3 = if (tlt3.text.isNotEmpty()) tlt3.text.toString().toInt() else 0
            val faltaP3 = if (fpn3.text.isNotEmpty()) fpn3.text.toString().toInt() else 0
            val faltaT3 = if (fpt3.text.isNotEmpty()) fpt3.text.toString().toInt() else 0
            val asistencia3 = if (as3.text.isNotEmpty()) as3.text.toString().toInt() else 0
            val rebotesA3 = if (rba3.text.isNotEmpty()) rba3.text.toString().toInt() else 0
            val rebotesD3 = if (rbd3.text.isNotEmpty()) rbd3.text.toString().toInt() else 0
            val contra3 = if (ptc3.text.isNotEmpty()) ptc3.text.toString().toInt() else 0
            val robos3 = if (rob3.text.isNotEmpty()) rob3.text.toString().toInt() else 0
            val perdida3 = if (pe3.text.isNotEmpty()) pe3.text.toString().toInt() else 0

            val jugador4 = if (jg4.text.isNotEmpty()) jg4.text.toString() else ""
            val puntos4 = if (pt4.text.isNotEmpty()) pt4.text.toString().toInt() else 0
            val tlibreA4 = if (tla4.text.isNotEmpty()) tla4.text.toString().toInt() else 0
            val tlibreT4 = if (tlt4.text.isNotEmpty()) tlt4.text.toString().toInt() else 0
            val faltaP4 = if (fpn4.text.isNotEmpty()) fpn4.text.toString().toInt() else 0
            val faltaT4 = if (fpt4.text.isNotEmpty()) fpt4.text.toString().toInt() else 0
            val asistencia4 = if (as4.text.isNotEmpty()) as4.text.toString().toInt() else 0
            val rebotesA4 = if (rba4.text.isNotEmpty()) rba4.text.toString().toInt() else 0
            val rebotesD4 = if (rbd4.text.isNotEmpty()) rbd4.text.toString().toInt() else 0
            val contra4 = if (ptc4.text.isNotEmpty()) ptc4.text.toString().toInt() else 0
            val robos4 = if (rob4.text.isNotEmpty()) rob4.text.toString().toInt() else 0
            val perdida4 = if (pe4.text.isNotEmpty()) pe4.text.toString().toInt() else 0

            val jugador5 = if (jg5.text.isNotEmpty()) jg5.text.toString() else ""
            val puntos5 = if (pt5.text.isNotEmpty()) pt5.text.toString().toInt() else 0
            val tlibreA5 = if (tla5.text.isNotEmpty()) tla5.text.toString().toInt() else 0
            val tlibreT5 = if (tlt5.text.isNotEmpty()) tlt5.text.toString().toInt() else 0
            val faltaP5 = if (fpn5.text.isNotEmpty()) fpn5.text.toString().toInt() else 0
            val faltaT5 = if (fpt5.text.isNotEmpty()) fpt5.text.toString().toInt() else 0
            val asistencia5 = if (as5.text.isNotEmpty()) as5.text.toString().toInt() else 0
            val rebotesA5 = if (rba5.text.isNotEmpty()) rba5.text.toString().toInt() else 0
            val rebotesD5 = if (rbd5.text.isNotEmpty()) rbd5.text.toString().toInt() else 0
            val contra5 = if (ptc5.text.isNotEmpty()) ptc5.text.toString().toInt() else 0
            val robos5 = if (rob5.text.isNotEmpty()) rob5.text.toString().toInt() else 0
            val perdida5 = if (pe5.text.isNotEmpty()) pe5.text.toString().toInt() else 0

            val marcadorL = ml.text.toString().toIntOrNull() ?: 0
            val marcadorV = mv.text.toString().toIntOrNull() ?: 0

            val stats = EstadisticasDB(
                jugador1,
                puntos1,
                tlibreA1,
                tlibreT1,
                faltaP1,
                faltaT1,
                asistencia1,
                rebotesA1,
                rebotesD1,
                contra1,
                robos1,
                perdida1,
                partidoG,
                fecha
            )
            val stats2 = EstadisticasDB(
                jugador2,
                puntos2,
                tlibreA2,
                tlibreT2,
                faltaP2,
                faltaT2,
                asistencia2,
                rebotesA2,
                rebotesD2,
                contra2,
                robos2,
                perdida2,
                partidoG,
                fecha
            )
            val stats3 = EstadisticasDB(
                jugador3,
                puntos3,
                tlibreA3,
                tlibreT3,
                faltaP3,
                faltaT3,
                asistencia3,
                rebotesA3,
                rebotesD3,
                contra3,
                robos3,
                perdida3,
                partidoG,
                fecha
            )
            val stats4 = EstadisticasDB(
                jugador4,
                puntos4,
                tlibreA4,
                tlibreT4,
                faltaP4,
                faltaT4,
                asistencia4,
                rebotesA4,
                rebotesD4,
                contra4,
                robos4,
                perdida4,
                partidoG,
                fecha
            )
            val stats5 = EstadisticasDB(
                jugador5,
                puntos5,
                tlibreA5,
                tlibreT5,
                faltaP5,
                faltaT5,
                asistencia5,
                rebotesA5,
                rebotesD5,
                contra5,
                robos5,
                perdida5,
                partidoG,
                fecha
            )
            val statsPartido = PartidoDB(l, v, marcadorL, marcadorV)

            db.child(jg1.text.toString() + " " + partidoG + " " + fecha).setValue(stats)
            db.child(jg2.text.toString() + " " + partidoG + " " + fecha).setValue(stats2)
            db.child(jg3.text.toString() + " " + partidoG + " " + fecha).setValue(stats3)
            db.child(jg4.text.toString() + " " + partidoG + " " + fecha).setValue(stats4)
            db.child(jg5.text.toString() + " " + partidoG + " " + fecha).setValue(stats5)
            if (clave != null) {
                db2.child(clave).setValue(statsPartido)
            }
            val intent = Intent(this, Banquillo::class.java)
            startActivity(intent)
        }

        //De la misma manera que en banquillo guardamos las estadísticas y nos dirigimos a Fin
        btfin.setOnClickListener {
            val sharedPreferences = getSharedPreferences("Partido", MODE_PRIVATE)
            val partidoG = sharedPreferences.getString("partido", "")
            val clave = sharedPreferences.getString("clave", "")
            val l = sharedPreferences.getString("local", "")
            val v = sharedPreferences.getString("visitante", "")
            val fecha = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

            val jugador1 = if (jg1.text.isNotEmpty()) jg1.text.toString() else ""
            val puntos1 = if (pt1.text.isNotEmpty()) pt1.text.toString().toInt() else 0
            val tlibreA1 = if (tla1.text.isNotEmpty()) tla1.text.toString().toInt() else 0
            val tlibreT1 = if (tlt1.text.isNotEmpty()) tlt1.text.toString().toInt() else 0
            val faltaP1 = if (fpn1.text.isNotEmpty()) fpn1.text.toString().toInt() else 0
            val faltaT1 = if (fpt1.text.isNotEmpty()) fpt1.text.toString().toInt() else 0
            val asistencia1 = if (as1.text.isNotEmpty()) as1.text.toString().toInt() else 0
            val rebotesA1 = if (rba1.text.isNotEmpty()) rba1.text.toString().toInt() else 0
            val rebotesD1 = if (rbd1.text.isNotEmpty()) rbd1.text.toString().toInt() else 0
            val contra1 = if (ptc1.text.isNotEmpty()) ptc1.text.toString().toInt() else 0
            val robos1 = if (rob1.text.isNotEmpty()) rob1.text.toString().toInt() else 0
            val perdida1 = if (pe1.text.isNotEmpty()) pe1.text.toString().toInt() else 0

            val jugador2 = if (jg2.text.isNotEmpty()) jg2.text.toString() else ""
            val puntos2 = if (pt2.text.isNotEmpty()) pt2.text.toString().toInt() else 0
            val tlibreA2 = if (tla2.text.isNotEmpty()) tla2.text.toString().toInt() else 0
            val tlibreT2 = if (tlt2.text.isNotEmpty()) tlt2.text.toString().toInt() else 0
            val faltaP2 = if (fpn2.text.isNotEmpty()) fpn2.text.toString().toInt() else 0
            val faltaT2 = if (fpt2.text.isNotEmpty()) fpt2.text.toString().toInt() else 0
            val asistencia2 = if (as2.text.isNotEmpty()) as2.text.toString().toInt() else 0
            val rebotesA2 = if (rba2.text.isNotEmpty()) rba2.text.toString().toInt() else 0
            val rebotesD2 = if (rbd2.text.isNotEmpty()) rbd2.text.toString().toInt() else 0
            val contra2 = if (ptc2.text.isNotEmpty()) ptc2.text.toString().toInt() else 0
            val robos2 = if (rob2.text.isNotEmpty()) rob2.text.toString().toInt() else 0
            val perdida2 = if (pe2.text.isNotEmpty()) pe2.text.toString().toInt() else 0

            val jugador3 = if (jg3.text.isNotEmpty()) jg3.text.toString() else ""
            val puntos3 = if (pt3.text.isNotEmpty()) pt3.text.toString().toInt() else 0
            val tlibreA3 = if (tla3.text.isNotEmpty()) tla3.text.toString().toInt() else 0
            val tlibreT3 = if (tlt3.text.isNotEmpty()) tlt3.text.toString().toInt() else 0
            val faltaP3 = if (fpn3.text.isNotEmpty()) fpn3.text.toString().toInt() else 0
            val faltaT3 = if (fpt3.text.isNotEmpty()) fpt3.text.toString().toInt() else 0
            val asistencia3 = if (as3.text.isNotEmpty()) as3.text.toString().toInt() else 0
            val rebotesA3 = if (rba3.text.isNotEmpty()) rba3.text.toString().toInt() else 0
            val rebotesD3 = if (rbd3.text.isNotEmpty()) rbd3.text.toString().toInt() else 0
            val contra3 = if (ptc3.text.isNotEmpty()) ptc3.text.toString().toInt() else 0
            val robos3 = if (rob3.text.isNotEmpty()) rob3.text.toString().toInt() else 0
            val perdida3 = if (pe3.text.isNotEmpty()) pe3.text.toString().toInt() else 0

            val jugador4 = if (jg4.text.isNotEmpty()) jg4.text.toString() else ""
            val puntos4 = if (pt4.text.isNotEmpty()) pt4.text.toString().toInt() else 0
            val tlibreA4 = if (tla4.text.isNotEmpty()) tla4.text.toString().toInt() else 0
            val tlibreT4 = if (tlt4.text.isNotEmpty()) tlt4.text.toString().toInt() else 0
            val faltaP4 = if (fpn4.text.isNotEmpty()) fpn4.text.toString().toInt() else 0
            val faltaT4 = if (fpt4.text.isNotEmpty()) fpt4.text.toString().toInt() else 0
            val asistencia4 = if (as4.text.isNotEmpty()) as4.text.toString().toInt() else 0
            val rebotesA4 = if (rba4.text.isNotEmpty()) rba4.text.toString().toInt() else 0
            val rebotesD4 = if (rbd4.text.isNotEmpty()) rbd4.text.toString().toInt() else 0
            val contra4 = if (ptc4.text.isNotEmpty()) ptc4.text.toString().toInt() else 0
            val robos4 = if (rob4.text.isNotEmpty()) rob4.text.toString().toInt() else 0
            val perdida4 = if (pe4.text.isNotEmpty()) pe4.text.toString().toInt() else 0

            val jugador5 = if (jg5.text.isNotEmpty()) jg5.text.toString() else ""
            val puntos5 = if (pt5.text.isNotEmpty()) pt5.text.toString().toInt() else 0
            val tlibreA5 = if (tla5.text.isNotEmpty()) tla5.text.toString().toInt() else 0
            val tlibreT5 = if (tlt5.text.isNotEmpty()) tlt5.text.toString().toInt() else 0
            val faltaP5 = if (fpn5.text.isNotEmpty()) fpn5.text.toString().toInt() else 0
            val faltaT5 = if (fpt5.text.isNotEmpty()) fpt5.text.toString().toInt() else 0
            val asistencia5 = if (as5.text.isNotEmpty()) as5.text.toString().toInt() else 0
            val rebotesA5 = if (rba5.text.isNotEmpty()) rba5.text.toString().toInt() else 0
            val rebotesD5 = if (rbd5.text.isNotEmpty()) rbd5.text.toString().toInt() else 0
            val contra5 = if (ptc5.text.isNotEmpty()) ptc5.text.toString().toInt() else 0
            val robos5 = if (rob5.text.isNotEmpty()) rob5.text.toString().toInt() else 0
            val perdida5 = if (pe5.text.isNotEmpty()) pe5.text.toString().toInt() else 0

            val marcadorL = ml.text.toString().toIntOrNull() ?: 0
            val marcadorV = mv.text.toString().toIntOrNull() ?: 0

            val stats = EstadisticasDB(
                jugador1,
                puntos1,
                tlibreA1,
                tlibreT1,
                faltaP1,
                faltaT1,
                asistencia1,
                rebotesA1,
                rebotesD1,
                contra1,
                robos1,
                perdida1,
                partidoG,
                fecha
            )
            val stats2 = EstadisticasDB(
                jugador2,
                puntos2,
                tlibreA2,
                tlibreT2,
                faltaP2,
                faltaT2,
                asistencia2,
                rebotesA2,
                rebotesD2,
                contra2,
                robos2,
                perdida2,
                partidoG,
                fecha
            )
            val stats3 = EstadisticasDB(
                jugador3,
                puntos3,
                tlibreA3,
                tlibreT3,
                faltaP3,
                faltaT3,
                asistencia3,
                rebotesA3,
                rebotesD3,
                contra3,
                robos3,
                perdida3,
                partidoG,
                fecha
            )
            val stats4 = EstadisticasDB(
                jugador4,
                puntos4,
                tlibreA4,
                tlibreT4,
                faltaP4,
                faltaT4,
                asistencia4,
                rebotesA4,
                rebotesD4,
                contra4,
                robos4,
                perdida4,
                partidoG,
                fecha
            )
            val stats5 = EstadisticasDB(
                jugador5,
                puntos5,
                tlibreA5,
                tlibreT5,
                faltaP5,
                faltaT5,
                asistencia5,
                rebotesA5,
                rebotesD5,
                contra5,
                robos5,
                perdida5,
                partidoG,
                fecha
            )
            val statsPartido = PartidoDB(l, v, marcadorL, marcadorV)

            db.child(jg1.text.toString() + " " + partidoG + " " + fecha).setValue(stats)
            db.child(jg2.text.toString() + " " + partidoG + " " + fecha).setValue(stats2)
            db.child(jg3.text.toString() + " " + partidoG + " " + fecha).setValue(stats3)
            db.child(jg4.text.toString() + " " + partidoG + " " + fecha).setValue(stats4)
            db.child(jg5.text.toString() + " " + partidoG + " " + fecha).setValue(stats5)
            if (clave != null) {
                db2.child(clave).setValue(statsPartido)
            }
            val intent = Intent(this, Fin::class.java)
            startActivity(intent)
        }

        /*Contador de puntos Equipo Visitante*/
        bt1ptv.setOnClickListener {
            val currentVisitante = mv.text.toString()
            val visitanteDB = currentVisitante.toInt()
            puntosV = 1 + visitanteDB
            mv.setText(puntosV.toString())

        }
        bt2ptv.setOnClickListener {
            val currentVisitante = mv.text.toString()
            val visitanteDB = currentVisitante.toInt()
            puntosV = 2 + visitanteDB
            mv.setText(puntosV.toString())
        }
        bt3ptv.setOnClickListener {
            val currentVisitante = mv.text.toString()
            val visitanteDB = currentVisitante.toInt()
            puntosV = 3 + visitanteDB
            mv.setText(puntosV.toString())
        }

        //Controlamos las estadísticas de los juagdores mediante los botones
        /*JUGADOR 1*/
        btpt12.setOnClickListener {
            val currentPuntos = pt1.text.toString()
            val currentLocal = ml.text.toString()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            puntos1 = 2 + puntosDB
            puntosL = 2 + localDB
            pt1.setText(puntos1.toString())
            ml.setText(puntosL.toString())
        }
        btpt13.setOnClickListener {
            val currentPuntos = pt1.text.toString()
            val currentLocal = ml.text.toString()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            puntos1 = 3 + puntosDB
            puntosL = 3 + localDB
            pt1.setText(puntos1.toString())
            ml.setText(puntosL.toString())
        }
        bttla1.setOnClickListener {
            val currentTLA = tla1.text.toString()
            val currentTLT = tlt1.text.toString()
            val currentPuntos = pt1.text.toString()
            val currentLocal = ml.text.toString()
            val tlaDB = currentTLA.toInt()
            val tltDB = currentTLT.toInt()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            tlibreA1 = 1 + tlaDB
            tlibreT1 = 1 + tltDB
            puntos1 = 1 + puntosDB
            puntosL = 1 + localDB
            tla1.setText(tlibreA1.toString())
            tlt1.setText(tlibreT1.toString())
            pt1.setText(puntos1.toString())
            ml.setText(puntosL.toString())
        }
        bttlt1.setOnClickListener {
            val currentTLT = tlt1.text.toString()
            val tltDB = currentTLT.toInt()
            tlibreT1 = 1 + tltDB
            tlt1.setText(tlibreT1.toString())
        }
        btfpn1.setOnClickListener {
            val currentFPN = fpn1.text.toString()
            val fpnDB = currentFPN.toInt()
            faltaP1 = 1 + fpnDB
            if (faltaP1 >= 5) {
                /*stopTimer1();*/
                faltaP1 = 5
                jg1.setTextColor(Color.RED)
                pt1.setTextColor(Color.RED)
                tla1.setTextColor(Color.RED)
                tlt1.setTextColor(Color.RED)
                fpn1.setTextColor(Color.RED)
                fpt1.setTextColor(Color.RED)
                as1.setTextColor(Color.RED)
                rba1.setTextColor(Color.RED)
                rbd1.setTextColor(Color.RED)
                ptc1.setTextColor(Color.RED)
                rob1.setTextColor(Color.RED)
                pe1.setTextColor(Color.RED)
                btpt12.setEnabled(false)
                btpt13.setEnabled(false)
                bttla1.setEnabled(false)
                bttlt1.setEnabled(false)
                btfpn1.setEnabled(false)
                btfpt1.setEnabled(false)
                btas1.setEnabled(false)
                btrba1.setEnabled(false)
                btrbd1.setEnabled(false)
                btptc12.setEnabled(false)
                btptc13.setEnabled(false)
                btrob1.setEnabled(false)
                btpe1.setEnabled(false)
            }
            fpn1.setText(faltaP1.toString())
        }
        btfpt1.setOnClickListener {
            val currentFPT = fpt1.text.toString()
            val currentFPN = fpn1.text.toString()
            val fptDB = currentFPT.toInt()
            val fpnDB = currentFPN.toInt()
            faltaT1 = 1 + fptDB
            faltaP1 = 1 + fpnDB
            if (faltaT1 >= 2) {
                /*stopTimer1();*/
                faltaT1 = 2
                jg1.setTextColor(Color.RED)
                pt1.setTextColor(Color.RED)
                tla1.setTextColor(Color.RED)
                tlt1.setTextColor(Color.RED)
                fpn1.setTextColor(Color.RED)
                fpt1.setTextColor(Color.RED)
                as1.setTextColor(Color.RED)
                rba1.setTextColor(Color.RED)
                rbd1.setTextColor(Color.RED)
                ptc1.setTextColor(Color.RED)
                rob1.setTextColor(Color.RED)
                pe1.setTextColor(Color.RED)
                btpt12.setEnabled(false)
                btpt13.setEnabled(false)
                bttla1.setEnabled(false)
                bttlt1.setEnabled(false)
                btfpn1.setEnabled(false)
                btfpt1.setEnabled(false)
                btas1.setEnabled(false)
                btrba1.setEnabled(false)
                btrbd1.setEnabled(false)
                btptc12.setEnabled(false)
                btptc13.setEnabled(false)
                btrob1.setEnabled(false)
                btpe1.setEnabled(false)
            }
            fpn1.setText(faltaP1.toString())
            fpt1.setText(faltaT1.toString())
        }
        btas1.setOnClickListener {
            val currentAsistencias = as1.text.toString()
            val asistenciasDB = currentAsistencias.toInt()
            asistencia1 = 1 + asistenciasDB
            as1.setText(asistencia1.toString())
        }
        btrba1.setOnClickListener {
            val currentRebotesA = rba1.text.toString()
            val rebotesADB = currentRebotesA.toInt()
            rebotesA1 = 1 + rebotesADB
            rba1.setText(rebotesA1.toString())
        }
        btrbd1.setOnClickListener {
            val currentRebotesD = rbd1.text.toString()
            val rebotesDDB = currentRebotesD.toInt()
            rebotesD1 = 1 + rebotesDDB
            rbd1.setText(rebotesD1.toString())
        }
        btptc12.setOnClickListener {
            val currentContra = ptc1.text.toString()
            val currentPuntos = pt1.text.toString()
            val currentLocal = ml.text.toString()
            val contraDB = currentContra.toInt()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            contra1 = 1 + contraDB
            puntos1 = 2 + puntosDB
            puntosL = 2 + localDB
            ptc1.setText(contra1.toString())
            pt1.setText(puntos1.toString())
            ml.setText(puntosL.toString())
        }
        btptc13.setOnClickListener {
            val currentContra = ptc1.text.toString()
            val currentPuntos = pt1.text.toString()
            val currentLocal = ml.text.toString()
            val contraDB = currentContra.toInt()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            contra1 = 1 + contraDB
            puntos1 = 3 + puntosDB
            puntosL = 3 + localDB
            ptc1.setText(contra1.toString())
            pt1.setText(puntos1.toString())
            ml.setText(puntosL.toString())
        }
        btrob1.setOnClickListener {
            val currentRobos = rob1.text.toString()
            val robosDB = currentRobos.toInt()
            robos1 = 1 + robosDB
            rob1.setText(robos1.toString())
        }
        btpe1.setOnClickListener {
            val currentPerdida = pe1.text.toString()
            val perdidaDB = currentPerdida.toInt()
            perdida1 = 1 + perdidaDB
            pe1.setText(perdida1.toString())
        }

        /*JUGADOR 2*/
        btpt22.setOnClickListener {
            val currentPuntos = pt2.text.toString()
            val puntosDB = currentPuntos.toInt()
            val currentLocal = ml.text.toString()
            val localDB = currentLocal.toInt()
            puntos2 = 2 + puntosDB
            puntosL = 2 + localDB
            pt2.setText(puntos2.toString())
            ml.setText(puntosL.toString())
        }
        btpt23.setOnClickListener {
            val currentPuntos = pt2.text.toString()
            val puntosDB = currentPuntos.toInt()
            val currentLocal = ml.text.toString()
            val localDB = currentLocal.toInt()
            puntos2 = 3 + puntosDB
            puntosL = 3 + localDB
            pt2.setText(puntos2.toString())
            ml.setText(puntosL.toString())
        }
        bttla2.setOnClickListener {
            val currentTLA = tla2.text.toString()
            val currentTLT = tlt2.text.toString()
            val currentPuntos = pt2.text.toString()
            val tlaDB = currentTLA.toInt()
            val tltDB = currentTLT.toInt()
            val puntosDB = currentPuntos.toInt()
            tlibreA2 = 1 + tlaDB
            tlibreT2 = 1 + tltDB
            puntos2 = 1 + puntosDB
            puntosL += 1
            tla2.setText(tlibreA2.toString())
            tlt2.setText(tlibreT2.toString())
            pt2.setText(puntos2.toString())
            ml.setText(puntosL.toString())
        }
        bttlt2.setOnClickListener {
            val currentTLT = tlt2.text.toString()
            val tltDB = currentTLT.toInt()
            tlibreT2 = 1 + tltDB
            tlt2.setText(tlibreT2.toString())
        }
        btfpn2.setOnClickListener {
            val currentFPN = fpn2.text.toString()
            val fpnDB = currentFPN.toInt()
            faltaP2 = 1 + fpnDB
            if (faltaP2 >= 5) {
                faltaP2 = 5
                jg2.setTextColor(Color.RED)
                pt2.setTextColor(Color.RED)
                tla2.setTextColor(Color.RED)
                tlt2.setTextColor(Color.RED)
                fpn2.setTextColor(Color.RED)
                fpt2.setTextColor(Color.RED)
                as2.setTextColor(Color.RED)
                rba2.setTextColor(Color.RED)
                rbd2.setTextColor(Color.RED)
                ptc2.setTextColor(Color.RED)
                rob2.setTextColor(Color.RED)
                pe2.setTextColor(Color.RED)
                btpt22.setEnabled(false)
                btpt23.setEnabled(false)
                bttla2.setEnabled(false)
                bttlt2.setEnabled(false)
                btfpn2.setEnabled(false)
                btfpt2.setEnabled(false)
                btas2.setEnabled(false)
                btrba2.setEnabled(false)
                btrbd2.setEnabled(false)
                btptc22.setEnabled(false)
                btptc23.setEnabled(false)
                btrob2.setEnabled(false)
                btpe2.setEnabled(false)
            }
            fpn2.setText(faltaP2.toString())
        }
        btfpt2.setOnClickListener {
            val currentFPT = fpt2.text.toString()
            val currentFPN = fpn2.text.toString()
            val fptDB = currentFPT.toInt()
            val fpnDB = currentFPN.toInt()
            faltaT2 = 1 + fptDB
            faltaP2 = 1 + fpnDB
            if (faltaT2 >= 2) {

                faltaT2 = 2
                jg2.setTextColor(Color.RED)
                pt2.setTextColor(Color.RED)
                tla2.setTextColor(Color.RED)
                tlt2.setTextColor(Color.RED)
                fpn2.setTextColor(Color.RED)
                fpt2.setTextColor(Color.RED)
                as2.setTextColor(Color.RED)
                rba2.setTextColor(Color.RED)
                rbd2.setTextColor(Color.RED)
                ptc2.setTextColor(Color.RED)
                rob2.setTextColor(Color.RED)
                pe2.setTextColor(Color.RED)
                btpt22.setEnabled(false)
                btpt23.setEnabled(false)
                bttla2.setEnabled(false)
                bttlt2.setEnabled(false)
                btfpn2.setEnabled(false)
                btfpt2.setEnabled(false)
                btas2.setEnabled(false)
                btrba2.setEnabled(false)
                btrbd2.setEnabled(false)
                btptc22.setEnabled(false)
                btptc23.setEnabled(false)
                btrob2.setEnabled(false)
                btpe2.setEnabled(false)
            }
            fpn2.setText(faltaP2.toString())
            fpt2.setText(faltaT2.toString())
        }
        btas2.setOnClickListener {
            val currentAsistencias = as2.text.toString()
            val asistenciasDB = currentAsistencias.toInt()
            asistencia2 = 1 + asistenciasDB
            as2.setText(asistencia2.toString())
        }
        btrba2.setOnClickListener {
            val currentRebotesA = rba2.text.toString()
            val rebotesADB = currentRebotesA.toInt()
            rebotesA2 = 1 + rebotesADB
            rba2.setText(rebotesA2.toString())
        }
        btrbd2.setOnClickListener {
            val currentRebotesD = rbd2.text.toString()
            val rebotesDDB = currentRebotesD.toInt()
            rebotesD2 = 1 + rebotesDDB
            rbd2.setText(rebotesD2.toString())
        }
        btptc22.setOnClickListener {
            val currentContra = ptc2.text.toString()
            val currentPuntos = pt2.text.toString()
            val currentLocal = ml.text.toString()
            val contraDB = currentContra.toInt()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            contra2 = 1 + contraDB
            puntos2 = 2 + puntosDB
            puntosL = 2 + localDB
            ptc2.setText(contra2.toString())
            pt2.setText(puntos2.toString())
            ml.setText(puntosL.toString())
        }
        btptc23.setOnClickListener {
            val currentContra = ptc2.text.toString()
            val currentPuntos = pt2.text.toString()
            val currentLocal = ml.text.toString()
            val contraDB = currentContra.toInt()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            contra2 = 1 + contraDB
            puntos2 = 3 + puntosDB
            puntosL = 3 + localDB
            ptc2.setText(contra2.toString())
            pt2.setText(puntos2.toString())
            ml.setText(puntosL.toString())
        }
        btrob2.setOnClickListener {
            val currentRobos = rob2.text.toString()
            val robosDB = currentRobos.toInt()
            robos2 = 1 + robosDB
            rob2.setText(robos2.toString())
        }
        btpe2.setOnClickListener {
            val currentPerdida = pe2.text.toString()
            val perdidaDB = currentPerdida.toInt()
            perdida2 = 1 + perdidaDB
            pe2.setText(perdida2.toString())
        }

        /*JUGADOR 3*/
        btpt32.setOnClickListener {
            val currentPuntos = pt3.text.toString()
            val currentLocal = ml.text.toString()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            puntos3 = 2 + puntosDB
            puntosL = 2 + localDB
            pt3.setText(puntos3.toString())
            ml.setText(puntosL.toString())
        }
        btpt33.setOnClickListener {
            val currentPuntos = pt3.text.toString()
            val currentLocal = ml.text.toString()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            puntos3 = 3 + puntosDB
            puntosL = 3 + localDB
            pt3.setText(puntos3.toString())
            ml.setText(puntosL.toString())
        }
        bttla3.setOnClickListener {
            val currentTLA = tla3.text.toString()
            val currentTLT = tlt3.text.toString()
            val currentPuntos = pt3.text.toString()
            val currentLocal = ml.text.toString()
            val tlaDB = currentTLA.toInt()
            val tltDB = currentTLT.toInt()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            tlibreA3 = 1 + tlaDB
            tlibreT3 = 1 + tltDB
            puntos3 = 1 + puntosDB
            puntosL = 1 + localDB
            tla3.setText(tlibreA3.toString())
            tlt3.setText(tlibreT3.toString())
            pt3.setText(puntos3.toString())
            ml.setText(puntosL.toString())
        }
        bttlt3.setOnClickListener {
            val currentTLT = tlt3.text.toString()
            val tltDB = currentTLT.toInt()
            tlibreT3 = 1 + tltDB
            tlt3.setText(tlibreT3.toString())
        }
        btfpn3.setOnClickListener {
            val currentFPN = fpn3.text.toString()
            val fpnDB = currentFPN.toInt()
            faltaP3 = 1 + fpnDB
            if (faltaP3 >= 5) {
                /*stopTimer1();*/
                faltaP3 = 5
                jg3.setTextColor(Color.RED)
                pt3.setTextColor(Color.RED)
                tla3.setTextColor(Color.RED)
                tlt3.setTextColor(Color.RED)
                fpn3.setTextColor(Color.RED)
                fpt3.setTextColor(Color.RED)
                as3.setTextColor(Color.RED)
                rba3.setTextColor(Color.RED)
                rbd3.setTextColor(Color.RED)
                ptc3.setTextColor(Color.RED)
                rob3.setTextColor(Color.RED)
                pe3.setTextColor(Color.RED)
                btpt32.setEnabled(false)
                btpt33.setEnabled(false)
                bttla3.setEnabled(false)
                bttlt3.setEnabled(false)
                btfpn3.setEnabled(false)
                btfpt3.setEnabled(false)
                btas3.setEnabled(false)
                btrba3.setEnabled(false)
                btrbd3.setEnabled(false)
                btptc32.setEnabled(false)
                btptc33.setEnabled(false)
                btrob3.setEnabled(false)
                btpe3.setEnabled(false)
            }
            fpn3.setText(faltaP3.toString())
        }
        btfpt3.setOnClickListener {
            val currentFPT = fpt3.text.toString()
            val currentFPN = fpn3.text.toString()
            val fptDB = currentFPT.toInt()
            val fpnDB = currentFPN.toInt()
            faltaT3 = 1 + fptDB
            faltaP3 = 1 + fpnDB
            if (faltaT3 >= 2) {
                /*stopTimer1();*/
                faltaT3 = 2
                jg3.setTextColor(Color.RED)
                pt3.setTextColor(Color.RED)
                tla3.setTextColor(Color.RED)
                tlt3.setTextColor(Color.RED)
                fpn3.setTextColor(Color.RED)
                fpt3.setTextColor(Color.RED)
                as3.setTextColor(Color.RED)
                rba3.setTextColor(Color.RED)
                rbd3.setTextColor(Color.RED)
                ptc3.setTextColor(Color.RED)
                rob3.setTextColor(Color.RED)
                pe3.setTextColor(Color.RED)
                btpt32.setEnabled(false)
                btpt33.setEnabled(false)
                bttla3.setEnabled(false)
                bttlt3.setEnabled(false)
                btfpn3.setEnabled(false)
                btfpt3.setEnabled(false)
                btas3.setEnabled(false)
                btrba3.setEnabled(false)
                btrbd3.setEnabled(false)
                btptc32.setEnabled(false)
                btptc33.setEnabled(false)
                btrob3.setEnabled(false)
                btpe3.setEnabled(false)
            }
            fpn3.setText(faltaP3.toString())
            fpt3.setText(faltaT3.toString())
        }
        btas3.setOnClickListener {
            val currentAsistencias = as3.text.toString()
            val asistenciasDB = currentAsistencias.toInt()
            asistencia3 = 1 + asistenciasDB
            as3.setText(asistencia3.toString())
        }
        btrba3.setOnClickListener {
            val currentRebotesA = rba3.text.toString()
            val rebotesADB = currentRebotesA.toInt()
            rebotesA3 = 1 + rebotesADB
            rba3.setText(rebotesA3.toString())
        }
        btrbd3.setOnClickListener {
            val currentRebotesD = rbd3.text.toString()
            val rebotesDDB = currentRebotesD.toInt()
            rebotesD3 = 1 + rebotesDDB
            rbd3.setText(rebotesD3.toString())
        }
        btptc32.setOnClickListener {
            val currentContra = ptc3.text.toString()
            val currentPuntos = pt3.text.toString()
            val currentLocal = ml.text.toString()
            val contraDB = currentContra.toInt()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            contra3 = 1 + contraDB
            puntos3 = 2 + puntosDB
            puntosL = 2 + localDB
            ptc3.setText(contra3.toString())
            pt3.setText(puntos3.toString())
            ml.setText(puntosL.toString())
        }
        btptc33.setOnClickListener {
            val currentContra = ptc3.text.toString()
            val currentPuntos = pt3.text.toString()
            val currentLocal = ml.text.toString()
            val contraDB = currentContra.toInt()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            contra3 = 1 + contraDB
            puntos3 = 3 + puntosDB
            puntosL = 3 + localDB
            ptc3.setText(contra3.toString())
            pt3.setText(puntos3.toString())
            ml.setText(puntosL.toString())
        }
        btrob3.setOnClickListener {
            val currentRobos = rob3.text.toString()
            val robosDB = currentRobos.toInt()
            robos3 = 1 + robosDB
            rob3.setText(robos3.toString())
        }
        btpe3.setOnClickListener {
            val currentPerdida = pe3.text.toString()
            val perdidaDB = currentPerdida.toInt()
            perdida3 = 1 + perdidaDB
            pe3.setText(perdida3.toString())
        }

        /*JUGADOR 4*/
        btpt42.setOnClickListener {
            val currentPuntos = pt4.text.toString()
            val currentLocal = ml.text.toString()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            puntos4 = 2 + puntosDB
            puntosL = 2 + localDB
            pt4.setText(puntos4.toString())
            ml.setText(puntosL.toString())
        }
        btpt43.setOnClickListener {
            val currentPuntos = pt4.text.toString()
            val currentLocal = ml.text.toString()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            puntos4 = 3 + puntosDB
            puntosL = 3 + localDB
            pt4.setText(puntos4.toString())
            ml.setText(puntosL.toString())
        }
        bttla4.setOnClickListener {
            val currentTLA = tla4.text.toString()
            val currentTLT = tlt4.text.toString()
            val currentPuntos = pt4.text.toString()
            val currentLocal = ml.text.toString()
            val tlaDB = currentTLA.toInt()
            val tltDB = currentTLT.toInt()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            tlibreA4 = 1 + tlaDB
            tlibreT4 = 1 + tltDB
            puntos4 = 1 + puntosDB
            puntosL = 1 + localDB
            tla4.setText(tlibreA4.toString())
            tlt4.setText(tlibreT4.toString())
            pt4.setText(puntos4.toString())
            ml.setText(puntosL.toString())
        }
        bttlt4.setOnClickListener {
            val currentTLT = tlt4.text.toString()
            val tltDB = currentTLT.toInt()
            tlibreT4 = 1 + tltDB
            tlt4.setText(tlibreT4.toString())
        }
        btfpn4.setOnClickListener {
            val currentFPN = fpn4.text.toString()
            val fpnDB = currentFPN.toInt()
            faltaP4 = 1 + fpnDB
            if (faltaP4 >= 5) {
                /*stopTimer1();*/
                faltaP4 = 5
                jg4.setTextColor(Color.RED)
                pt4.setTextColor(Color.RED)
                tla4.setTextColor(Color.RED)
                tlt4.setTextColor(Color.RED)
                fpn4.setTextColor(Color.RED)
                fpt4.setTextColor(Color.RED)
                as4.setTextColor(Color.RED)
                rba4.setTextColor(Color.RED)
                rbd4.setTextColor(Color.RED)
                ptc4.setTextColor(Color.RED)
                rob4.setTextColor(Color.RED)
                pe4.setTextColor(Color.RED)
                btpt42.setEnabled(false)
                btpt43.setEnabled(false)
                bttla4.setEnabled(false)
                bttlt4.setEnabled(false)
                btfpn4.setEnabled(false)
                btfpt4.setEnabled(false)
                btas4.setEnabled(false)
                btrba4.setEnabled(false)
                btrbd4.setEnabled(false)
                btptc42.setEnabled(false)
                btptc43.setEnabled(false)
                btrob4.setEnabled(false)
                btpe4.setEnabled(false)
            }
            fpn4.setText(faltaP4.toString())
        }
        btfpt4.setOnClickListener {
            val currentFPT = fpt4.text.toString()
            val currentFPN = fpn4.text.toString()
            val fptDB = currentFPT.toInt()
            val fpnDB = currentFPN.toInt()
            faltaT4 = 1 + fptDB
            faltaP4 = 1 + fpnDB
            if (faltaT4 >= 2) {
                /*stopTimer1();*/
                faltaT4 = 2
                jg4.setTextColor(Color.RED)
                pt4.setTextColor(Color.RED)
                tla4.setTextColor(Color.RED)
                tlt4.setTextColor(Color.RED)
                fpn4.setTextColor(Color.RED)
                fpt4.setTextColor(Color.RED)
                as4.setTextColor(Color.RED)
                rba4.setTextColor(Color.RED)
                rbd4.setTextColor(Color.RED)
                ptc4.setTextColor(Color.RED)
                rob4.setTextColor(Color.RED)
                pe4.setTextColor(Color.RED)
                btpt42.setEnabled(false)
                btpt43.setEnabled(false)
                bttla4.setEnabled(false)
                bttlt4.setEnabled(false)
                btfpn4.setEnabled(false)
                btfpt4.setEnabled(false)
                btas4.setEnabled(false)
                btrba4.setEnabled(false)
                btrbd4.setEnabled(false)
                btptc42.setEnabled(false)
                btptc43.setEnabled(false)
                btrob4.setEnabled(false)
                btpe4.setEnabled(false)
            }
            fpn4.setText(faltaP4.toString())
            fpt4.setText(faltaT4.toString())
        }
        btas4.setOnClickListener {
            val currentAsistencias = as4.text.toString()
            val asistenciasDB = currentAsistencias.toInt()
            asistencia4 = 1 + asistenciasDB
            as4.setText(asistencia4.toString())
        }
        btrba4.setOnClickListener {
            val currentRebotesA = rba4.text.toString()
            val rebotesADB = currentRebotesA.toInt()
            rebotesA4 = 1 + rebotesADB
            rba4.setText(rebotesA4.toString())
        }
        btrbd4.setOnClickListener {
            val currentRebotesD = rbd4.text.toString()
            val rebotesDDB = currentRebotesD.toInt()
            rebotesD4 = 1 + rebotesDDB
            rbd4.setText(rebotesD4.toString())
        }
        btptc42.setOnClickListener {
            val currentContra = ptc4.text.toString()
            val currentPuntos = pt4.text.toString()
            val currentLocal = ml.text.toString()
            val contraDB = currentContra.toInt()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            contra4 = 1 + contraDB
            puntos4 = 2 + puntosDB
            puntosL = 2 + localDB
            ptc4.setText(contra4.toString())
            pt4.setText(puntos4.toString())
            ml.setText(puntosL.toString())
        }
        btptc43.setOnClickListener {
            val currentContra = ptc4.text.toString()
            val currentPuntos = pt4.text.toString()
            val currentLocal = ml.text.toString()
            val contraDB = currentContra.toInt()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            contra4 = 1 + contraDB
            puntos4 = 3 + puntosDB
            puntosL = 3 + localDB
            ptc4.setText(contra4.toString())
            pt4.setText(puntos4.toString())
            ml.setText(puntosL.toString())
        }
        btrob4.setOnClickListener {
            val currentRobos = rob4.text.toString()
            val robosDB = currentRobos.toInt()
            robos4 = 1 + robosDB
            rob4.setText(robos4.toString())
        }
        btpe4.setOnClickListener {
            val currentPerdida = pe4.text.toString()
            val perdidaDB = currentPerdida.toInt()
            perdida4 = 1 + perdidaDB
            pe4.setText(perdida4.toString())
        }

        /*JUGADOR 5*/
        btpt52.setOnClickListener {
            val currentPuntos = pt5.text.toString()
            val currentLocal = ml.text.toString()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            puntos5 = 2 + puntosDB
            puntosL = 2 + localDB
            pt5.setText(puntos5.toString())
            ml.setText(puntosL.toString())
        }
        btpt53.setOnClickListener {
            val currentPuntos = pt5.text.toString()
            val currentLocal = ml.text.toString()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            puntos5 = 3 + puntosDB
            puntosL = 3 + localDB
            pt5.setText(puntos5.toString())
            ml.setText(puntosL.toString())
        }
        bttla5.setOnClickListener {
            val currentTLA = tla5.text.toString()
            val currentTLT = tlt5.text.toString()
            val currentPuntos = pt5.text.toString()
            val currentLocal = ml.text.toString()
            val tlaDB = currentTLA.toInt()
            val tltDB = currentTLT.toInt()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            tlibreA5 = 1 + tlaDB
            tlibreT5 = 1 + tltDB
            puntos5 = 1 + puntosDB
            puntosL = 1 + localDB
            tla5.setText(tlibreA5.toString())
            tlt5.setText(tlibreT5.toString())
            pt5.setText(puntos5.toString())
            ml.setText(puntosL.toString())
        }
        bttlt5.setOnClickListener {
            val currentTLT = tlt5.text.toString()
            val tltDB = currentTLT.toInt()
            tlibreT5 = 1 + tltDB
            tlt5.setText(tlibreT5.toString())
        }
        btfpn5.setOnClickListener {
            val currentFPN = fpn5.text.toString()
            val fpnDB = currentFPN.toInt()
            faltaP5 = 1 + fpnDB
            if (faltaP5 >= 5) {
                /*stopTimer1();*/
                faltaP5 = 5
                jg5.setTextColor(Color.RED)
                pt5.setTextColor(Color.RED)
                tla5.setTextColor(Color.RED)
                tlt5.setTextColor(Color.RED)
                fpn5.setTextColor(Color.RED)
                fpt5.setTextColor(Color.RED)
                as5.setTextColor(Color.RED)
                rba5.setTextColor(Color.RED)
                rbd5.setTextColor(Color.RED)
                ptc5.setTextColor(Color.RED)
                rob5.setTextColor(Color.RED)
                pe5.setTextColor(Color.RED)
                btpt52.setEnabled(false)
                btpt53.setEnabled(false)
                bttla5.setEnabled(false)
                bttlt5.setEnabled(false)
                btfpn5.setEnabled(false)
                btfpt5.setEnabled(false)
                btas5.setEnabled(false)
                btrba5.setEnabled(false)
                btrbd5.setEnabled(false)
                btptc52.setEnabled(false)
                btptc53.setEnabled(false)
                btrob5.setEnabled(false)
                btpe5.setEnabled(false)
            }
            fpn5.setText(faltaP5.toString())
        }
        btfpt5.setOnClickListener {
            val currentFPT = fpt5.text.toString()
            val currentFPN = fpn5.text.toString()
            val fptDB = currentFPT.toInt()
            val fpnDB = currentFPN.toInt()
            faltaT5 = 1 + fptDB
            faltaP5 = 1 + fpnDB
            if (faltaT5 >= 2) {
                /*stopTimer1();*/
                faltaT5 = 2
                jg5.setTextColor(Color.RED)
                pt5.setTextColor(Color.RED)
                tla5.setTextColor(Color.RED)
                tlt5.setTextColor(Color.RED)
                fpn5.setTextColor(Color.RED)
                fpt5.setTextColor(Color.RED)
                as5.setTextColor(Color.RED)
                rba5.setTextColor(Color.RED)
                rbd5.setTextColor(Color.RED)
                ptc5.setTextColor(Color.RED)
                rob5.setTextColor(Color.RED)
                pe5.setTextColor(Color.RED)
                btpt52.setEnabled(false)
                btpt53.setEnabled(false)
                bttla5.setEnabled(false)
                bttlt5.setEnabled(false)
                btfpn5.setEnabled(false)
                btfpt5.setEnabled(false)
                btas5.setEnabled(false)
                btrba5.setEnabled(false)
                btrbd5.setEnabled(false)
                btptc52.setEnabled(false)
                btptc53.setEnabled(false)
                btrob5.setEnabled(false)
                btpe5.setEnabled(false)
            }
            fpn5.setText(faltaP5.toString())
            fpt5.setText(faltaT5.toString())
        }
        btas5.setOnClickListener {
            val currentAsistencias = as5.text.toString()
            val asistenciasDB = currentAsistencias.toInt()
            asistencia5 = 1 + asistenciasDB
            as5.setText(asistencia5.toString())
        }
        btrba5.setOnClickListener {
            val currentRebotesA = rba5.text.toString()
            val rebotesADB = currentRebotesA.toInt()
            rebotesA5 = 1 + rebotesADB
            rba5.setText(rebotesA5.toString())
        }
        btrbd5.setOnClickListener {
            val currentRebotesD = rbd5.text.toString()
            val rebotesDDB = currentRebotesD.toInt()
            rebotesD5 = 1 + rebotesDDB
            rbd5.setText(rebotesD5.toString())
        }
        btptc52.setOnClickListener {
            val currentContra = ptc5.text.toString()
            val currentPuntos = pt5.text.toString()
            val currentLocal = ml.text.toString()
            val contraDB = currentContra.toInt()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            contra5 = 1 + contraDB
            puntos5 = 2 + puntosDB
            puntosL = 2 + localDB
            ptc5.setText(contra5.toString())
            pt5.setText(puntos5.toString())
            ml.setText(puntosL.toString())
        }
        btptc53.setOnClickListener {
            val currentContra = ptc5.text.toString()
            val currentPuntos = pt5.text.toString()
            val currentLocal = ml.text.toString()
            val contraDB = currentContra.toInt()
            val puntosDB = currentPuntos.toInt()
            val localDB = currentLocal.toInt()
            contra5 = 1 + contraDB
            puntos5 = 3 + puntosDB
            puntosL = 3 + localDB
            ptc5.setText(contra5.toString())
            pt5.setText(puntos5.toString())
            ml.setText(puntosL.toString())
        }
        btrob5.setOnClickListener {
            val currentRobos = rob5.text.toString()
            val robosDB = currentRobos.toInt()
            robos5 = 1 + robosDB
            rob5.setText(robos5.toString())
        }
        btpe5.setOnClickListener {
            val currentPerdida = pe5.text.toString()
            val perdidaDB = currentPerdida.toInt()
            perdida5 = 1 + perdidaDB
            pe5.setText(perdida5.toString())
        }
    }

    //Recogemos los datos de los jugadores
    private fun fetchData() {
        val sharedPreferences: SharedPreferences = getSharedPreferences("Partido", MODE_PRIVATE)
        val partidoGuardado = sharedPreferences.getString("partido", "") ?: ""
        val selectedPlayersPSet = sharedPreferences.getStringSet("selectedPlayersP", emptySet()) ?: emptySet()

        //Recorremos la base de datos
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val selectedPlayersP = mutableListOf<EstadisticasDB>()

                //Recorremos la lista de jugadores
                for (jugadorSnap in snapshot.children) {
                    val part = jugadorSnap.key
                    val jugadorNombre = jugadorSnap.child("nombre").getValue(String::class.java) ?: ""
                    //Cuando el nombre del nodo contenga al jugador y partido se asignan sus estadísticas
                    if (part != null && part.contains(partidoGuardado) && jugadorNombre in selectedPlayersPSet) {
                        val jugador = jugadorSnap.getValue(EstadisticasDB::class.java)
                        jugador?.let {
                            selectedPlayersP.add(it)
                        }
                    }
                }

                //Se recorren los 5 jugadores en pista y se les asigna la posición
                selectedPlayersP.forEachIndexed { index, player ->
                    when (index) {
                        0 -> assignPlayerDataToViews(player, 1)
                        1 -> assignPlayerDataToViews(player, 2)
                        2 -> assignPlayerDataToViews(player, 3)
                        3 -> assignPlayerDataToViews(player, 4)
                        4 -> assignPlayerDataToViews(player, 5)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }

    private fun assignPlayerDataToViews(jugador: EstadisticasDB, playerNumber: Int) {
        //Cuando coincida el index se muestran los datos de ese jugador
        when (playerNumber) {
            1 -> {
                jg1.text = jugador.nombre
                pt1.text = jugador.puntos.toString()
                tla1.text = jugador.tlibresA.toString()
                tlt1.text = jugador.tlibresT.toString()
                fpn1.text = jugador.faltas.toString()
                fpt1.text = jugador.faltasT.toString()
                as1.text = jugador.asistencias.toString()
                rba1.text = jugador.rebotesA.toString()
                rbd1.text = jugador.rebotesD.toString()
                ptc1.text = jugador.contraataque.toString()
                rob1.text = jugador.robos.toString()
                pe1.text = jugador.perdidas.toString()
            }
            2 -> {
                jg2.text = jugador.nombre
                pt2.text = jugador.puntos.toString()
                tla2.text = jugador.tlibresA.toString()
                tlt2.text = jugador.tlibresT.toString()
                fpn2.text = jugador.faltas.toString()
                fpt2.text = jugador.faltasT.toString()
                as2.text = jugador.asistencias.toString()
                rba2.text = jugador.rebotesA.toString()
                rbd2.text = jugador.rebotesD.toString()
                ptc2.text = jugador.contraataque.toString()
                rob2.text = jugador.robos.toString()
                pe2.text = jugador.perdidas.toString()
            }
            3 -> {
                jg3.text = jugador.nombre
                pt3.text = jugador.puntos.toString()
                tla3.text = jugador.tlibresA.toString()
                tlt3.text = jugador.tlibresT.toString()
                fpn3.text = jugador.faltas.toString()
                fpt3.text = jugador.faltasT.toString()
                as3.text = jugador.asistencias.toString()
                rba3.text = jugador.rebotesA.toString()
                rbd3.text = jugador.rebotesD.toString()
                ptc3.text = jugador.contraataque.toString()
                rob3.text = jugador.robos.toString()
                pe3.text = jugador.perdidas.toString()
            }
            4 -> {
                jg4.text = jugador.nombre
                pt4.text = jugador.puntos.toString()
                tla4.text = jugador.tlibresA.toString()
                tlt4.text = jugador.tlibresT.toString()
                fpn4.text = jugador.faltas.toString()
                fpt4.text = jugador.faltasT.toString()
                as4.text = jugador.asistencias.toString()
                rba4.text = jugador.rebotesA.toString()
                rbd4.text = jugador.rebotesD.toString()
                ptc4.text = jugador.contraataque.toString()
                rob4.text = jugador.robos.toString()
                pe4.text = jugador.perdidas.toString()
            }
            5 -> {
                jg5.text = jugador.nombre
                pt5.text = jugador.puntos.toString()
                tla5.text = jugador.tlibresA.toString()
                tlt5.text = jugador.tlibresT.toString()
                fpn5.text = jugador.faltas.toString()
                fpt5.text = jugador.faltasT.toString()
                as5.text = jugador.asistencias.toString()
                rba5.text = jugador.rebotesA.toString()
                rbd5.text = jugador.rebotesD.toString()
                ptc5.text = jugador.contraataque.toString()
                rob5.text = jugador.robos.toString()
                pe5.text = jugador.perdidas.toString()
            }
        }
    }

    private fun fetchPartidoData() {
        db2.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var marcadorLOCAL=""
                var marcadorVISITANTE=""
                for(partidoSnap in snapshot.children){
                    val part = partidoSnap.getValue(PartidoDB::class.java)
                    part?.let{
                        marcadorLOCAL="${it.marcL}"
                        marcadorVISITANTE="${it.marcV}"
                    }
                }
                ml.text=marcadorLOCAL
                mv.text=marcadorVISITANTE
            }
            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }



}