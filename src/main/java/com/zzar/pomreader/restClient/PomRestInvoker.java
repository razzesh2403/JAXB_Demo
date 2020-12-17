package com.zzar.pomreader.restClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.zzar.pomreader.model.Line;
import com.zzar.pomreader.model.PomOne;
import com.zzar.pomreader.model.PomResponse;
import com.zzar.pomreader.model.PomTwo;
import com.zzar.pomreader.model.Value;

@Service
public class PomRestInvoker {
		
	RestTemplate restTemplate;
	
	public List<PomResponse> getPomOne() {
		String baseUri="http://localhost:3000/";
		String projectName = "xyz";
		String fileName = "pom.xml";
		String finalUri = baseUri + projectName + fileName;
		
		PomResponse response = null;
		List<PomResponse> responseList = new ArrayList<>();
		
		restTemplate = new RestTemplate();
		PomOne result = restTemplate.getForObject(baseUri+"gitRepoUrl", PomOne.class);
		
		for(Value val : result.getValues()) {
			response = new PomResponse();
			PomTwo result1 = restTemplate.getForObject(baseUri + val.getName() , PomTwo.class);
			for(Line line : result1.getLines()) {
				
				if(line.getText().contains("<artifactId>") &&  StringUtils.isEmpty(response.getArtifactId())) {
					response.setArtifactId(line.getText().substring(12, line.getText().length()-13));
				}
				
				else if(line.getText().contains("<version>") && StringUtils.isEmpty(response.getVersion())) {
					response.setVersion(line.getText().substring(9, line.getText().length()-10));
				}
				
				else if(line.getText().contains("<name>") && StringUtils.isEmpty(response.getProjectName())) {
					response.setProjectName(line.getText().substring(6, line.getText().length()-7));
				}
			}
			responseList.add(response);
			System.out.println("Output " + result1.toString());
		}
		
		return responseList;
	}
	
	public static void getMethod() {
		
		HttpURLConnection con;
		try {
			URL url = new URL("http://localhost:3000/gitRepoUrl");
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			BufferedReader in = new BufferedReader(
					  new InputStreamReader(con.getInputStream()));
					String inputLine;
					StringBuffer content = new StringBuffer();
					while ((inputLine = in.readLine()) != null) {
					    content.append(inputLine);
					}
					in.close();
					System.out.println("output " + content);
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]) {
		getMethod();
	}
}
