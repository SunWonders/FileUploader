package com.aeiou.file.uploader.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomMailSender {
	@Autowired
	private JavaMailSender mailSender;

	public void confirmRegistration( Exception exception) throws MessagingException, JsonProcessingException {

		String recipientAddress = "dilipduraiswamy@gmail.com";

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
		
		   
	
		//System.out.println(exceptionHtml);
		ObjectMapper mapper = new ObjectMapper();
	      //Converting the Object to JSONString
		
		 String jsonString = mapper.writeValueAsString(exception);
	      System.out.println(jsonString);
	      JSONObject jsonObj=new JSONObject(jsonString);
		String exceptionHtml="";
				//jsonToHtml(jsonObj);
		// mimeMessage.setContent(htmlMsg, "text/html"); /** Use this or below line **/
		helper.setText(exceptionHtml, true); // Use this or above line.
		helper.setTo(recipientAddress);
		helper.setSubject("This is the test message for testing gmail smtp server using spring mail");
		helper.setFrom("noreply@sunwonders.com");

		mailSender.send(mimeMessage);
	}
	private String jsonToHtml( Object obj ) {
	    StringBuilder html = new StringBuilder( );

	    try {
	        if (obj instanceof JSONObject) {
	            JSONObject jsonObject = (JSONObject)obj;
	            String[] keys = JSONObject.getNames( jsonObject );

	            html.append("<div class=\"json_object\">");

	            if (keys.length > 0) {
	                for (String key : keys) {
	                    // print the key and open a DIV
	                    html.append("<div><span class=\"json_key\">")
	                        .append(key).append("</span> : ");

	                    Object val = jsonObject.get(key);
	                    // recursive call
	                    html.append( jsonToHtml( val ) );
	                    // close the div
	                    html.append("</div>");
	                }
	            }

	            html.append("</div>");

	        } else if (obj instanceof JSONArray) {
	            JSONArray array = (JSONArray)obj;
	            for ( int i=0; i < array.length( ); i++) {
	                // recursive call
	                html.append( jsonToHtml( array.get(i) ) );                    
	            }
	        } else {
	            // print the value
	            html.append( obj );
	        }                
	    } catch (JSONException e) { return e.getLocalizedMessage( ) ; }

	    return html.toString( );
	}
	
	
	public  String getStackTrace(final Throwable throwable) {
	     final StringWriter sw = new StringWriter();
	     final PrintWriter pw = new PrintWriter(sw, true);
	     throwable.printStackTrace(pw);
	     return sw.getBuffer().toString();
	}
}
