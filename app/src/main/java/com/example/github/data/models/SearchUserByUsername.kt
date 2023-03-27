package com.example.github.data.models

data class SearchUserByUsername(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<UserResponse>
)
