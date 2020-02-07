package org.playpi.study;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 */

@Slf4j
public class ModuleCRun {
    public static void main(String[] args) {
        log.info("====Hello World!");
        run();
    }

    public static void run() {
        log.info("====开始执行module-c的代码");
        // 这个方法在v26.0-jre中有,在v19.0中没有
        log.info("====[{}]", Strings.lenientFormat("", "in", "out"));
        log.info("====module-c的代码执行完成");
    }
}
