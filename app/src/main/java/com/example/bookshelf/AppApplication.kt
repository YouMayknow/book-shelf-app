package com.example.bookshelf

import android.app.Application
import com.example.bookshelf.data.AppContainer
import com.example.bookshelf.data.DefaultAppContainer

class AppApplication : Application() {
   lateinit var  appContianer  : AppContainer
    override fun onCreate() {
        super.onCreate()
        appContianer = DefaultAppContainer()
    }
}