package com.eggjam.EggJam.repository;

import com.eggjam.EggJam.entity.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
