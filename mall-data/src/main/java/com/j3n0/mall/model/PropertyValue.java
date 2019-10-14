package com.j3n0.mall.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;

@Entity
@Data
@Builder
public class PropertyValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pid")
    private Long pid;

    @Column(name = "ptid")
    private Long ptid;

    private String value;

    @Tolerate
    public PropertyValue() {}
}
