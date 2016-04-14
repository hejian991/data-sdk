package data.test;

/**
 * Created by hj on 16/5/4.
 */

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.SequenceFile.Reader;
import org.apache.hadoop.io.Text;

public class TestSequenceFileOld {

    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        String filePath = "/Users/hj/temp/seqFile/image_wantu_odp_app.pb.log.201605051600";
//        String filePath = "/Users/hj/temp/seqFile/seqFile.seq";
        Path seqFile = new Path(filePath);

        // Writer内部类用于文件的写操作,假设Key和Value都为Text类型
//        SequenceFile.Writer writer = SequenceFile.createWriter(conf,
//                Writer.file(seqFile),
//                Writer.keyClass(Text.class),
//                Writer.valueClass(Text.class),
//                Writer.compression(CompressionType.NONE));
//
//        // 通过writer向文档中写入记录
//        writer.append(new Text("a"), new Text("aa"));
//        writer.append(new Text("b"), new Text("bb"));
//        writer.append(new Text("c"), new Text("cc"));
//        // 关闭write流
//        IOUtils.closeStream(writer);





        // 通过reader从文档中读取记录
        Reader reader = new Reader(conf,
                Reader.file(seqFile));
        Text key = new Text();
        Text value = new Text();
        //1
        //        boolean hasNext;
        //        while (hasNext = reader.next(key)) {
        //            System.out.println(hasNext);
        //            System.out.println(key);
        //        }

        //2
        //        while (reader.next(key, value)) {
        //            System.out.println(key);
        //            System.out.println(value);
        //        }

        //3

        //        System.out.println(reader.next(new Text("a")));
        //        System.out.println(reader.next(new Text("a")));
        //        System.out.println(reader.next(new Text("a")));

        //4
//        long position = 0L;
//        int i = 0;
//        System.out.println(reader.getPosition());
//        while (reader.next(key, value)) {
//            i++;
//            System.out.println(reader.getPosition());
//            if (i==1) {
//                position = reader.getPosition();
//            }
//            System.out.println(key);
//            System.out.println(value);
//        }
//        reader.seek(position);
//
//        System.out.println(reader.getPosition());
//        while (reader.next(key, value)) {
//            System.out.println("=================");
//            System.out.println(reader.getPosition());
//            System.out.println(key);
//            System.out.println(value);
//        }

        // 5
        System.out.println(reader.getKeyClass().getName());
        System.out.println(reader.getValueClass().getName());




        // 关闭read流
        IOUtils.closeStream(reader);

    }

}