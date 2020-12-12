
package com.example.crazyquiz.db

import android.content.Context
import android.provider.SyncStateContract.Helpers.insert
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.crazyquiz.GameModel
import com.example.crazyquiz.R
import com.example.crazyquiz.db.Users
import com.example.crazyquiz.db.UsersDao


@Database(
    entities = [Users:: class, Question::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun UsersDao(): UsersDao
    abstract fun QuestionDao(): QuestionDao

    companion object {
        private const val DATABASE_NAME = "quiz_database"
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            INSTANCE ?: synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                )
                .allowMainThreadQueries()
                .addCallback(object : RoomDatabase.Callback() {

                    fun getStr(strId : Int) : String {
                        return context.getString(R.string.question_text_1)
                    }

                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                        val HARRY_POTTER = 1
                        val CATS_REPTILES = 2
                        val FOOD = 3
                        val TERROR = 4
                        val CULTURA_GENERAL = 5
                        val ARTE_GEOGRAFIA = 6

                        db.execSQL("INSERT INTO questions(pregunta, correcta, answer1, answer2, answer3, answer4, categoría) VALUES ('${getStr(R.string.question_text_1)}', 1, '${getStr(R.string.p1_respuesta_1)}', '${getStr(R.string.p1_respuesta_2)}', '${getStr(R.string.p1_respuesta_3)}', '${getStr(R.string.p1_respuesta_4)}',$HARRY_POTTER)")
                        db.execSQL("INSERT INTO questions(pregunta, correcta, answer1, answer2, answer3, answer4, categoría) VALUES ('${getStr(R.string.question_text_2)}', 1, '${getStr(R.string.p2_respuesta_1)}', '${getStr(R.string.p2_respuesta_2)}', '${getStr(R.string.p2_respuesta_3)}', '${getStr(R.string.p2_respuesta_4)}',$HARRY_POTTER)")
                        db.execSQL("INSERT INTO questions(pregunta, correcta, answer1, answer2, answer3, answer4, categoría) VALUES ('${getStr(R.string.question_text_3)}', 1, '${getStr(R.string.p3_respuesta_1)}', '${getStr(R.string.p3_respuesta_2)}', '${getStr(R.string.p3_respuesta_3)}', '${getStr(R.string.p3_respuesta_4)}',$HARRY_POTTER)")
                        db.execSQL("INSERT INTO questions(pregunta, correcta, answer1, answer2, answer3, answer4, categoría) VALUES ('${getStr(R.string.question_text_4)}', 1, '${getStr(R.string.p4_respuesta_1)}', '${getStr(R.string.p4_respuesta_2)}', '${getStr(R.string.p4_respuesta_3)}', '${getStr(R.string.p4_respuesta_4)}',$HARRY_POTTER)")
                        db.execSQL("INSERT INTO questions(pregunta, correcta, answer1, answer2, answer3, answer4, categoría) VALUES ('${getStr(R.string.question_text_5)}', 1, '${getStr(R.string.p5_respuesta_1)}', '${getStr(R.string.p5_respuesta_2)}', '${getStr(R.string.p5_respuesta_3)}', '${getStr(R.string.p5_respuesta_4)}',$HARRY_POTTER)")
                        db.execSQL("INSERT INTO questions(pregunta, correcta, answer1, answer2, answer3, answer4, categoría) VALUES ('${getStr(R.string.question_text_6)}', 1, '${getStr(R.string.p6_respuesta_1)}', '${getStr(R.string.p6_respuesta_2)}', '${getStr(R.string.p6_respuesta_3)}', '${getStr(R.string.p6_respuesta_4)}',$HARRY_POTTER)")
                        db.execSQL("INSERT INTO questions(pregunta, correcta, answer1, answer2, answer3, answer4, categoría) VALUES ('${getStr(R.string.question_text_7)}', 1, '${getStr(R.string.p7_respuesta_1)}', '${getStr(R.string.p7_respuesta_2)}', '${getStr(R.string.p7_respuesta_3)}', '${getStr(R.string.p7_respuesta_4)}',$HARRY_POTTER)")
                        db.execSQL("INSERT INTO questions(pregunta, correcta, answer1, answer2, answer3, answer4, categoría) VALUES ('${getStr(R.string.question_text_8)}', 1, '${getStr(R.string.p8_respuesta_1)}', '${getStr(R.string.p8_respuesta_2)}', '${getStr(R.string.p8_respuesta_3)}', '${getStr(R.string.p8_respuesta_4)}',$HARRY_POTTER)")
                        db.execSQL("INSERT INTO questions(pregunta, correcta, answer1, answer2, answer3, answer4, categoría) VALUES ('${getStr(R.string.question_text_9)}', 1, '${getStr(R.string.p9_respuesta_1)}', '${getStr(R.string.p9_respuesta_2)}', '${getStr(R.string.p9_respuesta_3)}', '${getStr(R.string.p9_respuesta_4)}',$HARRY_POTTER)")
                        db.execSQL("INSERT INTO questions(pregunta, correcta, answer1, answer2, answer3, answer4, categoría) VALUES ('${getStr(R.string.question_text_10)}', 1, '${getStr(R.string.p10_respuesta_1)}', '${getStr(R.string.p10_respuesta_2)}', '${getStr(R.string.p10_respuesta_3)}', '${getStr(R.string.p10_respuesta_4)}',$HARRY_POTTER)")
                        /*
                        db.execSQL("INSERT INTO themes(id, description) VALUES(0, 'Cine')")
                        db.execSQL("INSERT INTO themes(id, description) VALUES(1, 'Física')")
                        db.execSQL("INSERT INTO themes(id, description) VALUES(2, 'Historia')")
                        db.execSQL("INSERT INTO themes(id, description) VALUES(3, 'Matemáticas')")
                        db.execSQL("INSERT INTO themes(id, description) VALUES(4, 'Videojuegos')")
                        db.execSQL("INSERT INTO themes(id, description) VALUES(5, 'Arte')")
                        */
                    }
                }).build()
            }
            return INSTANCE
        }
    }
}