package com.msa_study.demo.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    private Member(final String name, final String address, final List<Order> orders) {
        this.name = name;
        this.address = address;
        this.orders = orders;
    }

    public static Member newInstance(final String name, final String address) {
        return new Member(
                name,
                address,
                Collections.emptyList()
        );
    }
}
