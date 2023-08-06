package stream.wladi.response;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class StreamResponse {
    
    private ArrayList<Results> results;

    public ArrayList<Results> getResults() {
        return results;
    }

    public void setResults(ArrayList<Results> results) {
        this.results = results;
    }

    
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class Results {

        private String title;
        private String overview;
        private Double popularity;

        @JsonProperty("poster_path")
        private String posterPath;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public Double getPopularity() {
            return popularity;
        }

        public void setPopularity(Double popularity) {
            this.popularity = popularity;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }
        
    }

}
