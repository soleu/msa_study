package com.msa_study.demo.domain.entity.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostUpdateRequest {
    @NotBlank
    private String content;

    @Builder
    public PostUpdateRequest(String content) {
        this.content = content;
    }
}
