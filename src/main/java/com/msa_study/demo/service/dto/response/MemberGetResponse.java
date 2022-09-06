package com.msa_study.demo.service.dto.response;

import com.msa_study.demo.domain.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberGetResponse {
    private Long id;
    private String name;
    private String address;

    public static MemberGetResponse of(Member member) {
        return new MemberGetResponse(
                member.getId(),
                member.getName(),
                member.getAddress()
        );
    }

}
