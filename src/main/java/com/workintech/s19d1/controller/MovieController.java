package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;
    @GetMapping
    public List<Movie> findAll(){return movieService.findAll();}
    @GetMapping("/{id}")
    public Movie findById(@PathVariable long id){return movieService.findById(id);}

    @PostMapping
    public Movie save(@RequestBody Movie movie){
        List<Actor> actors = movie.getActors();
        for(Actor a : actors){
            movie.addActor(a);
        }
        return movieService.save(movie);
    }

}
