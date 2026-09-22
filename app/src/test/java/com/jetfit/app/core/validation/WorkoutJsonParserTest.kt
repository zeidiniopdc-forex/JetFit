package com.jetfit.app.core.validation

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class WorkoutJsonParserTest {
    private val parser = WorkoutJsonParser()

    @Test
    fun blankJsonReturnsPersianError() {
        assertEquals(
            WorkoutJsonResult.Error("متن JSON خالی است"),
            parser.parse(" ")
        )
    }

    @Test
    fun invalidJsonReturnsError() {
        assertTrue(parser.parse("{not-json}") is WorkoutJsonResult.Error)
    }

    @Test
    fun validProgramIsParsed() {
        val result = parser.parse("""
            {"programName":"حجم","duration":"۸ هفته","days":[]}
        """.trimIndent())
        assertTrue(result is WorkoutJsonResult.Success)
        assertEquals("حجم", (result as WorkoutJsonResult.Success).program.programName)
    }
}
