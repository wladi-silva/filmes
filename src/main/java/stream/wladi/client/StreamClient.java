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
    
    private final String URL = "https://api.themoviedb.org/3/movie";
    private final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyYTM5MTgzY2I3ZDdlNjRhNTU0ODVhMjI3Y2RmNWQ3ZiIsInN1YiI6IjY0Yzg0ZGU1MWZhMWM4MDBlZWFlMzllMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.8SqnpIPXiIQISc10Ym4bgAtuPDMlLxD0rAo2LeBhOOc";

    private final RestTemplate restTemplate;

    public StreamClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public StreamResponse getPopularMovies() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(TOKEN);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String apiUrl = URL + "/popular?language=pt-BR&page=1";
        StreamResponse response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, StreamResponse.class).getBody();
        return response;
    }
}
