package com.ab.heola.dagger

import com.ab.heola.veiwmodel.MainViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by sunde_000 on 06/12/2017.
 */
@Singleton
@Component(modules = [(AppModule::class), (NetModule::class)])
interface ApplicationComponent {
    fun inject(viewModel: MainViewModel)
}