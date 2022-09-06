package com.msa_study.demo.service;

import com.msa_study.demo.common.exception.AlreadyExistsMemberException;
import com.msa_study.demo.common.exception.NotExistsMemberException;
import com.msa_study.demo.domain.Member;
import com.msa_study.demo.domain.MemberRepository;
import com.msa_study.demo.service.dto.request.MemberCreateRequest;
import com.msa_study.demo.service.dto.response.MemberCreateResponse;
import com.msa_study.demo.service.dto.response.MemberGetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberCreateResponse createMember(MemberCreateRequest request) {
        if (isAlreadyMember(request)) throw new AlreadyExistsMemberException();

        Member member = Member.newInstance(request.getName(), request.getAddress());
        memberRepository.save(member);

        return MemberCreateResponse.of(member);
    }

    private boolean isAlreadyMember(MemberCreateRequest request) {
        return memberRepository.existsByName(request.getName());
    }

    @Transactional(readOnly = true)
    public MemberGetResponse getMemberInfo(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(NotExistsMemberException::new);

        return MemberGetResponse.of(member);
    }
}
