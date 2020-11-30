package kafka.model;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.ConvertJavaObjectToJson;


import java.util.Properties;

public class App {
    public static void main(String[] args) throws Throwable {
//    	Properties props = new Properties();
//    	props.pu
    	
    	Survey survey = new Survey();

    	survey.setfName("neeraj");
    	survey.setCity("abcd4th");

    	ConvertJavaObjectToJson sjo = new ConvertJavaObjectToJson(survey);

		String surveyJson = sjo.javaObjectToJson();

		//Adding the student to records
    	SurveyProducer sp = new SurveyProducer();
    	sp.saveSurvey("my-topic", survey.getfName(), surveyJson);

    	SurveyConsumer surveyConsumer = new SurveyConsumer();
		List<String> surveys = surveyConsumer.getSurveys("my-topic");
 //   	Survey survey = new Survey("Ramesh", "Fadatare", "2020-10-01");
        
//    	surveyDao.saveSurvey(survey);
        surveys.forEach(s -> System.out.println(s));
        
    }

}
