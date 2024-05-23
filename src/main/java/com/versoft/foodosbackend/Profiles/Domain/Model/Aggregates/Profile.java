package com.versoft.foodosbackend.Profiles.Domain.Model.Aggregates;

import com.versoft.foodosbackend.Profiles.Domain.Model.ValueObjects.EmailAddress;
import com.versoft.foodosbackend.Profiles.Domain.Model.ValueObjects.PersonName;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.Date;

@Entity
public class Profile extends AbstractAggregateRoot<Profile> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    public Long id;

    @Lob
    @Column(length = 50000)
    private byte[] imageProfile;
    @Embedded
    private EmailAddress emailAddress;

    @Embedded
    private PersonName personName;


    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    public Profile(){}

    public Profile(byte[] imageProfile, String firstName,String email, String lastName) {
        this.imageProfile = imageProfile;
        this.emailAddress = new EmailAddress(email);
        this.personName = new PersonName(firstName,lastName);
    }
    public String getFullName(){
        return this.personName.getFullName();
    }
    public void updateName(String firstName, String lastName) {
        this.personName = new PersonName(firstName,lastName);
    }
}
