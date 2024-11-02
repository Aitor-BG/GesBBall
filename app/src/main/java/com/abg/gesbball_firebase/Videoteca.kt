package com.abg.gesbball_firebase

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class Videoteca : AppCompatActivity() {

    private lateinit var volver: ImageButton
    private lateinit var videoView: VideoView
    private lateinit var video1: Button
    private lateinit var video2: Button
    private lateinit var video3: Button
    private lateinit var video4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.videoteca)

        volver=findViewById(R.id.BT_VOLVER)
        videoView=findViewById(R.id.VIDEO)
        video1=findViewById(R.id.BT_VIDEO1)
        video2=findViewById(R.id.BT_VIDEO2)
        video3=findViewById(R.id.BT_VIDEO3)
        video4=findViewById(R.id.BT_VIDEO4)

        //Accdemos a la ruta del video dependiendo cual este identificado y lo pasamos al videoView para mostrarse
        video1.setOnClickListener {
            val videoPath="android.resource://"+packageName+"/"+R.raw.ataque23
            val videoUri = Uri.parse(videoPath)
            videoView.setVideoURI(videoUri)
            val mediaController = MediaController(this)
            mediaController.setAnchorView(videoView)
            videoView.setMediaController(mediaController)
            videoView.start()
        }

        video2.setOnClickListener {
            val videoPath="android.resource://"+packageName+"/"+R.raw.ataque32
            val videoUri = Uri.parse(videoPath)
            videoView.setVideoURI(videoUri)
            val mediaController = MediaController(this)
            mediaController.setAnchorView(videoView)
            videoView.setMediaController(mediaController)
            videoView.start()
        }

        video3.setOnClickListener {
            val videoPath="android.resource://"+packageName+"/"+R.raw.diamante
            val videoUri = Uri.parse(videoPath)
            videoView.setVideoURI(videoUri)
            val mediaController = MediaController(this)
            mediaController.setAnchorView(videoView)
            videoView.setMediaController(mediaController)
            videoView.start()
        }

        video4.setOnClickListener {
            val videoPath="android.resource://"+packageName+"/"+R.raw.cuernos
            val videoUri = Uri.parse(videoPath)
            videoView.setVideoURI(videoUri)
            val mediaController = MediaController(this)
            mediaController.setAnchorView(videoView)
            videoView.setMediaController(mediaController)
            videoView.start()
        }

        //Si estuvieramos en la pestaña de Banquillo anteriormente volvemos al banquillo, sino vamos al Menu
        volver.setOnClickListener {
            val sharedPreferences = getSharedPreferences("Pagina", MODE_PRIVATE)
            val banvid = sharedPreferences.getString("pagina","")
            if(banvid.equals("videoteca")){
                val intent = Intent(this, Banquillo::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this, Menu::class.java)
                startActivity(intent)
            }

        }

    }
}