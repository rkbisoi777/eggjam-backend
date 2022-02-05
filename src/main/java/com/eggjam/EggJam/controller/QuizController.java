package com.eggjam.EggJam.controller;

import com.eggjam.EggJam.entity.exam.Quiz;
import com.eggjam.EggJam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizService quizService;

    //add quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //get quiz
    @GetMapping("/{quizId}")
    public Quiz getQuiz(@PathVariable("quizId") Long quizId){
        return this.quizService.getQuiz(quizId);
    }

    //get all quiz
    @GetMapping("/")
    public ResponseEntity<?> getAllQuiz(){
        return ResponseEntity.ok(this.quizService.getAllQuiz());
    }

    //update quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //delete quiz
    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable("quizId") Long quizId){
        this.quizService.deleteQuiz(quizId);
    }

    //get quizzes by category
    @GetMapping("/category/{cId}")
    public ResponseEntity<?> getQuizzesOfCategory(@PathVariable("cId") Long cId){
        return ResponseEntity.ok(this.quizService.getQuizzesOfCategory(cId));
    }
}
