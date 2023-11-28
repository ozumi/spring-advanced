package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.ContextV1;
import hello.advanced.trace.strategy.code.Strategy;
import hello.advanced.trace.strategy.code.StrategyLogic1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {
    @Test
    void strategyMethodV0() {
        logic1();
        logic2();
    }
    private void logic1() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("logic1 execute");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("logic1 totalTime={}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("logic1 execute");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("logic2 totalTime={}", resultTime);
    }

    /*
    전략 패턴 사용
     */
    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        StrategyLogic1 strategyLogic2 = new StrategyLogic1();
        ContextV1 contextV2 = new ContextV1(strategyLogic1);
        contextV2.execute();
    }

    /*
    익명 내부 클래스 사용
     */
    @Test
    void strategyV2() {
        Strategy strategyLogic1 = new Strategy() {
            @Override
            public void call() {
                log.info("logic1 execute");
            }
        };
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        Strategy strategyLogic2 = new Strategy() {
            @Override
            public void call() {
                log.info("logic2 execute");
            }
        };
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }

    /*
    익명 내부 클래스 편하게 사용
     */
    @Test
    void strategyV3() {
        ContextV1 contextV1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("logic1 execute");
            }
        });
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("logic2 execute");
            }
        });
        contextV2.execute();
    }

    /*
    lambda 사용 : 인터페이스에 method가 한 개 인 경우 사용 가능
     */
    @Test
    void strategyV4() {
        ContextV1 contextV1 = new ContextV1(() -> log.info("logic1 execute"));
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(() -> log.info("logic2 execute"));
        contextV2.execute();
    }
}

