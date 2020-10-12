package com.kienct.fandemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.area_layout.*
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidNetworking.initialize(applicationContext)
        AndroidNetworking.get(url)
            .addPathParameter("countryCode", countryCode)
            .addQueryParameter("apikey", apiKey)
            .addQueryParameter("q", query).build().getAsJSONArray(object :
                JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {
                    val areas : MutableList<Area> = arrayListOf()
                    val gson = Gson()
                    for (i in 0 until response?.length()!!){
                        val area : Area = gson.fromJson(response.getString(i), Area::class.java)
                        areas.add(area)
                    }
                    val areaAdapter = AreaAdapter(areas)
                    areaViewer.layoutManager = LinearLayoutManager(applicationContext)
                    areaViewer.adapter = areaAdapter
                }

                override fun onError(anError: ANError?) {
                    Log.d("Failed", anError.toString())
                }
            })
    }

    companion object {
        const val url: String =
            "http://dataservice.accuweather.com/locations/v1/{countryCode}/search"
        const val countryCode: String = "VN"
        const val apiKey: String = "XU2BFgubyg5s8JBZnbSP0dlOmzNXxQPh"
        const val query: String = "Long Son"
    }
}