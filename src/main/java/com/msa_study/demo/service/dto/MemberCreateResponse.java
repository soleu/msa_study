package com.msa_study.demo.service.dto;

import com.msa_study.demo.domain.entity.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberCreateResponse {
    private Long id;
    private String name;

    public static MemberCreateResponse of(Member member) {
        return new MemberCreateResponse(
                member.getId(),
                member.getName()
        );
    }
}
