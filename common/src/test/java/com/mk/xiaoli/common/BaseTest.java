package com.mk.xiaoli.common;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 集成测试基础类
 *
 * @author song.shi
 * @since 2018-01-17
 */
@SpringBootTest(classes = TestApplication.class)
public class BaseTest {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BaseTest.class);

    @Test
    public void test() {
        log.info("测试基累正确执行，不要改");
    }
}