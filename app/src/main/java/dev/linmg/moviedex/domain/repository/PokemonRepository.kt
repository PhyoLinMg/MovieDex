package dev.linmg.moviedex.domain.repository

import dev.linmg.moviedex.data.remote.dto.pokemon.PokemonResponse
import dev.linmg.moviedex.utils.Resource

interface PokemonRepository {
    fun getPokemons(limit: Int, offset: Int): Resource<PokemonResponse>
}
