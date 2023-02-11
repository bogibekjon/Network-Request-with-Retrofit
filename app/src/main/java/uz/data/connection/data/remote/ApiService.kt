package uz.data.connection.data.remote

import retrofit2.Call
import retrofit2.http.*
import uz.data.connection.model.Post

interface ApiService {

    @Headers(
        "Content-type:application/json; charset=UTF-8"
    )

    @GET("posts")
    fun getAllPosts(): Call<ArrayList<Post>>

    @GET("posts/{id}")
    fun getPostById(@Path("id") id: Int): Call<Post>

    @POST("posts")
    fun savePost(@Body post: Post): Call<Post>

    @PUT("posts/{id}")
    fun updatePost(@Path("id") id: Int, @Body post: Post): Call<Post>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id: Int)


}