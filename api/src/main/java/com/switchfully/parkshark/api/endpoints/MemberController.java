package com.switchfully.parkshark.api.endpoints;

import com.fasterxml.jackson.annotation.JsonView;
import com.switchfully.parkshark.domain.Views;
import com.switchfully.parkshark.service.services.MemberService;
import com.switchfully.parkshark.service.user.CreateMemberDto;
import com.switchfully.parkshark.service.user.MemberDto;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

import static com.switchfully.parkshark.api.validation.Validation.isValidEmailAddress;

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

    @PreAuthorize("hasAuthority('VIEW_MEMBERS')")
    @JsonView(Views.Manager.class)
    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Get all registered members", notes = "A list of all the registered members will be returned", response = MemberDto.class)
    @ResponseStatus(HttpStatus.OK)
    public Collection<MemberDto> getAllMembers() {
        loggerMember.info("Returning all members");
        return memberService.getAllMembers();
    }

    @JsonView(Views.Public.class)
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Register as a member", notes = "Everyone can freely join ParkShark!" , response = MemberDto.class)
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDto register(@RequestBody CreateMemberDto newMember) throws IOException {
        validateNewMember(newMember);
        loggerMember.info("Creating a new member");
        return memberService.register(newMember);
    }

    private void validateNewMember(CreateMemberDto newMember) throws IOException {
        isValidEmailAddress(newMember.getEmail());
        memberService.isEmailAvailable(newMember.getEmail());
    }
}
