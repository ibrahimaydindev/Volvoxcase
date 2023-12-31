package com.ibrahimaydindev.volvoxcase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ibrahimaydindev.volvoxcase.model.News

@Database(
    entities = [News::class],
    version = 1
)
@TypeConverters(com.ibrahimaydindev.volvoxcase.database.TypeConverters::class)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun getArticleDao(): NewsDao
    companion object {
        @Volatile
        private var instance: NewsDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NewsDatabase::class.java,
                "news_db.db"
            ).build()
    }
}