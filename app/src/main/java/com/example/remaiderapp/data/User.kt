package com.example.remaiderapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val Name: String,
    val Note: String,
    val date: String
    )