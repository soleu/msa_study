package com.msa_study.demo.controller;

import com.msa_study.demo.service.MemberService;
import com.msa_study.demo.service.dto.request.MemberCreateRequest;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("")
    @ApiOperation("유저를 생성합니다.")
    public void createUser(@RequestBody MemberCreateRequest request){
        memberService.createMember(request);
    }
}
