package org.sierou.controller.result;

import org.family.result.Result;
import org.sierou.aop.annotation.ControResult;
import org.sierou.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-29 下午5:00
 */
@RestController
public class ResultController {

    @Autowired
    private ResultService resultService;

    @RequestMapping(value = "/result")
    public Result<Integer> result(){
        return new Result<Integer>(resultService.resultService());
    }
}
