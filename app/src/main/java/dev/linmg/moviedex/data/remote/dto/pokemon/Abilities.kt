package dev.linmg.moviedex.data.remote.dto.pokemon


import com.google.gson.annotations.SerializedName

data class Abilities(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)