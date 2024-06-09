package com.example.MathPlayOpen.profile.domain.model.aggregates;

import com.example.MathPlayOpen.profile.domain.model.commands.CreateProfileCommand;
import com.example.MathPlayOpen.profile.domain.model.valueobjects.EmailAddress;
import com.example.MathPlayOpen.profile.domain.model.valueobjects.ProfileId;
import com.example.MathPlayOpen.profile.domain.model.valueobjects.ProfileName;
import com.example.MathPlayOpen.profile.domain.model.valueobjects.ProfilePassword;
import com.example.MathPlayOpen.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class Profile extends AuditableAbstractAggregateRoot<Profile> {
    @Embedded
    private ProfileName name;

    @Embedded
    private EmailAddress email;

    @Embedded
    private ProfilePassword password;

    public Profile(String firstName, String LastName, String email, String password) {
        this.name = new ProfileName(firstName, LastName);
        this.email = new EmailAddress(email);
        this.password = new ProfilePassword(password);
    }

    public Profile(CreateProfileCommand command) {
        this.name = new ProfileName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
        this.password = new ProfilePassword(command.password());
    }

    public Profile() {

    }

    public void updateName(String firstName, String lastName) {
        this.name = new ProfileName(firstName, lastName);
    }

    public String getFullName() { return name.fullName(); }

    public String getEmailAddress() { return email.address(); }

    public String getPassword() { return password.content(); }
}
