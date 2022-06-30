package dev.linmg.moviedex.data.repository

import dev.linmg.moviedex.data.remote.dto.movies.MovieResponse
import dev.linmg.moviedex.domain.repository.MovieRepository
import dev.linmg.moviedex.utils.Resource

class MovieRepositoryImpl() : MovieRepository {
    override fun getMovies(page: Int): Resource<MovieResponse> {
        TODO("Not yet implemented")
    }
}
