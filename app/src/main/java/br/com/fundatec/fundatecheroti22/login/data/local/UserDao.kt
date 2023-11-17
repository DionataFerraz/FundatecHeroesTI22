package br.com.fundatec.fundatecheroti22.login.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.Date

@Dao
interface UserDao {
    @Insert
    fun insertUser(userEntity: UserEntity)

    @Query("SELECT date FROM user_table")
    fun getUserDate(): Date?

    @Query("DELETE FROM user_table")
    fun clearCache()
}