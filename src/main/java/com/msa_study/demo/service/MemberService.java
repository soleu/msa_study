package com.msa_study.demo.service;

import com.msa_study.demo.common.exception.AlreadyExistsMember;
import com.msa_study.demo.domain.entity.Member;
import com.msa_study.demo.domain.repository.MemberRepository;
import com.msa_study.demo.service.dto.MemberCreateResponse;
import com.msa_study.demo.service.dto.request.MemberCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberCreateResponse createMember(MemberCreateRequest request) {
        boolean isAlreadyMember = memberRepository.existsByName(request.getName());
        if (isAlreadyMember) throw new AlreadyExistsMember();

        Member member = Member.newInstance(request.getName(), request.getAddress());
        memberRepository.save(member);
        return MemberCreateResponse.of(member);
    }
}
