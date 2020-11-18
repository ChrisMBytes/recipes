package com.cmbytes.compose.di

import android.app.Application
import com.cmbytes.compose.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    MainBindings::class,
    NetworkModule::class,
    StateModule::class,
    ConfigModule::class
])
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(app: App)

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun application(app: Application): Builder
    }
}