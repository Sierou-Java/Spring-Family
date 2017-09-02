package org.family.serialized;

import org.family.serialized.Provider.KryoProvider;

import java.io.IOException;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-25 下午11:16
 */
public class Serializeds {

    private SerializedProviderFacade provider = new KryoProvider();

    public Serializeds() {
    }

    public byte[] toByteArray(Object object) throws IOException {
        return this.provider.toByteArray(object);
    }

    public String toSerialized(Object object) throws IOException {
        return this.provider.toSerialized(object);
    }

    public <T> T toObject(byte[] bytes) throws IOException {
        return this.provider.toObject(bytes);
    }

    public <T> T toObject(String str) throws IOException {
        return this.provider.toObject(str);
    }
}
