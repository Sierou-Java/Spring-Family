package org.sierou.service;

import org.family.result.Result;
import org.sierou.aop.annotation.ControResult;
import org.springframework.stereotype.Service;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-29 下午5:02
 */

@Service(value = "resultService")
public class ResultService {

    @ControResult(value = "/con")
    public Integer resultService(){
        System.out.println("ResultService.resultService");
        return new Integer(8);
    }
}
