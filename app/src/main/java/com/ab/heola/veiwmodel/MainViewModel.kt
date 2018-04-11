package com.ab.heola.veiwmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.widget.Toast
import com.ab.heola.MyApplication
import com.ab.heola.datasource.retrofit.PostClient
import com.ab.heola.datasource.retrofit.model.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.IOException
import java.util.*
import javax.inject.Inject

/**
 * Created by sunde_000 on 06/12/2017.
 */
open class MainViewModel(application: Application) : AndroidViewModel(application) {

    @Inject lateinit var postClient: PostClient

    val mPost: MutableLiveData<Post> = MutableLiveData()

    init {
        (application as MyApplication).appComponent.inject(this)
        mPost.value = null
    }

    fun getPostButtonClicked() {
        val random = Random()
        postClient.getPost(random.nextInt(100))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { post ->
                            mPost.value = post
                        },
                        { error ->
                            if (error is IOException) {
                                Toast.makeText(getApplication(), "No Internet", Toast.LENGTH_LONG).show()
                            } else {
                                Toast.makeText(getApplication(), "Failure", Toast.LENGTH_LONG).show()
                            }
                        }
                )
    }
}