package com.switchfully.parkshark.domain.user.member;

import javax.persistence.*;

@Entity
@Table(name = "membershiplevel")
public class MembershipLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "monthly_cost")
    private double monthlyCost;

    @Column(name = "reduction")
    private double reduction;

    @Column(name = "max_park_hours")
    private int maxParkHours;

    public MembershipLevel() {
    }
}
