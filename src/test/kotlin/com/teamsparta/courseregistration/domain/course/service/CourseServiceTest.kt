package com.teamsparta.courseregistration.domain.course.service

import com.teamsparta.courseregistration.domain.course.model.QCourse.course
import com.teamsparta.courseregistration.domain.course.repository.CourseRepository
import com.teamsparta.courseregistration.domain.courseapplication.repository.CourseApplicationRepository
import com.teamsparta.courseregistration.domain.exception.ModelNotFoundException
import com.teamsparta.courseregistration.domain.lecture.repository.LectureRepository
import com.teamsparta.courseregistration.domain.user.repository.UserRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.spring.SpringExtension
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull


@SpringBootTest
@ExtendWith(MockKExtension::class)
class CourseServiceTest : BehaviorSpec({
    extensions(SpringExtension)

    afterContainer {
        clearAllMocks()
    }

    val courseRepository = mockk<CourseRepository>()
    val lectureRepository = mockk<LectureRepository>()
    val applicationRepository = mockk<CourseApplicationRepository>()
    val userRepository = mockk<UserRepository>()

    val courseService = CourseServiceImpl(courseRepository, lectureRepository, applicationRepository, userRepository)

    Given("Course 목록이 존재하지 않을 때") {
        When("특정 Course를 요청하면") {
            Then("ModelNotFoundException이 발생해야한다.") {

                // given
                val courseId = 1L
                every { courseRepository.findByIdOrNull(any()) } returns null


                // when
                shouldThrow<ModelNotFoundException> {
                    courseService.getCourseById(courseId)
                }
            }
        }

    }

})