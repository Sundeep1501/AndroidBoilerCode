package com.ab.heola

import android.app.Application
import com.ab.heola.dagger.AppModule
import com.ab.heola.dagger.ApplicationComponent
import com.ab.heola.dagger.DaggerApplicationComponent
import com.ab.heola.dagger.NetModule

/**
 * Created by sunde_000 on 06/12/2017.
 */
class MyApplication : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
                .appModule(AppModule(this))
                .netModule(NetModule(BuildConfig.HOST_API))
                .build()
    }

}