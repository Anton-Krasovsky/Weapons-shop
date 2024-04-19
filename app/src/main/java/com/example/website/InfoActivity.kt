package com.example.website

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.razorpay.Checkout
import org.json.JSONObject

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        Checkout.preload(applicationContext)
        val co = Checkout()
        co.setKeyID("rzp_live_EgmQoGwAT33eJi")

        val title = findViewById<TextView>(R.id.info_title)
        val text = findViewById<TextView>(R.id.info_text)
        val btnPay = findViewById<Button>(R.id.button_info_buy)


        title.text = intent.getStringExtra("weaponTitle")
        text.text = intent.getStringExtra("weaponText")

        btnPay.setOnClickListener {
            startPayment()
        }
    }
    private fun startPayment() {

        val activity: Activity = this
        val co = Checkout()

        try {
            val options = JSONObject()
            options.put("name","KrasovskyIT")
            options.put("description","Demoing Charges")
            //You can omit the image option to fetch the image from the dashboard
            options.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg")
            options.put("theme.color", "#3399cc");
            options.put("currency","BYN");
            options.put("order_id", "order_LoFddJZDnSKKnm");
            options.put("amount",10000)

            co.open(activity,options)
        }catch (e: Exception){
            Toast.makeText(activity,"Error in payment: "+ e.message,Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }
}