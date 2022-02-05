package com.eggjam.EggJam.repository;

import com.eggjam.EggJam.entity.exam.Category;
import com.eggjam.EggJam.entity.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
    Set<Quiz> findByCategory(Category category);
}
