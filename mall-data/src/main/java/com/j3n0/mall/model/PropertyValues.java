package com.j3n0.mall.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PropertyValues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pid")
    private Long pid;

    @Column(name = "ptid")
    private Long ptid;

    private String value;
}
