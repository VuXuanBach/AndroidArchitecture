package com.ea.myapplication.repo

import android.arch.lifecycle.LiveData
import com.ea.myapplication.MyApplication
import com.ea.myapplication.dao.HabitDao
import com.ea.myapplication.dao.HabitRoomDatabase
import com.ea.myapplication.entity.Habit
import java.util.*

class HabitRepository(application: MyApplication) {

    private val habitDao: HabitDao?
    private val habits: LiveData<List<Habit>>

    init {
        val habitRoomDatabase = HabitRoomDatabase.getDatabase(application)
        habitDao = habitRoomDatabase?.wordDao()!!
        habits = habitDao.getAllHabits()
    }

    fun getAllHabits(): LiveData<List<Habit>> {
        return habits
    }

    fun insert(habit: Habit) {
        habitDao?.insert(habit)
    }
}