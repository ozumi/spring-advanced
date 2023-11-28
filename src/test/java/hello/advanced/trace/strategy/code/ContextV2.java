package hello.advanced.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

/*
전략을 파라미터로 전달 받는 형식. 실행시점에 원하는 전략 선택 가능
 */
@Slf4j
public class ContextV2 {
    public void execute(Strategy strategy){
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 상속
        strategy.call();
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("logic1 totalTime={}", resultTime);

    }
}
