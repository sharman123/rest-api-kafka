package cs.swe645.resources;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.glassfish.jersey.media.multipart.FormDataParam;

import kafka.model.Survey;
import kafka.model.SurveyConsumer;
import kafka.model.SurveyProducer;
import utils.ConvertJavaObjectToJson;

@Path("/surveys")
public class SurveyResource {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getServeys() throws Exception {
		SurveyConsumer surveyConsumer = new SurveyConsumer();
		List<String> surveys = surveyConsumer.getSurveys("my-topic");
//		surveys.forEach(s -> System.out.println(s.getfName()));
		return Response.ok().entity(surveys).build();
	}

	@POST
	@Path("/create")
	@Consumes("application/json")
	public void addSurvey(Survey survey) throws Exception {
		//survey to json hibernate
		ConvertJavaObjectToJson sjo = new ConvertJavaObjectToJson(survey);
		String surveyJson = sjo.javaObjectToJson();
		//Adding the student to records
		SurveyProducer surveyProducer = new SurveyProducer();
		surveyProducer.saveSurvey("my-topic", survey.getfName(), surveyJson);
		
	}

}
