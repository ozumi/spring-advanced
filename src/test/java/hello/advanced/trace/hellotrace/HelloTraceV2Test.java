package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloTraceV2Test {
    @Test
    void begin_end() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus traceStatus = trace.begin("hello");
        TraceStatus traceStatus2 = trace.beginSync(traceStatus.getTraceId(), "hello");
        trace.end(traceStatus2);
        trace.end(traceStatus);
    }

    @Test
    void begin_exception() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus traceStatus = trace.begin("hello");
        TraceStatus traceStatus2 = trace.beginSync(traceStatus.getTraceId(), "hello");
        trace.end(traceStatus2);
        trace.exception(traceStatus, new IllegalStateException());
    }
}