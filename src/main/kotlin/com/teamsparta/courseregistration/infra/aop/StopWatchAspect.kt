package com.teamsparta.courseregistration.infra.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch

@Component
@Aspect
class StopWatchAspect {


    private val  logger = LoggerFactory.getLogger("Execution Time Logger")

    @Around("@annotation(com.teamsparta.courseregistration.infra.aop.StopWatch)")
    fun run(joinPoint: ProceedingJoinPoint): Any {
        val stopWatch = StopWatch() // 코드 실행 시간을 측정


        stopWatch.start() // 측정 시작
        val result = joinPoint.proceed() // AspectJ 에서 제공하는 ProceedingJoinPoint 객체의 proceed 메서드 - 원래의 메서드 호출을 실행한다.
        stopWatch.stop() // 측정 끝

        val methodName = joinPoint.signature.name
        val methodArguments = joinPoint.args


        val timeElapsedMs = stopWatch.totalTimeMillis // 밀리 초 단위로 timeElapsedMs 변수에 저장 totalTimeMillis는 측정한 전체 실행 시간을 반환하는 메서드
        logger.info("Method Name: $methodName | Arguments: ${methodArguments.joinToString(", ")} | Execution Time : ${timeElapsedMs}ms ")
        return result
    }
}