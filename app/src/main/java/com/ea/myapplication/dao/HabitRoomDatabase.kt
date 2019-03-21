package com.ea.myapplication.dao

import android.arch.persistence.db.SupportSQLiteOpenHelper
import android.arch.persistence.room.*
import android.content.Context
import com.ea.myapplication.entity.Habit

@Database(entities = [Habit::class], version = 1)
abstract class HabitRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): HabitDao

    companion object {
        private var INSTANCE: HabitRoomDatabase? = null

        fun getDatabase(context: Context): HabitRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(HabitRoomDatabase::class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            HabitRoomDatabase::class.java,
                            "habit_database"
                        )
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}