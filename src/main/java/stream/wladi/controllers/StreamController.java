package stream.wladi.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import stream.wladi.client.StreamClient;
import stream.wladi.response.StreamResponse;
import stream.wladi.response.StreamResponse.Results;

@Controller
@RequestMapping("/")
public class StreamController {
    
    @Autowired
    StreamClient streamClient;

    @GetMapping("/")
    public ModelAndView getPopularMovies() {
        ModelAndView mv = new ModelAndView("index");
        ArrayList<Results> movies = streamClient.getPopularMovies().getResults();
        mv.addObject("movies", movies);
        return mv;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPopularMovies(@PathVariable String id) {
        StreamResponse trailer = streamClient.getTrailerMovie(id);
        return ResponseEntity.status(HttpStatus.OK).body(trailer);
    }

}