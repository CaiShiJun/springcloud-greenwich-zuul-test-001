package org.github.caishijun.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "zuul-server")
public interface FeignExampleService {

    @GetMapping("/producer/hello")
    public String hello(@RequestParam(value = "name") String name);

}
