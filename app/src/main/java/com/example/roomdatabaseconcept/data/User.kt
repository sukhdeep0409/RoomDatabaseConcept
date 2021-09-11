package com.example.roomdatabaseconcept.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User
constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String,
    val secondName: String,
    val age: Int
)
