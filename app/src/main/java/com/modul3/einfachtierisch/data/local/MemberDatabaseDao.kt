package com.modul3.einfachtierisch.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.modul3.einfachtierisch.data.models.MemberInformationen

@Dao
interface MemberDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // in SQL INSERT
    suspend fun insert(memberInformationen: MemberInformationen)

    @Update // in SQL UPDATE
    suspend fun update(memberInformationen: kotlin.Unit)

    @Query("SELECT * FROM MemberInformationen")
    fun getAll(): LiveData<List<MemberInformationen>>

    @Query("SELECT * FROM MemberInformationen WHERE id = :id")
    fun getById(id: Int): MemberInformationen

    @Query("DELETE FROM MemberInformationen WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Query("DELETE from MemberInformationen")
    suspend fun deleteAll()
}
