package com.ridery.test.yerih.core_service.di

import com.ridery.test.yerih.core_service.RemoteDataSource
import com.ridery.test.yerih.core_service.RemoteDataSourceImpl
import com.ridery.test.yerih.core_service.service.RemoteService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.create


@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    fun provideRemoteService(): RemoteService = RemoteService.buildRetrofit().create()

    @Provides
    fun provideRemoteDataSource(service: RemoteService) : RemoteDataSource = RemoteDataSourceImpl(service)
}