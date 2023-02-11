package uz.data.connection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.data.connection.data.remote.ApiClient
import uz.data.connection.model.Post

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        loadPosts()
        getPostById(2)
    }

    private fun getPostById(id: Int) {
        ApiClient.apiService.getPostById(id).enqueue(object :Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful){
                    Toast.makeText(this@MainActivity, "muvaqqiyatli yaratildi", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Serverda hatolik bo'ldi", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun loadPosts() {
        ApiClient.apiService.getAllPosts().enqueue(object :Callback<ArrayList<Post>>{
            override fun onResponse(
                call: Call<ArrayList<Post>>,
                response: Response<ArrayList<Post>>
            ) {
                if (response.isSuccessful){
                    val list=response.body()
                    //adapterga list berasizlar
                }
            }

            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {

            }

        })
    }


}