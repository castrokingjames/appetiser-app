package au.com.appetiser.itunes.di.module

import androidx.lifecycle.ViewModelProvider
import au.com.appetiser.itunes.di.viewmodel.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelProviderFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}