package com.arrtish.godemperor.the_vault_android.appdb.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Int = 0,
    val username: String,
    val email: String,
    val password: String,
    val numberOfCharacters: Int
)