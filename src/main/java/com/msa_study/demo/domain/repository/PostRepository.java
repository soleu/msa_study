package com.msa_study.demo.domain.repository;

import com.msa_study.demo.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
