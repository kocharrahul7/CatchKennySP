package com.example.kocha.kotlinkenny

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {


    var score : Int = 0
    var imageArray = ArrayList<ImageView>()
    var handler :Handler = Handler()
    var runnable : Runnable = Runnable {  }


    fun increaseScore(view: View){
        score++

        scoreText.text = "score " + score
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        score = 0

        imageArray = arrayListOf(imageView0,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8)
        object : CountDownTimer(10000,1000) {
            override fun onFinish() {
                timeText.text = "Time's up "
            }
            override fun onTick(p0: Long) {
                timeText.text = "Time: " +p0 / 1000
            }


        }.start()

    }


    fun hideKenny(){
        runnable = object : Runnable{
            override fun run(){
                for(image in imageArray){
                    image.visibility = View.INVISIBLE
                }
                val random = Random()
                val index = random.nextInt(0 - 8)
                imageArray[index].visibility = View.VISIBLE
                handler.postDelayed(runnable,500)

            }
        }

        handler.post(runnable)

    }
}
