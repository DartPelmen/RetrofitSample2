package edu.festu.ivan.kuznetsov.retrofitsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import edu.festu.ivan.kuznetsov.retrofitsample.databinding.ActivityMainBinding
import edu.festu.ivan.kuznetsov.retrofitsample.network.ApiService
import edu.festu.ivan.kuznetsov.retrofitsample.network.NetworkSingleton
import edu.festu.ivan.kuznetsov.retrofitsample.network.SearchRequest
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    val adapter = RVAdapter()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.films.layoutManager = LinearLayoutManager(this)
        binding.films.adapter = adapter
        binding.button.setOnClickListener {
            val expr = if (binding.cityField.text.isNullOrEmpty()) "Мстители" else binding.cityField.text.toString()
            NetworkSingleton.get()
                .create(ApiService::class.java).getMovies("ru", expr)
                .enqueue(object :retrofit2.Callback<SearchRequest>{
                    override fun onResponse(
                        call: Call<SearchRequest>,
                        response: Response<SearchRequest>
                    ) {
                        response.body()?.let {

                            if(!it.errorMessage.isNullOrEmpty())
                            {
                                Log.d("EMPTY", "MESSAGE")
                                Log.d("LINK", "https://imdb-api.com/ru/API/Search/k_s9z75hs9/$expr")
                            }
                            if (it.results.isNotEmpty())
                                adapter.setList(it.results)
                        }
                    }

                    override fun onFailure(call: Call<SearchRequest>, t: Throwable) {
                        Log.d("ERROR", t.message.toString())
                    }
                })

        }

    }
}