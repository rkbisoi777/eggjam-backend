package com.eggjam.EggJam.service.impl;

import com.eggjam.EggJam.entity.exam.Category;
import com.eggjam.EggJam.entity.exam.Quiz;
import com.eggjam.EggJam.repository.CategoryRepository;
import com.eggjam.EggJam.repository.QuizRepository;
import com.eggjam.EggJam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getAllQuiz() {
        return new HashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return this.quizRepository.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {
        this.quizRepository.deleteById(quizId);
    }

    @Override
    public Set<Quiz> getQuizzesOfCategory(Long cId) {
        Category category = this.categoryRepository.findById(cId).get();
        return this.quizRepository.findByCategory(category);
    }
}
