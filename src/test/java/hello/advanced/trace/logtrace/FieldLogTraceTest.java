package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldLogTraceTest {
    FieldLogTrace fieldLogTrace = new FieldLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus traceStatus1 = fieldLogTrace.begin("hi");
        TraceStatus traceStatus2 = fieldLogTrace.begin("hi2");
        fieldLogTrace.end(traceStatus2);
        fieldLogTrace.end(traceStatus1);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus traceStatus1 = fieldLogTrace.begin("hi");
        TraceStatus traceStatus2 = fieldLogTrace.begin("hi2");
        fieldLogTrace.exception(traceStatus2, new IllegalStateException());
        fieldLogTrace.exception(traceStatus1, new IllegalStateException());
    }
}