package com.example.katyaS8;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {
    List<String> themes = new ArrayList<>();


    @GetMapping("themes")
    public String getThemes() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String message : themes) {
            stringBuilder.append(message).append(",");
        }
        return stringBuilder.toString();
    }

    @PostMapping("themes")
    public void addMessage(@RequestBody String theme) {
        themes.add(theme);
    }

    @GetMapping("themes/{index}")
    public String getMessage(@PathVariable("index") Integer index) {
        return themes.get(index);
    }


    @DeleteMapping("themes/{index}")
    public void deleteThemes(@PathVariable("index") Integer index) {
        themes.remove((int) index);
    }


    @DeleteMapping("themes")
    public void deleteThemes2() {
        int k=themes.size();
        for(int n=1;n<k;n++)
        {
            themes.remove(n);
        }
    }

    @PutMapping("themes/{index}")
    public void updateMessage(
            @PathVariable("index") Integer i,
            @RequestBody String message) {
        themes.remove((int) i);
        themes.add(i, message);
    }
//curl -X POST http://localhost:8080/themes -H 'Content-Type: text/plain' -d 'hello'

    //
}


