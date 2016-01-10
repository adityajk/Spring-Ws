
package hello;

import java.text.SimpleDateFormat;


import hello.wsdl.GetCountryRequest;
import hello.wsdl.GetCountryResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class WeatherClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(WeatherClient.class);

	public GetCountryResponse getCountryResponseByName(String countryName) {

		GetCountryRequest request = new GetCountryRequest();
		request.setName(countryName);

		log.info("Requesting Name for " + countryName);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive(
						"http://localhost:9900/ws",
						request,
						new SoapActionCallback("http://localhost:9900/ws"));

		return response;
	}

	public void printResponse(GetCountryResponse response) {

		System.out.println(response.getCountry().getPopulation());

	}

}
