package com.example.MathPlayOpen.profile.domain.model.aggregates;

import com.example.MathPlayOpen.profile.domain.model.valueobjects.ProfileId;
import com.example.MathPlayOpen.profile.domain.model.valueobjects.ProfileName;
import com.example.MathPlayOpen.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class Profile extends AuditableAbstractAggregateRoot<Profile> {
    //private  String username;
    //private String email;
    //private String password;
//
    //@Embedded
    //private ProfileId profileId;
//
    //@Embedded
    //private ProfileName profileName;
//
    //public Profile(ProfileId profileId, ProfileName profileName, String username, String email, String password) {
    //    this.profileId = profileId;
    //    this.profileName = profileName;
    //    this.username = username;
    //    this.email = email;
    //    this.password = password;
    //}
}
