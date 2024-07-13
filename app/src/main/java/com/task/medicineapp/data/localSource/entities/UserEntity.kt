package com.task.medicineapp.data.localSource.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
data class UserEntity (
    @PrimaryKey
    @ColumnInfo(name = "userName") var userName: String,
    @ColumnInfo(name = "userPass") var userPass: String,
)