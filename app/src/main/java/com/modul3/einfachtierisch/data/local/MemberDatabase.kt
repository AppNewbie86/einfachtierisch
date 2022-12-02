package com.modul3.einfachtierisch.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.modul3.einfachtierisch.data.models.MemberInformationen

@Database(entities = [MemberInformationen::class], version = 1)
abstract class MemberDatabase : RoomDatabase() {

    abstract val memberDatabaseDao: MemberDatabaseDao
}


// Singelton Pattern
private lateinit var INSTANCE: MemberDatabase

// falls es keine gibt wird sie gebaut
fun getDatabase(context: Context): MemberDatabase {
    synchronized(MemberDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                MemberDatabase::class.java,
                "member_database_profildatas"
            )
                .build()
        }
    }
    return INSTANCE
}
