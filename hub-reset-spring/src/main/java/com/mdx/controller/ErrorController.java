package com.mdx.controller;

import com.mdx.pojo.Log;
import com.mdx.service.ILogService;
import com.mdx.util.R;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mengdl
 * @date 2024/01/05
 */
@RestController
@RequestMapping(value = "/error")
@AllArgsConstructor
@Slf4j
public class ErrorController {

    private final ILogService logService;

    @GetMapping(value = "{id}")
    public R<Log> test(@PathVariable("id") Long id) {
        log.trace("trace测试数据入参->{}", id);
        log.debug("debug测试数据入参->{}", id);
        log.info("info测试数据入参->{}", id);
        log.warn("warn测试数据入参->{}", id);
        log.error("error测试数据入参->{}", id);
        try {
            throw new RuntimeException("打印异常");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("错误日志", e);
        }
        return R.ok(logService.getById(id));
    }

}
