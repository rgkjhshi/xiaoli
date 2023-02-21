package com.mk.xiaoli.service.controller;

import com.mk.xiaoli.common.model.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shisong02
 * @since 2023-02-21
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public BaseResponse<?> testIndex() {
        return BaseResponse.getSuccessResponse("返回汉字不乱码");
    }

}
