package com.example.MathPlayOpen.user.application.internal.outboundservices;

import com.example.MathPlayOpen.profile.interfaces.acl.ProfilesContextFacade;
import com.example.MathPlayOpen.user.domain.model.valueobjets.ProfileId;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ExternalProfileService
 *
 * <p>
 *     This class is an outbound service used by the Learning Context to interact with the Profiles Context.
 *     It is implemented as part of an anti-corruption layer (ACL) to decouple the Learning Context from the Profiles Context.
 * </p>
 *
 */
@Service
public class ExternalProfileService {

    private final ProfilesContextFacade profilesContextFacade;

    public ExternalProfileService(ProfilesContextFacade profilesContextFacade, @Qualifier("passwordEncoder") PasswordEncoder passwordEncoder) {
        this.profilesContextFacade = profilesContextFacade;
    }

    /**
     * Fetch profileId by email
     *
     * @param email the email to search for
     * @return profileId if found, empty otherwise
     */
    public Optional<ProfileId> fetchProfileIdByEmail(String email) {
        var profileId = profilesContextFacade.fetchProfileIdByEmail(email);
        if (profileId == 0L) return Optional.empty();
        return Optional.of(new ProfileId(profileId));
    }

    public Optional<ProfileId> createProfile(String firstName, String lastName, String email, String password) {
        var profileId = profilesContextFacade.createProfile(firstName, lastName, email, password);
        if (profileId == 0L) return Optional.empty();
        return Optional.of(new ProfileId(profileId));
    }
}