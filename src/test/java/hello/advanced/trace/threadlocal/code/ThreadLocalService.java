package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

@Slf4j
public class ThreadLocalService {

    private ThreadLocal<String> nameStore = new ThreadLocal<>();

    public String logic(String name) {
        log.info("저장 name = {} -> nameStore = {}", name, nameStore.get());
        nameStore.set(name);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("조회 nameStore = {}", nameStore.get());
        return nameStore.get();
    }
}
