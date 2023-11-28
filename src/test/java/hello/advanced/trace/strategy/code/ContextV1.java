package hello.advanced.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

/*
필드에 전략을 보관하는 방식. 선 조립 후 실행
 */
@Slf4j
public class ContextV1 {
    private Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(){
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 상속
        strategy.call();
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("logic1 totalTime={}", resultTime);
    }

}
