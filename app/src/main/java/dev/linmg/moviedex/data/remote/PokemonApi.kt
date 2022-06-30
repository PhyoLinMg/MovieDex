package dev.linmg.moviedex.data.remote

import dev.linmg.moviedex.data.remote.dto.pokemon.PokemonResponse
import dev.linmg.moviedex.utils.Resource
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {
    @GET("ability")
    suspend fun getAbility(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): Resource<PokemonResponse>
}
