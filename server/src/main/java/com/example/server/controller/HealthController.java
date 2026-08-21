package com.example.server.controller;

import com.example.server.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** 健康检查：GET /health 返回 UP，供部署探活。 */
@RestController
public class HealthController {

    @GetMapping("/health")
    public Result<String> health() {
        return Result.ok("UP");
    }
}
