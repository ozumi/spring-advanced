package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ThreadLocalLogTraceTest {
    private ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus traceStatus1 = trace.begin("hi");
        TraceStatus traceStatus2 = trace.begin("hi2");
        trace.end(traceStatus2);
        trace.end(traceStatus1);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus traceStatus1 = trace.begin("hi");
        TraceStatus traceStatus2 = trace.begin("hi2");
        trace.exception(traceStatus2, new IllegalStateException());
        trace.exception(traceStatus1, new IllegalStateException());
    }
}