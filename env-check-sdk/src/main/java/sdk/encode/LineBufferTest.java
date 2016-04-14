package sdk.encode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import java.util.Properties;

import net.csdn.common.collect.Tuple;

/**
 * Created by hj on 16/5/11.
 */
public class LineBufferTest {

    public static void main(String[] args) throws Exception {

        //        System.setProperty("file.encoding", "GBK");
        //        System.setProperty("sun.jnu.encoding", "GBK");

        String filePath = args[0];
        String charsetName = args[1];
        File file = new File(filePath);
        Reader reader;

        if("1".equals(args[2])) {
            reader = new InputStreamReader(new FileInputStream(file), charsetName);
        } else{
            reader = new FileReader(file);
        }

        LineReader lineReader = new LineReader(reader);

        Tuple<String, String> tuple;
        while (true) {
            tuple = lineReader.readLineTuple();
            if (tuple == null) {
                break;
            }
            System.out.println(tuple.getV1());
        }

        Map<String, String> getenv = System.getenv();
        Properties properties = System.getProperties();

        System.out.println("====");

        System.out.println(getenv.toString());
        System.out.println(properties.toString());


    }
}
