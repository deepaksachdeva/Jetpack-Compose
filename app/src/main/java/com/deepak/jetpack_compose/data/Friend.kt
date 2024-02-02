package com.deepak.jetpack_compose.data

data class Friend(
    val firstName: String,
    val lastName: String
)

fun getFriendList() = listOf(
    Friend("Deepak", "Sachdeva"),
    Friend("Himanshu", "Mittal"),
    Friend("Rahul", "Madaan"),
    Friend("Amit", "Thaper"),
    Friend("Apoorv", "Dubey"),
    Friend("Venugopala", "Swammy"),
    Friend("Deepak", "Gupta")
)