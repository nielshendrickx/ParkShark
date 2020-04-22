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

    @Column(name = "monthlyCost")
    private double monthlyCost;

    @Column(name = "reduction")
    private double reduction;

    @Column(name = "maxParkHours")
    private int maxParkHours;

    public MembershipLevel() {
    }

    public MembershipLevel(String name, double monthlyCost, double reduction, int maxParkHours) {
        this.name = name;
        this.monthlyCost = monthlyCost;
        this.reduction = reduction;
        this.maxParkHours = maxParkHours;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public double getReduction() {
        return reduction;
    }

    public int getMaxParkHours() {
        return maxParkHours;
    }
}
