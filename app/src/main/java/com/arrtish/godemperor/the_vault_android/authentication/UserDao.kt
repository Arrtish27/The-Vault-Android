package com.arrtish.godemperor.the_vault_android.authentication

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE userId = :id")
    suspend fun getUserById(id: String): User?

    @Query("SELECT * FROM users WHERE userEmail = :email AND userPhoneNumber = :phoneNumber LIMIT 1")
    suspend fun getUserByEmailAndPhone(email: String, phoneNumber: String): User?

    @Delete
    suspend fun delete(user: User)
}
