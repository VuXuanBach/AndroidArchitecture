package com.ea.myapplication.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.ea.myapplication.entity.Habit

@Dao
interface HabitDao {

    @Insert
    fun insert(habit: Habit)

    @Delete
    fun delete(habit: Habit)

    @Query("DELETE FROM HabitClass")
    fun deleteAll()

    @Query("SELECT * FROM HabitClass ORDER BY Habit ASC")
    fun getAllHabits(): LiveData<List<Habit>>

}