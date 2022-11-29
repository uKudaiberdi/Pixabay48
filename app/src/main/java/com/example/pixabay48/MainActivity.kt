package com.example.pixabay48

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.pixabay48.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var page = 0
    lateinit var binding: ActivityMainBinding
    var adapter = ImageAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Click()
    }

    private fun Click() {
        with(binding) {
            findBtn.setOnClickListener {
                page= 1
                doReguest(page)
        }
            btnAdd.setOnClickListener {
                doReguest(++page)
            }
    }}

    private fun ActivityMainBinding.doReguest(page:Int) {
                RetrofitService.api.getImage(photoEd.text.toString(), page =page )
                    .enqueue(object : Callback<PixaModel> {
                        override fun onResponse(
                            call: Call<PixaModel>,
                            response: Response<PixaModel>
                        ) {
                            if (response.isSuccessful) {
                                response.body()?.hits.let {
                                    it?.forEach {
                                       adapter.add(it)

                                }
                                binding.recyclerView.adapter = this@MainActivity.adapter
                            }}
                        }

                        override fun onFailure(call: Call<PixaModel>, t: Throwable) {
                            Log.e("lolo", "onFailure: ${t.message} ")
                        }

                    })

        }
    }
