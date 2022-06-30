package dev.linmg.moviedex.data.repository

import dev.linmg.moviedex.data.remote.dto.pokemon.PokemonResponse
import dev.linmg.moviedex.domain.repository.PokemonRepository
import dev.linmg.moviedex.utils.Resource

class PokemonRepositoryImpl : PokemonRepository {
    override fun getPokemons(limit: Int, offset: Int): Resource<PokemonResponse> {
        TODO("Not yet implemented")
    }
}
