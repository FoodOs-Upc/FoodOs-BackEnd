package com.versoft.foodosbackend.Profiles.Domain.Model.Aggregates;

import com.versoft.foodosbackend.Profiles.Domain.Model.ValueObjects.EmailAddress;
import com.versoft.foodosbackend.Profiles.Domain.Model.ValueObjects.PersonName;
import com.versoft.foodosbackend.Shared.Domain.Aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.Date;

@Entity
public class Profile extends AuditableAbstractAggregateRoot<Profile> {


    @Lob
    @Column(length = 5000000)
    @Getter
    private byte[] imageProfile;

    @Embedded
    private EmailAddress emailAddress;

    @Embedded
    private PersonName personName;




    public Profile(){}

    public Profile(byte[] imageProfile, String firstName,String email, String lastName) {
        this.imageProfile = imageProfile;
        this.emailAddress = new EmailAddress(email);
        this.personName = new PersonName(firstName,lastName);

    }
    public String getFullName(){
        return this.personName.getFullName();
    }
    public String getEmailAddress(){
        return this.emailAddress.addres();
    }
    public void updateName(String firstName, String lastName) {
        this.personName = new PersonName(firstName,lastName);
    }
    public void updatePhoto(byte[] photo){this.imageProfile = photo;}
    public void updateEmail(String email){this.emailAddress = new EmailAddress(email);}
    public String getLastName(){
        return this.personName.lastName();
    }
    public String getFirstName(){
        return this.personName.firstName();
    }
}
