package hello.advanced.trace.strategy.templatecallback;

import lombok.extern.slf4j.Slf4j;

/*
템플릿 콜백 패턴. 전략 패턴 중 전략을 파라미터로 전달받는 방식과 동일하다
 */
@Slf4j
public class TimeLogTemplate {
    public void execute(Callback callback){
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 상속
        callback.call();
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("logic1 totalTime={}", resultTime);
    }
}
