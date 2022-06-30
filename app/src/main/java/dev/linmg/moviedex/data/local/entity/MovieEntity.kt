package dev.linmg.moviedex.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val isFavorite: Boolean = false,
    val overview: String,
    val posterPath: String
)
