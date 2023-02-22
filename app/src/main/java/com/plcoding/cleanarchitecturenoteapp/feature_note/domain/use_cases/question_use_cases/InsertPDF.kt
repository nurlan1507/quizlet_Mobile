package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases.question_use_cases

import android.util.Log
import com.itextpdf.text.pdf.PdfReader
import com.itextpdf.text.pdf.parser.PdfTextExtractor
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Answer
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Question
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.QuestionAndAnswer
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.QuestionRepository

class InsertPDF(  private val noteRepository: NoteRepository, private val questionRepository: QuestionRepository) {
    suspend operator fun invoke(pdfReader: PdfReader, noteId: Long): List<QuestionAndAnswer> {
        var questionWithAnswers: MutableList<QuestionAndAnswer> = mutableListOf()
        var newQuestionWithAnswer: QuestionAndAnswer? = null
        val pageCount = pdfReader.numberOfPages
        Log.d("PAGECOUNT", pageCount.toString())
        for (pageNum in 1..pageCount) {
            val pageText = PdfTextExtractor.getTextFromPage(pdfReader, pageNum)
            var lines = pageText.split("\n")
            var mi = 0
            var answerArr: MutableList<Answer> = mutableListOf()
            while (mi < lines.size) {
                if (lines[mi].trim().matches(Regex("Question \\d+"))) {
                    answerArr = mutableListOf()
                    mi = mi + 3
                    var question = lines[mi]
                    if (lines[mi].startsWith("Complete") || lines[mi].startsWith("Mark") || lines[mi].startsWith("a. ") || lines[mi].startsWith("b. ") || lines[mi].startsWith("c. ") || lines[mi].startsWith("d. ")) {
                        mi = mi + 1
                    }
                    else {
                        if (lines[mi + 1].startsWith("a. ") || lines[mi + 1].startsWith("b. ") || lines[mi + 1].startsWith(
                                "c. "
                            ) || lines[mi + 1].startsWith("d. ")
                        ) {
//                            answerArr.add(Answer(text = lines[mi+1], isCorrect = false, questionId = 1))
                        } else {
                            question = question + " " + lines[mi + 1]
                        }
                        mi = mi + 1
                        var newQuestion = Question(quizId = noteId, text = question)
                        newQuestionWithAnswer =
                            QuestionAndAnswer(question = newQuestion, answers = answerArr)
                        questionWithAnswers.add(newQuestionWithAnswer)
                    }
                }
                else {
                    if (lines[mi].startsWith("a. ") || lines[mi].startsWith("b. ") || lines[mi].startsWith(
                            "c. "
                        ) || lines[mi].startsWith("d. ")
                    ) {
                        answerArr.add(Answer(text = lines[mi], isCorrect = false, questionId = 1))
                        questionWithAnswers[questionWithAnswers.size - 1] = newQuestionWithAnswer!!.copy(answers = answerArr )
                        mi = mi + 1
                    } else mi = mi + 1
                }
            }
        }
        Log.d("SIZEASS", questionWithAnswers.size.toString())
        questionWithAnswers.forEach {
            var questionId = questionRepository.createQuestion(it.question)
            Log.d("QUESTIONID", questionId.toString())
            it.answers.forEach{
                Log.d("ANSWER", it.text)

                questionRepository.addAnswer(Answer(questionId = questionId, text = it.text, isCorrect = it.isCorrect))
                Log.d("ANSWER", it.text)
            }
        }

        Log.d("ASAT", questionWithAnswers.size.toString())
        return questionWithAnswers
    }
}