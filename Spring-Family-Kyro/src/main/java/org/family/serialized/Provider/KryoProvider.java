package org.family.serialized.Provider;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.family.serialized.SerializedProviderFacade;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-25 下午11:16
 */
public class KryoProvider implements SerializedProviderFacade {

    private Kryo kryo = new Kryo();

    public KryoProvider() {
        this.kryo.setReferences(false);
    }

    public byte[] toByteArray(Object object) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Output output = new Output(bos);
        this.kryo.writeClassAndObject(output, object);
        byte[] bs = output.toBytes();
        bos.close();
        output.close();
        return bs;
    }

    public String toSerialized(Object object) throws IOException {
        return (new BASE64Encoder()).encode(this.toByteArray(object)).replace("\n", "").replace("\r", "").trim();
    }

    public <T> T toObject(byte[] bs) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bs);
        Input input = new Input(bis);
        T t = (T)this.kryo.readClassAndObject(input);
        bis.close();
        input.close();
        return t;
    }

    public <T> T toObject(String str) throws IOException {
        return this.toObject((new BASE64Decoder()).decodeBuffer(str));
    }
}
