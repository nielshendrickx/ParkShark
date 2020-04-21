package com.switchfully.parkshark.api.endpoints;

import com.switchfully.parkshark.service.services.MemberService;
import com.switchfully.parkshark.service.user.CreateMemberDto;
import com.switchfully.parkshark.service.user.MemberDto;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping(path = MemberController.MEMBER_RESOURCE_PATH)
public class MemberController {
    public static final String MEMBER_RESOURCE_PATH = "/member";
    private final Logger loggerMember = LoggerFactory.getLogger(MemberController.class);
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Get all registered members", notes = "A list of all the registered members will be returned" , response = MemberDto.class)
    @ResponseStatus(HttpStatus.OK)
    public Collection<MemberDto> getAllMembers() {
        loggerMember.info("Returning all members");
        return memberService.getAllMembers();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Register as a member", notes = "Everyone can freely join Digibooky!" , response = MemberDto.class)
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDto register(@RequestBody CreateMemberDto newMember) throws IOException {
        //validateNewMember(newMember); TODO
        loggerMember.info("Creating a new member");
        return memberService.register(newMember);
    }
}
