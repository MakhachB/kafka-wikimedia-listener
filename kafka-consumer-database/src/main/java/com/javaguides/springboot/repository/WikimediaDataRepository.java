package com.javaguides.springboot.repository;

import com.javaguides.springboot.model.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {

}
