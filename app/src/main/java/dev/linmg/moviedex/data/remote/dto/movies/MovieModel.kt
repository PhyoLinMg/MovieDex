package dev.linmg.moviedex.data.remote.dto.movies

import dev.linmg.moviedex.data.local.entity.MovieEntity

data class MovieModel(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String
)

fun MovieModel.toEntity(): MovieEntity {
    return MovieEntity(
        this.id,
        this.title,
        overview = this.overview,
        posterPath = this.posterPath
    )
}
