package com.example.homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;

@RestController
@RequestMapping("articles/")
class ArticleController {
    @GetMapping("scifi")
    public String getSciFiArticle(){
        return loadArticle(Paths.sciFi);
    }

    @GetMapping("romantic")
    public String getRomanticArticle(){
        return loadArticle(Paths.romantic);
    }

    @GetMapping("historic")
    public String getHistoricArticle(){
        return loadArticle(Paths.historic);
    }

    private String loadArticle(String filePath){
        String article = "";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            article = String.valueOf(bufferedReader.readLine());
        }catch (Exception e){
            System.err.println(e.getLocalizedMessage());
            article = "Could not find file" + filePath;
        }
        return article;
    }
}
