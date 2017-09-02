package org.family.serialized;

import java.io.IOException;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-25 下午11:16
 */
public interface SerializedProviderFacade {

    byte[] toByteArray(Object var1) throws IOException;

    String toSerialized(Object var1) throws IOException;

    <T> T toObject(byte[] var1) throws IOException;

    <T> T toObject(String var1) throws IOException;

}
