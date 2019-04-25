package dev.mvillasenor.presentationpatterns

import android.app.Application
import dev.mvillasenor.presentationpatterns.data.dataModule
import dev.mvillasenor.presentationpatterns.domain.domainModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class BookFinderApp : Application() {

    private val koinModules = listOf(dataModule, domainModule, applicationModule)

    override fun onCreate() {
        super.onCreate()
        startKoin(this, koinModules)

        Timber.plant(Timber.DebugTree())
    }

}
