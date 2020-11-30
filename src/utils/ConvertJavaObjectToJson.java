package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kafka.model.Survey;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertJavaObjectToJson {
	private Survey survey;
	public ConvertJavaObjectToJson(Survey survey){
		this.survey = survey;
	}
    public  String javaObjectToJson() {
        ObjectMapper mapper = new ObjectMapper();
 //       Survey survey = new Survey();

        try {
           // mapper.writeValue(new File("survey.json"), survey);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(survey);
            System.out.println(jsonString);
            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
    }
}
