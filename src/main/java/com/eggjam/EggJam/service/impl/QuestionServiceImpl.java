package com.eggjam.EggJam.service.impl;

import com.eggjam.EggJam.entity.exam.Question;
import com.eggjam.EggJam.entity.exam.Quiz;
import com.eggjam.EggJam.repository.QuestionRepository;
import com.eggjam.EggJam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    public QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestion() {
        return this.questionRepository.findAll();
    }

    @Override
    public Question getQuestion(Long quesId) {
        return this.questionRepository.findById(quesId).get();
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Quiz quiz) {
        return  this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long quesId) {
        this.questionRepository.deleteById(quesId);
    }

    @Override
    public Question get(Long questionsId) {
        return this.questionRepository.getById(questionsId);
    }
}
