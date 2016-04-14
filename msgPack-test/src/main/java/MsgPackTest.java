import static org.msgpack.template.Templates.TString;
import static org.msgpack.template.Templates.TValue;
import static org.msgpack.template.Templates.tMap;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;

import org.msgpack.MessagePack;
import org.msgpack.template.Template;
import org.msgpack.type.Value;
import org.msgpack.unpacker.Converter;
import org.msgpack.unpacker.Unpacker;
import org.xerial.snappy.Snappy;

/**
 * Created by hj on 16/5/10.
 */
public class MsgPackTest {
    public static void main(String[] args) throws Exception {
        String filePath = "/Users/hj/Downloads/sm.log";
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        byte[] b = new byte[fileInputStream.available()];
        fileInputStream.read(b);

        ByteBuffer byteBuffer = ByteBuffer.wrap(b);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        short length = byteBuffer.getShort();
        byte[] dst = new byte[length];
        byteBuffer.get(dst);


        byte[] uncompressed = Snappy.uncompress(dst);


        MessagePack msgpack = new MessagePack();
        ByteArrayInputStream in = new ByteArrayInputStream(uncompressed);
        Unpacker unpacker = msgpack.createUnpacker(in);

        Template<Map<String, Value>> mapTmpl = tMap(TString, TValue);
        Map<String, Value> dstMap = unpacker.read(mapTmpl);
        System.out.println(dstMap);

        for(Map.Entry<String, Value> entry : dstMap.entrySet() ) {
            String key = entry.getKey();
            Value value = entry.getValue();
            String valueStr = new Converter(value).read(TString);
            System.out.println(key+ ": "+valueStr);
        }




    }
}
