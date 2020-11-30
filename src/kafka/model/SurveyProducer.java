package kafka.model;

//import util.properties packages
import java.util.Properties;

//import simple producer packages
import org.apache.kafka.clients.producer.Producer;

//import KafkaProducer packages
import org.apache.kafka.clients.producer.KafkaProducer;

//import ProducerRecord packages
import org.apache.kafka.clients.producer.ProducerRecord;

public class SurveyProducer {
	public void saveSurvey(String topic, String key, String survey) throws Exception {

		// Assign topicName to string variable
		String topicName = topic;

		// create instance for properties to access producer configs
		Properties props = new Properties();

		// Assign localhost id
		props.put("bootstrap.servers", "34.86.90.135:30807");

		// Set acknowledgements for producer requests.
		props.put("acks", "all");

		// If the request fails, the producer can automatically retry,
		props.put("retries", 0);

		// Specify buffer size in config
		props.put("batch.size", 16384);

		// Reduce the no of requests less than 0
		props.put("linger.ms", 1);

		// The buffer.memory controls the total amount of memory available to
		// the producer for buffering.
		props.put("buffer.memory", 33554432);

		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<String, String>(props);
		producer.send(new ProducerRecord<String, String>(topicName, key, survey));
		System.out.println("Message sent successfully");
		producer.close();

	}
	
	
}