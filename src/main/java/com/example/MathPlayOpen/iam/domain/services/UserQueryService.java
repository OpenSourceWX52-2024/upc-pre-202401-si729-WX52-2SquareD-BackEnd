package com.example.MathPlayOpen.iam.domain.services;

import com.example.MathPlayOpen.iam.domain.model.aggregates.User;
import com.example.MathPlayOpen.iam.domain.model.queries.GetAllUsersQuery;
import com.example.MathPlayOpen.iam.domain.model.queries.GetUserByEmailQuery;
import com.example.MathPlayOpen.iam.domain.model.queries.GetUserByIdQuery;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByEmailQuery query);

}
