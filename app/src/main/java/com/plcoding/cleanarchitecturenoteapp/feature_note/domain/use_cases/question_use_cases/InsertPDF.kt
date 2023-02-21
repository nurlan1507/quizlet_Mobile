package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases.question_use_cases

import android.util.Log
import com.itextpdf.text.pdf.PdfReader
import com.itextpdf.text.pdf.parser.PdfTextExtractor
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.QuestionRepository

class InsertPDF(    private val noteRepository: NoteRepository,
    private val questionRepository: QuestionRepository,

    ) {

    suspend operator fun invoke(pdfReader: PdfReader){
        val pageCount = pdfReader.numberOfPages
        Log.d("PAGECOUNT", pageCount.toString())
        for(pageNum  in 1..pageCount){
            val pageText = PdfTextExtractor.getTextFromPage(pdfReader, pageNum)
            var lines = pageText.split("\n")

            var mi = 0

            while (mi < lines.size) {
                if (lines[mi].trim().matches(Regex("Question \\d+"))) {
                    mi = mi + 3
                    var question = lines[mi]
                    if(lines[mi].startsWith("Complete") || lines[mi].startsWith("Mark") || lines[mi].startsWith("a. ") || lines[mi].startsWith("b. ") || lines[mi].startsWith("c. ") || lines[mi].startsWith("d. ")) {
                        mi = mi + 1
                    } else {
                        if(  lines[mi+1].startsWith("a. ") || lines[mi+1].startsWith("b. ") || lines[mi+1].startsWith("c. ") || lines[mi+1].startsWith("d. ")){
                        }else{
                            question = question + " " + lines[mi+1]
                        }
                        mi = mi + 1
                        Log.d("mimino", question)
                    }
                } else {
                    if (lines[mi].startsWith("a. ") || lines[mi].startsWith("b. ") || lines[mi].startsWith("c. ") || lines[mi].startsWith("d. ")
                    ) {
                        Log.d("miminoAnswers", lines[mi])
                        mi = mi + 1
                    } else mi = mi + 1
                }
            }
        }

    }

}