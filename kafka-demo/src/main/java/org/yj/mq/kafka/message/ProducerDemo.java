package org.yj.mq.kafka.message;

import org.apache.kafka.clients.producer.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ProducerDemo {


    //bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic my-topic --partitions 2 --replication-factor 1
    public static void main(String[] args) {

        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        config.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "my-tran-id");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer producer = new KafkaProducer(config);

        producer.initTransactions();
        try {
            producer.beginTransaction();
            for (int i = 0; i < 9; i++) {
                if(i==4){
                    throw new Exception("wrong number.");
                }
                int partition = i % 3;
                System.out.println("partition id:" + partition);

                ProducerRecord record = new ProducerRecord("my-topic", partition, null, String.valueOf(i));
                Future<RecordMetadata> res = producer.send(record, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    }
                });
                RecordMetadata metadata = res.get();
            }
            producer.commitTransaction();

        } catch (Exception e) {
            producer.abortTransaction();
        } finally {
            producer.close();
        }


    }
}
