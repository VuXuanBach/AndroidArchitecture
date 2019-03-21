package com.ea.myapplication.daggers

import com.ea.myapplication.models.Info
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    @Named("1")
    fun providesInfo1(): Info {
        return Info("Testing 1")
    }

    @Singleton
    @Provides
    @Named("2")
    fun providesInfo2(): Info {
        return Info("Testing 2")
    }
}