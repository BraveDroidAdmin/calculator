package com.bravedroid.cmp.infrastructure.di

import android.content.Context
import android.content.SharedPreferences
import com.bravedroid.cmp.domain.crash_reporting.CrashReporter
import com.bravedroid.cmp.domain.repository.CmpLocalRepository
import com.bravedroid.cmp.domain.tracking.Tracker
import com.bravedroid.cmp.infrastructure.crash_reporting.CrashlyticsCrashReporter
import com.bravedroid.cmp.infrastructure.repository.CmpLocalRepositoryImpl
import com.bravedroid.cmp.infrastructure.tracking.GoogleAnalyticsTracker
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class CmpInfrastructureModule {
    @Binds
    abstract fun bindsCrashReporter(crashReporter: CrashlyticsCrashReporter): CrashReporter

    @Binds
    abstract fun bindsTracker(GoogleAnalyticsTracker: GoogleAnalyticsTracker): Tracker

    @Binds
    abstract fun bindsCmpLocalRepository(GoogleAnalyticsTracker: CmpLocalRepositoryImpl): CmpLocalRepository

    companion object {
        @Singleton
        @Provides
        @CmpSharedPreferences
        fun providesSharedPreferences(
            @ApplicationContext context: Context,
        ): SharedPreferences =
            context.getSharedPreferences("cmp-shared-preferences", Context.MODE_PRIVATE)
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class CmpSharedPreferences
}
