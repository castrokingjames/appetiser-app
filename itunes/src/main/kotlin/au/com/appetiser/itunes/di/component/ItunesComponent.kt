package au.com.appetiser.itunes.di.component

import android.app.Application
import au.com.appetiser.itunes.ItunesApplication
import au.com.appetiser.itunes.di.module.ApplicationModule
import au.com.appetiser.itunes.di.module.DatabaseModule
import au.com.appetiser.itunes.di.module.ItunesModule
import au.com.appetiser.itunes.di.module.WebserviceModule
import au.com.appetiser.itunes.di.scope.ForApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@ForApplication
@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            ApplicationModule::class,
            ItunesModule::class,
            DatabaseModule::class,
            WebserviceModule::class
        ]
)
interface ItunesComponent : AndroidInjector<ItunesApplication> {

    @Component.Factory
    interface Factory {

        fun create(module: ApplicationModule, @BindsInstance application: Application): ItunesComponent
    }

    override fun inject(app: ItunesApplication)
}