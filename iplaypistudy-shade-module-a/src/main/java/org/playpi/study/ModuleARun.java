package org.playpi.study;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 */

@Slf4j
public class ModuleARun {
    public static void main(String[] args) {
        log.info("====Hello World!");
        run();
        runGuava();
    }

    /**
     * 依赖b/c时,无法成功运行
     * <p>
     * 依赖b/c-shade时,可以成功运行
     */
    public static void run() {
        log.info("====开始执行module-a的代码");
        ModuleBRun.run();
        ModuleCRun.run();
        log.info("====module-a的代码执行完成");
    }

    /**
     * 依赖b/c时或者依赖b/c-shade时:
     * 在这里无法像module-c那样直接调用26.0-jre里面的方法,编译无法通过
     * 但是module-c里面的代码是单独处于模块里面,编译时无法检测,所以ModuleCRun.run()可以通过编译(编译阶段不会检测run里面的代码)
     * <p>
     * 所以:
     * 制作shade只是可以保证ModuleCRun.run()正常执行,并不能保证Strings.lenientFormat可用(连编译都无法通过)
     */
    public static void runGuava() {
        log.info("====开始执行module-a的guava v26.0-jre代码");
        Objects.ToStringHelper toStringHelper = Objects.toStringHelper(new Object());
        toStringHelper.add("in", "in");
        toStringHelper.add("out", "out");
        log.info("====[{}]", toStringHelper.toString());
//        log.info("====[{}]", Strings.lenientFormat("", "in", "out"));
        log.info("====module-a的guava v26.0-jre代码执行完成");
    }

}
