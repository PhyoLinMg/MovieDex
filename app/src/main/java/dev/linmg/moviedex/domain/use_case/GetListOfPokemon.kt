package dev.linmg.moviedex.domain.use_case

import dev.linmg.moviedex.domain.repository.PokemonRepository

class GetListOfPokemon(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(limit: Int, offset: Int) {
        repository.getPokemons(limit, offset)
    }
}
