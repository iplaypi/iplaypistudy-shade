package org.playpi.study;

import com.google.common.base.Objects;
import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 */

@Slf4j
public class ModuleBRun {
    public static void main(String[] args) {
        log.info("====Hello World!");
        run();
    }

    public static void run() {
        // 这个方法在v19.0中有,在v26.0-jre中没有
        log.info("====开始执行module-b的代码");
        Objects.ToStringHelper toStringHelper = Objects.toStringHelper(new Object());
        toStringHelper.add("in", "in");
        toStringHelper.add("out", "out");
        log.info("====[{}]", toStringHelper.toString());
        log.info("====module-b的代码执行完成");
    }

}
