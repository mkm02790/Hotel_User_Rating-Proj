/**
 * 
 */
package com.mukul.user.service.connection;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Paths;

import ch.qos.logback.core.util.Duration;
import lombok.var;

/**
 * @author mukul
 *
 * 27-Nov-2022
 */
public class Connection {

	static String userUrl="http://192.168.1.43:8001/users";
	static String hotelUrl="";
	
	static HttpRequest requestForUser = HttpRequest.newBuilder().GET()
	        .uri(URI.create("https://foo.com/"))
	        .build();
	
	static HttpRequest requestForHotel = HttpRequest.newBuilder().GET()
	        .uri(URI.create("https://foo.com/"))
	        .build();
	
//	static HttpClient responseForUser = HttpClient.newBuilder().build();
	
	static HttpClient responseForHotel = HttpClient.newBuilder().build();
	
	static HttpResponse<String> fromUserService (HttpRequest requestForHotel) throws IOException, InterruptedException {
		HttpResponse<String> response = HttpClient
				  .newBuilder()
				  .build()
				  .send(requestForUser, BodyHandlers.ofString());
		return response;}
}
