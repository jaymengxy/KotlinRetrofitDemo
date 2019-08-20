package com.mxy.krd

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by Mengxy on 2019-08-20.
 */

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}