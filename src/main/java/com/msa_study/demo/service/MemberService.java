package com.msa_study.demo.service;

import com.msa_study.demo.common.exception.AlreadyExistsMemberException;
import com.msa_study.demo.common.exception.NotExistsMemberException;
import com.msa_study.demo.domain.Member;
import com.msa_study.demo.domain.MemberRepository;
import com.msa_study.demo.service.dto.MemberCreateResponse;
import com.msa_study.demo.service.dto.MemberGetResponse;
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
        if (isAlreadyMember) throw new AlreadyExistsMemberException();

        Member member = Member.newInstance(request.getName(), request.getAddress());
        memberRepository.save(member);

        return MemberCreateResponse.of(member);
    }

    @Transactional(readOnly = true)
    public MemberGetResponse getMemberInfo(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(NotExistsMemberException::new);

        return MemberGetResponse.of(member);
    }
}
