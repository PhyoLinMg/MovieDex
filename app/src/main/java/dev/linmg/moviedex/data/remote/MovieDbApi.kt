package dev.linmg.moviedex.data.remote

import dev.linmg.moviedex.BuildConfig
import dev.linmg.moviedex.data.remote.dto.movies.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDbApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = BuildConfig.MOVIE_API_KEY,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int,
    ): MovieResponse
}
