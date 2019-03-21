package com.ea.myapplication.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "HabitClass")
class Habit(@PrimaryKey @ColumnInfo(name = "Habit") val habit: String)