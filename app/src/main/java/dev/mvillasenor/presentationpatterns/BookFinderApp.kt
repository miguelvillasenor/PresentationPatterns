package dev.mvillasenor.presentationpatterns

import android.app.Application
import dev.mvillasenor.presentationpatterns.data.dataModule
import dev.mvillasenor.presentationpatterns.domain.domainModule
import dev.mvillasenor.presentationpatterns.ui.presentationModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class BookFinderApp : Application() {

    private val koinModules = listOf(dataModule, domainModule, applicationModule, presentationModule)

    override fun onCreate() {
        super.onCreate()
        startKoin(this, koinModules)

        Timber.plant(Timber.DebugTree())
    }

}
