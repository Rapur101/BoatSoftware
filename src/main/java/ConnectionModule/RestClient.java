package ConnectionModule;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


// TODO: 25/06/2020 - Multithreading

public class RestClient {
    private String serverUri;
    private RestTemplate rest;
    private HttpHeaders httpHeaders;
    private HttpStatus httpStatus;

    public RestClient(String serverUri) {
        this.serverUri = serverUri;
        this.rest = new RestTemplate();
        this.httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        httpHeaders.add("Accept", "*/*");
    }

    /*
    public void postJson() throws IOException {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(uri);

        String json = "test"; // TODO: 25/06/2020
        StringEntity stringEntity = new StringEntity(json);
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Accept","application/json");
        httpPost.setHeader("Content-type","application/json");

        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost);
        closeableHttpClient.close();
    }*/

    public String httpGet(String uri, String body) {
        HttpEntity<String> requestEntity = new HttpEntity<String>(body, httpHeaders);
        ResponseEntity<String> responseEntity = rest.exchange(serverUri + uri, HttpMethod.GET, requestEntity, String.class);
        setHttpStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    public String httpPost(String uri, String body) {
        HttpEntity<String> requestEnity = new HttpEntity<String>(body, httpHeaders);
        ResponseEntity<String> responseEntity = rest.exchange(serverUri + uri, HttpMethod.POST, requestEnity, String.class);
        setHttpStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();

    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
