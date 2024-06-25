package com.example.MathPlayOpen.profile.interfaces.acl;

import com.example.MathPlayOpen.profile.domain.model.commands.CreateProfileCommand;
import com.example.MathPlayOpen.profile.domain.model.queries.GetProfileByEmailQuery;
import com.example.MathPlayOpen.profile.domain.model.valueobjects.EmailAddress;
import com.example.MathPlayOpen.profile.domain.services.ProfileCommandService;
import com.example.MathPlayOpen.profile.domain.services.ProfileQueryService;
import org.springframework.stereotype.Service;

@Service
public class ProfilesContextFacade {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfilesContextFacade(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }

    public Long createProfile(String firstName, String lastName, String email, String password) {
        var createProfileCommand = new CreateProfileCommand(firstName, lastName, email, password);
        var profile = profileCommandService.handle(createProfileCommand);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();
    }

    public Long fetchProfileIdByEmail(String email) {
        var getProfileByEmailQuery = new GetProfileByEmailQuery(new EmailAddress(email));
        var profile = profileQueryService.handle(getProfileByEmailQuery);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();
    }
}
