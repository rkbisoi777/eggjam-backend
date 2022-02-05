package com.eggjam.EggJam.service;

import com.eggjam.EggJam.entity.exam.Question;
import com.eggjam.EggJam.entity.exam.Quiz;

import java.util.List;

public interface QuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public List<Question> getAllQuestion();
    public Question getQuestion(Long quesId);
    public List<Question> getQuestionsOfQuiz(Quiz quiz);
    public void deleteQuestion(Long quesId);
    public Question get(Long questionsId);
}
