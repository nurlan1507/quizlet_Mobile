package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model

import androidx.room.*



@Entity(tableName = "questions")
data class Question(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="question_id")
    val id:Int?=null,
    @ColumnInfo(name="quiz_id")
    val quizId:Long,
    val text:String
)


@Entity(tableName="answers")
data class Answer(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="answer_id")
    val id:Long ?= null,
    @ColumnInfo(name = "question_id")
    val questionId:Long,
    val text:String,
    val isCorrect:Boolean
)

data class QuestionAndAnswer(
    @Embedded
    val question:Question,
    @Relation(
        parentColumn = "question_id",
        entityColumn = "question_id",
    )
    val answers:List<Answer>
)