package com.mtjin.mvvmstudyapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mtjin.mvvmstudyapp.data.db.entities.User
import okhttp3.internal.Internal.instance

@Database(
    entities = [User::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {

        @Volatile //Volatile는 이 변수가 다른 스레드에 모두 즉각적으로 visible하게 해준다.
        private var instance: AppDatabase? = null
        //LOCK는 우리가 데이터베이스 인스턴스를 2개 생성하는걸 방지해준다.
        private val LOCK = Any()


        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MyDatabase.db"
            ).build()
    }
}