package com.teamsparta.courseregistration.domain.course.dto

import com.teamsparta.courseregistration.domain.lecture.dto.LectureResponse

data class CourseResponse(
    val id: Long,
    val title: String,
    val description: String?,
    val status: String,
    val maxApplicants: Int,
    val numApplicants: Int,
    val lectures: List<LectureResponse>
)

//fun main(args: Array<String>) {
//    val courseResponse1 = CourseResponse(
//        id = 1L,
//        title = "abc",
//        description = null,
//        status = "CLOSED",
//        maxApplicants = 30,
//        numApplicants = 30
//    )
//
//    val courseResponse2 = CourseResponse(
//        id = 1L,
//        title = "abc",
//        description = null,
//        status = "CLOSED",
//        maxApplicants = 30,
//        numApplicants = 30
//    )
//
//    println(courseResponse1 == courseResponse2)
//}