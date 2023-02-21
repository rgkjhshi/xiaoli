package com.mk.xiaoli.common;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 单元测试基础类
 *
 * @author song.shi
 * @since 2018-01-17
 */
public class UnitTest {
    private static final Logger log = LoggerFactory.getLogger(UnitTest.class);

    @Test
    public void test() {
        log.info("测试基累正确执行，不要改");
    }

}