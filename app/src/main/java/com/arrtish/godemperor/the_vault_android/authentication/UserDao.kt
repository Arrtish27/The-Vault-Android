package com.arrtish.godemperor.the_vault_android.authentication

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arrtish.godemperor.the_vault_android.Character

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM users WHERE userEmail = :email AND userPassword = :password LIMIT 1")
    suspend fun getUser(email: String, password: String): User?

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE userId = :id")
    suspend fun getUserById(id: String): User?

    @Query("SELECT * FROM users WHERE userEmail = :email")
    suspend fun getUserByEmail(email: String): User?

    @Delete
    suspend fun delete(user: User)
}
