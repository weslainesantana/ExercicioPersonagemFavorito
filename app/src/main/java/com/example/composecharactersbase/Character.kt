package com.example.composecharactersbase

data class ApiResponse(
    val results: List<Character>
)

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val image: String
)