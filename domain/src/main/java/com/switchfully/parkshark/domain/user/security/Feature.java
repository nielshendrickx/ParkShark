package com.switchfully.parkshark.domain.user.security;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

public enum Feature {
    VIEW_MEMBERS(Role.MANAGER),
    VIEW_MEMBER(Role.MANAGER),
    VIEW_DIVISIONS(Role.MANAGER),
    VIEW_DIVISION(Role.MANAGER),
    CREATE_DIVISION(Role.MANAGER),
    CREATE_SUB_DIVISION(Role.MANAGER);

    //todo
    //CREATE_PARKING_LOT(Role.MANAGER);
    //make it so that only a manager can create parking lots

    private Role[] roles;

    Feature(Role... roles) {this.roles = roles; }

    public List<Role> getRoles() { return newArrayList(roles); }

    public static List<Feature> getFeaturesForRoles(List<String> rolesOfUserAsString) {
        List<Role> rolesOfUser = rolesOfUserAsString.stream()
                .map(Role::valueOf)
                .collect(Collectors.toList());
        return Arrays.stream(Feature.values())
                .filter(feature -> !Collections.disjoint(feature.getRoles(), rolesOfUser))
                .collect(Collectors.toList());
    }
}
