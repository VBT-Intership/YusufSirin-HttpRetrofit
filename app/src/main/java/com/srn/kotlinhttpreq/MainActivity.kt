package com.srn.kotlinhttpreq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var carslist = ArrayList<CarModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview_cars.adapter=DataAdapter(carslist)
        recyclerview_cars.layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        getCarList()
    }
    private fun getCarList() {

        val call: Call<List<CarModel>> = HttpClient.getClient.getHttpCarList()
        call.enqueue(object : Callback<List<CarModel>> {
            override fun onFailure(call: Call<List<CarModel>>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<CarModel>>?,
                response: Response<List<CarModel>>?
            ) {
                if (response != null) {
                    carslist.addAll(response.body())
                    recyclerview_cars.adapter?.notifyDataSetChanged()
                    Toast.makeText(this@MainActivity, "Success!", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

}
