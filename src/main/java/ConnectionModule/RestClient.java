package ConnectionModule;

import org.apache.http.entity.StringEntity;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.util.Arrays;


// TODO: 25/06/2020 - Multithreading

/**
 * Basic REST Client class.
 */
public class RestClient {
    private URL apiAddress;
    private RestTemplate rest;
    private HttpHeaders httpHeaders;
    private HttpStatus httpStatus;

    /**
     * Constructor.
     *
     * @param apiAddress   API URL
     * @param securityCode Encrypted securityCode.
     */
    public RestClient(URL apiAddress, String securityCode) {
        this.apiAddress = apiAddress;
        this.rest = new RestTemplate();
        this.httpHeaders = new HttpHeaders();

        httpHeaders.add("securityCode", securityCode);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    }


    /**
     * Basic HTTP GET method.
     *
     * @param uri URI to request information.
     * @return Response body. Auth error, if securityCode doesn't match.
     */
    public String httpGet(String uri) {
        HttpEntity<String> requestEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity =  rest.exchange(apiAddress + uri, HttpMethod.GET, requestEntity, String.class);
        setHttpStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    /**
     * Basic HTTP POST method.
     *
     * @param uri  URI to request information.
     * @param body POST BODY
     * @return Response body. Auth error, if securityCode doesn't match.
     */
    public String httpPost(String uri, String body) {
        System.out.println(httpHeaders.toString());
        HttpEntity<String> requestEntity = new HttpEntity<>(body,httpHeaders);
        ResponseEntity<String> responseEntity = rest.exchange(apiAddress + uri, HttpMethod.POST, requestEntity, String.class);
        setHttpStatus(responseEntity.getStatusCode());

        return responseEntity.getBody();

    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public boolean internetConnection(int timeout) {
        try {
            return InetAddress.getByName(apiAddress.toString()).isReachable(timeout);
        } catch (IOException e) {
            return false;
        }
    }
}
