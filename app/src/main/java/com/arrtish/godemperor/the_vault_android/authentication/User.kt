package com.arrtish.godemperor.the_vault_android.authentication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Int = 0,
    //need to change to foreign key
//    var userName: String,
    var userEmail: String,
    var userPassword: String,
)
