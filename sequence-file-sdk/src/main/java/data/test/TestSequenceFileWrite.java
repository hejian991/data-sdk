package data.test;

/**
 * Created by hj on 16/5/4.
 */

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.SequenceFile.CompressionType;
import org.apache.hadoop.io.SequenceFile.Writer;
import org.apache.hadoop.util.ReflectionUtils;

import com.iwaimai.Sample;

public class TestSequenceFileWrite {

    public static void main(String[] args) throws IOException {
        String filePath = "/Users/hj/temp/seqFile/hj_odp_pb_log";

        write(filePath);
        read(filePath);
    }

    public static void write(String filePath) throws IOException {
        Configuration conf = new Configuration();

        Path seqFile = new Path(filePath);

        // Writer内部类用于文件的写操作
        SequenceFile.Writer writer = SequenceFile.createWriter(conf,
                Writer.file(seqFile),
                Writer.keyClass(BytesWritable.class),
                Writer.valueClass(BytesWritable.class),
                Writer.compression(CompressionType.NONE));

        // 通过writer向文档中写入记录
                Sample.MetaData metaData = Sample.MetaData.newBuilder().build();
                Sample.SampleMessage sampleMessage = Sample.SampleMessage.newBuilder()
                        .setLocalIp("")
                        .setLogTag("")
                        .setMetadata(metaData)
                        .build();

//        Example.Person person = Example.Person.newBuilder()
//                .setId(1)
//                .setName("lijun")
//                .setEmail("lijun@baidu")
//                .addLikes("coding")
//                .addLikes("ML")
//                .build();
        BytesWritable pbValue = new BytesWritable(metaData.toByteArray());

        writer.append(new BytesWritable(), pbValue);
        // 关闭write流
        IOUtils.closeStream(writer);
    }

    public static void read(String uri) throws IOException {
        Configuration conf = new Configuration();
        Path path = new Path(uri);
        SequenceFile.Reader reader = null;
        try {
            reader = new SequenceFile.Reader(conf, SequenceFile.Reader.file(path));
            BytesWritable key = (BytesWritable) ReflectionUtils.newInstance(reader.getKeyClass(), conf);
            BytesWritable value = (BytesWritable) ReflectionUtils.newInstance(reader.getValueClass(), conf);
            while (reader.next(key, value)) {
//                String syncSeen = reader.syncSeen() ? "*" : "";
                //                System.out.printf("[%s]\t%s\t%s\n", syncSeen, key, value);
                Sample.SampleMessage sampleMessage = Sample.SampleMessage.parseFrom(value.copyBytes());
//                Example.Person person = Example.Person.parseFrom(value.copyBytes());
                System.out.println(sampleMessage);
            }
        } finally {
            IOUtils.closeStream(reader);
        }
    }

}





