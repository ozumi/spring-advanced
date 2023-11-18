package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {
    String nameStore;

    public String logic(String name) {
        log.info("Save name={} -> nameStore={}", name, nameStore);
        nameStore = name;
        sleep(1000);
        log.info("Find nameStore={}", nameStore);
        return nameStore;
    }

    private void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
