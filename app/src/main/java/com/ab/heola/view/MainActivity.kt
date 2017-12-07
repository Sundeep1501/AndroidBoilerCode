package com.ab.heola.view

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ab.heola.R
import com.ab.heola.datasource.retrofit.model.Post
import com.ab.heola.veiwmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity() : AppCompatActivity() {

    private val lifecycleRegistry = LifecycleRegistry(this)
    lateinit var mViewModel: MainViewModel

    override fun getLifecycle(): LifecycleRegistry {
        return lifecycleRegistry
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mViewModel.mPost.observe(this, Observer<Post> { post -> updatePostDetails(post) })
    }

    private fun updatePostDetails(post: Post?) {
        if (post == null) {
            textView.text = "NA"
            return
        }
        textView.text = "Post Details\nID:" + (post.id) + "\nUSER ID:" + post.userId + "\nTITLE:" + post.title + "\nBODY:" + post.body
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.button -> {
                mViewModel.getPostButtonClicked()
            }
        }
    }

}
