package com.example.MathPlayOpen.iam.domain.services;

import com.example.MathPlayOpen.iam.domain.model.aggregates.User;
import com.example.MathPlayOpen.iam.domain.model.commands.SignInCommand;
import com.example.MathPlayOpen.iam.domain.model.commands.SignUpCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Optional;

public interface UserCommandService {
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
    Optional<User> handle(SignUpCommand command);


}
