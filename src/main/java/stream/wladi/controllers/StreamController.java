package stream.wladi.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import stream.wladi.client.StreamClient;
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


}