package com.arrtish.godemperor.the_vault_android.appdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arrtish.godemperor.the_vault_android.appdb.character.BaseCharacterEntity
import com.arrtish.godemperor.the_vault_android.appdb.character.CharacterDao
import com.arrtish.godemperor.the_vault_android.appdb.user.User
import com.arrtish.godemperor.the_vault_android.appdb.user.UserDao

@Database(entities = [User::class, BaseCharacterEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun characterDao(): CharacterDao
}