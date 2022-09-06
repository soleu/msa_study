package com.msa_study.demo.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private Post(final String title, final String content) {
        this.title = title;
        this.content = content;
    }

    public final void updateContent(final String content) {
        this.content = content;
    }

    public static Post newInstance(final String title, final String content) {
        return new Post(title, content);
    }
}

