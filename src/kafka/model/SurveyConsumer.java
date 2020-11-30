package kafka.model;

import java.util.Properties;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;


public class SurveyConsumer {
	public List<String> getSurveys(String topic) throws Exception {
	      //Kafka consumer configuration settings
	      String topicName = topic;
	      Properties props = new Properties();
	      
	      props.put("bootstrap.servers", "34.86.90.135:30807");
//	      props.put("group.id", "test-consumer-group");
	      props.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
	      props.put("enable.auto.commit", "false");
//	      props.put("auto.commit.interval.ms", "1000");
	      props.put("auto.offset.reset", "earliest");
	      props.put("session.timeout.ms", "300000");
	      props.put("key.deserializer", 
	         "org.apache.kafka.common.serialization.StringDeserializer");
	      props.put("value.deserializer", 
	         "org.apache.kafka.common.serialization.StringDeserializer");
	      KafkaConsumer<String, Object> consumer = new KafkaConsumer
	         <String, Object>(props);
	      
	      //Kafka Consumer subscribes list of topics here.
	      consumer.subscribe(Arrays.asList(topicName));
	      
	      //print the topic name
	      System.out.println("Subscribed to topic " + topicName);
	      List<String> recordsList = new ArrayList();
/*	      ConsumerRecords<String, Object> records = consumer.poll(Duration.ofMillis(100000));
	      records.forEach(record -> {
	    	  recordsList.add((String) record.value());
	        }); 
*/	      
	      while (true) {
	         ConsumerRecords<String, Object> records = consumer.poll(Duration.ofMillis(10000));
	         if (!records.isEmpty()){
	        	 records.forEach(record -> {
	   	    	  recordsList.add((String) record.value());
	   	        }); 
	        	 return recordsList;
	      }
	   }
	}

}
