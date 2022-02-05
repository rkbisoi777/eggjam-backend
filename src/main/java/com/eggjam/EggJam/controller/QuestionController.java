package com.eggjam.EggJam.controller;

import com.eggjam.EggJam.entity.exam.Question;
import com.eggjam.EggJam.entity.exam.Quiz;
import com.eggjam.EggJam.service.QuestionService;
import com.eggjam.EggJam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    //add question
    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //get question
    @GetMapping("/{quesId}")
    public Question getQuestion(@PathVariable("quesId") Long quesId){
        return this.questionService.getQuestion(quesId);
    }

    //get all questions
    @GetMapping("/")
    public Set<Question> getAllQuestion(){
        return new HashSet<>(this.questionService.getAllQuestion());
    }

    //get all question by quiz
    @GetMapping("/quiz/{quizId}")
    public  ResponseEntity<?> getAllQuestionsOfQuiz(@PathVariable("quizId") Long quizId){
        Quiz quiz = this.quizService.getQuiz(quizId);
        return ResponseEntity.ok(this.questionService.getQuestionsOfQuiz(quiz));
    }

    //get all question by quiz
    @GetMapping("/quiz/user/{quizId}")
    public  ResponseEntity<?> getAllQuestionsOfQuizForUser(@PathVariable("quizId") Long quizId){
        Quiz quiz = this.quizService.getQuiz(quizId);
        List<Question> setOfQuestions = this.questionService.getQuestionsOfQuiz(quiz);
        setOfQuestions.forEach((q)->{
            q.setAnswer("");
        });
        Collections.shuffle(setOfQuestions);
        return ResponseEntity.ok(setOfQuestions);
    }

    //update Question
    @PutMapping("/")
    public Question updateQuestion(@RequestBody Question question){
        return this.questionService.updateQuestion(question);
    }

    //delete Question
    @DeleteMapping("/{quesId}")
    public void deleteQuestion(@PathVariable("quesId") Long quesId){
        this.questionService.deleteQuestion(quesId);
    }

    //calculate Marks
    @PostMapping("/calc-quiz")
    public ResponseEntity<?> calcQuiz(@RequestBody List<Question> questions){
        System.out.println(questions);
        double marksGot = 0;
        int correctAnswers = 0;
        int attempted = 0;
        for(Question q: questions){
            //single questions
            Question question = this.questionService.get(q.getQuesId());
            if(question.getAnswer().equals(q.getGivenAnswer())){
                //correct
                correctAnswers++;
                double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
                marksGot += marksSingle;
            }
            if(q.getGivenAnswer()!=null){
                attempted++;
            }
        }

        Map<String, Object> map = Map.of("marksGot",marksGot, "correctAnswers", correctAnswers, "attempted",attempted);

        return ResponseEntity.ok(map);
    }
}
