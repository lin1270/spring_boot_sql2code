package com.pactera.jep.service.base.web.controller;

import com.pactera.jep.autoconfigure.web.controller.BaseRestController;
import com.pactera.jep.orm.Filter;
import com.pactera.jep.orm.Order;
import com.pactera.jep.orm.Page;
import com.pactera.jep.service.base.model.TestAreaInfo;
import com.pactera.jep.service.base.service.TestAreaInfoService;
import com.pactera.jep.web.code.WebCode;
import com.pactera.jep.web.code.WebHeaderCode;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/testAreaInfo")
public class TestAreaInfoRestController extends BaseRestController<TestAreaInfo> {
    private static Logger logger = LoggerFactory.getLogger(TestAreaInfoRestController.class);

    @Autowired
    private TestAreaInfoService service;

    /**
     * 为列表页面做数据准备
     */
    @Override
    protected void prepareQuery(@ApiIgnore @RequestHeader(WebHeaderCode.X_USER_TOKEN) String token, Page<TestAreaInfo> page, List<Filter> filters, List<Order> orders, HttpServletRequest request) {
        service.query(page, filters, orders);
    }
}
