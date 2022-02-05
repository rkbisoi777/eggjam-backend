package com.eggjam.EggJam.service;

import com.eggjam.EggJam.entity.exam.Quiz;

import java.util.Set;

public interface QuizService {
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getAllQuiz();
    public Quiz getQuiz(Long quizId);
    public void deleteQuiz(Long quizId);
    public Set<Quiz> getQuizzesOfCategory(Long cId);
}
