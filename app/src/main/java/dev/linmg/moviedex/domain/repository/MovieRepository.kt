package dev.linmg.moviedex.domain.repository

import dev.linmg.moviedex.data.remote.dto.movies.MovieResponse
import dev.linmg.moviedex.utils.Resource

interface MovieRepository {
    fun getMovies(page: Int): Resource<MovieResponse>
}
