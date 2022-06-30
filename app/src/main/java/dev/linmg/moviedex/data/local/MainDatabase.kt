package dev.linmg.moviedex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.linmg.moviedex.data.local.daos.MovieDao
import dev.linmg.moviedex.data.local.daos.PokemonDao

@Database(
    entities = [],
    version = 1,
    exportSchema = true
)
abstract class MainDatabase : RoomDatabase() {
    abstract val movieDao: MovieDao
    abstract val pokemonDao: PokemonDao

    companion object {
        const val DATABASE_NAME = "example_db"
    }
}
