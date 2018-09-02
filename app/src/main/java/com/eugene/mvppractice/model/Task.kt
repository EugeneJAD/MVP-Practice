package com.eugene.mvppractice.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Eugene on 9/2/2018.
 */
@Entity(tableName = "tasks")
data class Task(var content: String, @PrimaryKey(autoGenerate = true) val id: Int = 0)