package com.example.MathPlayOpen.iam.domain.services;

import com.example.MathPlayOpen.iam.domain.model.aggregates.User;
import com.example.MathPlayOpen.iam.domain.model.queries.GetAllUsersQuery;
import com.example.MathPlayOpen.iam.domain.model.queries.GetUserByIdQuery;
import com.example.MathPlayOpen.iam.domain.model.queries.GetUserByUsernameQuery;


import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByUsernameQuery query);

}
