package com.versoft.foodosbackend.Shared.Domain.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass

public class AuditableModel {
    @Getter
    @CreatedDate
    @Column(nullable = false,updatable = false)
    private Date createAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updateAt;
}
