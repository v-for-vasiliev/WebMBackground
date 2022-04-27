package org.fatsnakes.webmbackground

import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var videoBackground: VideoView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)

        videoBackground = findViewById(R.id.videoBackground)
        videoBackground?.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.sky))
        videoBackground?.setOnPreparedListener {
            it.isLooping = true
        }
        videoBackground?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        videoBackground?.stopPlayback()
    }
}