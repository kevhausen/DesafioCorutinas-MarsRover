package com.example.marsroverimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val urls = listOf<String>("http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FLB_486265257EDR_F0481570FHAZ00323M_.JPG",
        "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/rcam/RLB_486265291EDR_F0481570RHAZ00323M_.JPG",
        "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/rcam/RRB_486265291EDR_F0481570RHAZ00323M_.JPG",
        "http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Main).launch {
            getFirstImg()
            getSecondImg()
            getThirdImg()
            getFourthImg()}

        buttonUiCheck.setOnClickListener {
            when(PbarTry.visibility){
                View.VISIBLE->PbarTry.visibility=View.GONE
                View.GONE->PbarTry.visibility=View.VISIBLE
            }
        }
    }
    private suspend fun getFirstImg(){
        firstPbar.visibility=View.VISIBLE
        delay(2000)
        Glide.with(this).load(urls[0]).into(firstImg)
        firstPbar.visibility=View.GONE
    }
    private suspend fun getSecondImg(){
        secondPbar.visibility=View.VISIBLE
        delay(2000)
        Glide.with(this).load(urls[1]).into(secondImg)
        secondPbar.visibility=View.GONE
    }
    private suspend fun getThirdImg(){
        thirdPbar.visibility=View.VISIBLE
        delay(2000)
        Glide.with(this).load(urls[2]).into(thirdImg)
        thirdPbar.visibility=View.GONE
    }
    private suspend fun getFourthImg(){
        fourthPbar.visibility=View.VISIBLE
        delay(2000)
        Glide.with(this).load(urls[3]).into(fourthImg)
        fourthPbar.visibility=View.GONE
    }

}
