package stream.wladi.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import stream.wladi.response.StreamResponse;

@Service
public class StreamClient {
    
    private final String URL = "https://api.themoviedb.org/3/movie/";
    private final String TOKEN = "";

    private final RestTemplate restTemplate;

    public StreamClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public StreamResponse getPopularMovies() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(TOKEN);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String apiUrl = URL + "popular?language=pt-BR&page=1";
        StreamResponse response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, StreamResponse.class).getBody();
        return response;
    }

    public StreamResponse getTrailerMovie(String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(TOKEN);
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String apiUrl = URL + id + "/videos?language=pt-BR";
        StreamResponse response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, StreamResponse.class).getBody();
        return response;
    }
}
