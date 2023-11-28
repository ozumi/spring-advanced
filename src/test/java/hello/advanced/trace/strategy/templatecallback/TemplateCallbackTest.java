package hello.advanced.trace.strategy.templatecallback;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    /*
    템플릿 콜백 패턴 - 익명 내부 클래스
     */
    @Test
    void callbackV1() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("logic1 execute");
            }
        });
        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("logic2 execute");
            }
        });
    }

    /*
템플릿 콜백 패턴 - 람다
 */
    @Test
    void callbackV2() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> log.info("logic1 execute"));
        template.execute(() -> log.info("logic2 execute"));
    }
}
