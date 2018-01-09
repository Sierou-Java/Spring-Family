package org.sierou.sign.service;

/**
 * sign service
 *
 * @author 王洪悦.{javayue@yeah.net}
 * @create 2018-01-09 下午9:40
 */
public interface SignService<T> {

    /**
     * sign data
     * @param key
     * @param data
     * @return
     * @throws Exception
     */
    String sign(String key, T data) throws Exception;

    /**
     * verify data
     * @param key
     * @param content
     * @param data
     * @return
     * @throws Exception
     */
    String verify(String key, T content, T data) throws Exception;
}
