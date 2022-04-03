package com.gdsc.todo.data.room

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.gdsc.todo.data.entity.ToDoEntity
import com.gdsc.todo.data.local.ToDoDao

@Database(
    entities = [ToDoEntity::class],
    version = 2,
    autoMigrations = [
        AutoMigration (from = 1, to = 2)
    ]
)
abstract class Database : RoomDatabase() {

    abstract fun toDoDao(): ToDoDao
}