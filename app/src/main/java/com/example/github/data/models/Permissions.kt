package com.example.github.data.models

data class Permissions(
    val admin: Boolean,
    val maintain: Boolean,
    val push: Boolean,
    val triage: Boolean,
    val pull: Boolean
)
