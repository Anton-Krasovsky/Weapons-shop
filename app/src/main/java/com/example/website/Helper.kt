package com.example.website

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Helper(
    val context: Context,
    val factory: SQLiteDatabase.CursorFactory?
) : SQLiteOpenHelper(context, "appUserBase", factory, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val user = "CREATE TABLE users(id INT PRIMARY KEY, login TEXT, email TEXT, password TEXT)"
        db!!.execSQL(user)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun addUser(user: User){
        val userData = ContentValues()
        userData.put("login", user.login)
        userData.put("email", user.email)
        userData.put("password", user.password)
        val db = this.writableDatabase
        db.insert("users", null, userData)
        db.close()
    }

    fun getUser(login: String, password: String): Boolean {
        val bd = this.readableDatabase
        val result = bd.rawQuery("SELECT * FROM users WHERE login = '$login' " +
                "AND password = '$password'", null)
        return result.moveToFirst()
    }
}