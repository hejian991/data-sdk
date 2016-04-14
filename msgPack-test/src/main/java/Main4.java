import static org.msgpack.template.Templates.*;
import static org.msgpack.template.Templates.tMap;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Map;

import org.msgpack.MessagePack;
import org.msgpack.packer.Packer;
import org.msgpack.template.Template;
import org.msgpack.type.Value;
import org.msgpack.unpacker.Unpacker;

import net.sf.json.JSONObject;

public class Main4 {
    public static void main(String[] args) throws Exception {
        MessagePack msgpack = new MessagePack();

        // Create templates for serializing/deserializing List and Map objects
//        Template<Map<String, String>> mapTmpl = tMap(TString, TString);
        Template<Map<String, Value>> mapTmpl = tMap(TString, TValue);

        //
        // Serialization
        //
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Packer packer = msgpack.createPacker(out);

        // Serialize Map object
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("sadayuki", "furuhashi");
//        map.put("muga", "nishizawa");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sadayuki", "furuhashi");
        jsonObject.put("muga", "nishizawa");
        jsonObject.put("a", 12);
        packer.write(jsonObject); // Map object

        //
        // Deserialization
        //
        byte[] bytes = out.toByteArray();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        Unpacker unpacker = msgpack.createUnpacker(in);

        // to Map object
        Map<String, Value> dstMap = unpacker.read(mapTmpl);

        System.out.println(dstMap);
    }
}