package org.sierou.sign.impl;

import org.sierou.sign.service.SignService;
import org.springframework.stereotype.Service;

/**
 * sign service implements
 *
 * @author 王洪悦.{javayue@yeah.net}
 * @create 2018-01-09 下午9:43
 */
@Service
public class SignServiceImpl implements SignService<String>{

    /**
     * sign data
     *
     * @param key
     * @param data
     * @return
     * @throws Exception
     */
    @Override
    public String sign(String key, String data) throws Exception {
        return null;
    }

    /**
     * verify data
     *
     * @param key
     * @param content
     * @param data
     * @return
     * @throws Exception
     */
    @Override
    public String verify(String key, String content, String data) throws Exception {
        return null;
    }
}
