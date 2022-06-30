package dev.linmg.moviedex.data.di

import android.app.Application
import androidx.room.Room
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.linmg.moviedex.data.local.MainDatabase
import dev.linmg.moviedex.data.remote.MovieDbApi
import dev.linmg.moviedex.data.remote.PokemonApi
import dev.linmg.moviedex.utils.Constants.MOVIE_DB_API
import dev.linmg.moviedex.utils.Constants.POKE_API
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePokemonApi(): PokemonApi {
        val contentType = "application/json".toMediaType()
        val json = Json {
            ignoreUnknownKeys = true
        }
        return Retrofit.Builder()
            .baseUrl(POKE_API)
            .addConverterFactory(json.asConverterFactory(contentType))
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BASIC
                        }
                    ).build()
            )
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideMovieDbApi(): MovieDbApi {
        val contentType = "application/json".toMediaType()
        val json = Json {
            ignoreUnknownKeys = true
        }
        return Retrofit.Builder()
            .baseUrl(MOVIE_DB_API)
            .addConverterFactory(json.asConverterFactory(contentType))
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BASIC
                        }
                    ).build()
            )
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application): MainDatabase {
        return Room.databaseBuilder(
            app,
            MainDatabase::class.java,
            MainDatabase.DATABASE_NAME
        ).build()
    }
}
