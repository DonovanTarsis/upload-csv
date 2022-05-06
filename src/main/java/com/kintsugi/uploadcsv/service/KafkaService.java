package com.kintsugi.uploadcsv.service;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaService {
    public static void producer(String msg) {

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {

            ProducerRecord<String, String> record = new ProducerRecord<String, String>("upload-csv", msg);
            producer.send(record);

        } catch (KafkaException e) {
            System.err.println(e.getMessage());
        }

    }
}

// alias start_zookeeper="~/kafka/bin/zookeeper-server-start.sh
// ~/kafka/config/zookeeper.properties"

// alias start_kafka="~/kafka/bin/kafka-server-start.sh
// ~/kafka/config/server.properties"