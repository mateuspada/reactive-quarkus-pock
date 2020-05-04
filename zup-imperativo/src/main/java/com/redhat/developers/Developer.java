package com.redhat.developers;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.Formula;

import javax.persistence.Entity;

@Entity
public class Developer extends PanacheEntity {
    public String name;

    @Formula("sleep(1)")
    private int sleep;
}
