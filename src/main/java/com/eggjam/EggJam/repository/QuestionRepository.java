package com.eggjam.EggJam.repository;

import com.eggjam.EggJam.entity.exam.Question;
import com.eggjam.EggJam.entity.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    List<Question> findByQuiz(Quiz quiz);
}
