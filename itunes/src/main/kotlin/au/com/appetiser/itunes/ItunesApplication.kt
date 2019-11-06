package au.com.appetiser.itunes

import android.app.Application
import au.com.appetiser.itunes.di.component.DaggerItunesComponent
import au.com.appetiser.itunes.di.module.ApplicationModule
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class ItunesApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerItunesComponent
                .factory()
                .create(ApplicationModule(this), this)
                .inject(this)

        Stetho.initializeWithDefaults(this)
    }
}