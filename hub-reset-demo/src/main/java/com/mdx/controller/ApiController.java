package com.mdx.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.mdx.pojo.User;
import com.mdx.service.IUserService;
import com.mdx.util.PagedGridResult;
import com.mdx.util.R;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mengdl
 * @date 2023/12/28
 */

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class ApiController {

    private final IUserService userService;

    @GetMapping(value = "{id}")
    public R<User> test(@PathVariable("id") Long id) {
        return R.ok(userService.getById(id));
    }

    @GetMapping(value = "page")
    public R<PagedGridResult> page (@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return R.ok(PagedGridResult.setterPagedGridResult(page, userService.list(Wrappers.<User>lambdaQuery().eq(User::getStatus, 1))));
    }

}
