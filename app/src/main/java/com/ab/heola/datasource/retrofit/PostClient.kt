package com.ab.heola.datasource.retrofit

import com.ab.heola.datasource.retrofit.model.Post
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by sunde_000 on 05/12/2017.
 */
interface PostClient {
    @GET("posts/{id}")
    fun getPost(@Path("id") id: Int): Observable<Post>
}