package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.edit_questions

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.QuestionAndAnswer
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases.question_use_cases.GetQuestionsWithAnswers
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases.question_use_cases.QuestionUseCases
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases.question_use_cases.SelectAnswer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class QuestionViewModel @Inject constructor(
    private val questionUseCases: QuestionUseCases,
):ViewModel(){
    init{
        onEvent(QuestionEvent.GetQuestionsAndAnswers(1))
    }
    private var _state = mutableStateOf<QuizQuestionState>(QuizQuestionState())
    val state = _state

    private var _currentQuestion = mutableStateOf<QuestionAndAnswer>(_state.value.questionList.get(0))

    fun onEvent(event: QuestionEvent){
        when(event){
            is QuestionEvent.SelectAnswer ->{

            }
            is QuestionEvent.DeleteQuestion -> {

            }
            is QuestionEvent.GetNextQuestion -> {

            }
            is QuestionEvent.UseChatGPT ->{

            }
            is QuestionEvent.GetQuestionsAndAnswers -> {
                questionUseCases.getQuestionsWithAnswers(event.quizId)
            }
        }
    }


}