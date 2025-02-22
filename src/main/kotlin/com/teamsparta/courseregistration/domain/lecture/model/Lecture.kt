package com.teamsparta.courseregistration.domain.lecture.model

import com.teamsparta.courseregistration.domain.course.model.Course
import com.teamsparta.courseregistration.domain.lecture.dto.LectureResponse
import jakarta.persistence.*

@Entity
@Table(name = "lecture")
class Lecture(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "video_url", nullable = false)
    var videoUrl: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    val course: Course

)
fun Lecture.toResponse(): LectureResponse {

    return LectureResponse(
        id = id!!,
        title = title,
        videoUrl = videoUrl,
    )
}
