package com.example.MathPlayOpen.subscription.interfaces.rest.transform;

import com.example.MathPlayOpen.subscription.domain.models.commands.CreateSubscriptionCommand;
import com.example.MathPlayOpen.subscription.interfaces.rest.resources.CreateSubscriptionResource;

import java.text.SimpleDateFormat;

public class CreateSubscriptionCommandFromResourceAssembler {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static CreateSubscriptionCommand toCommandFromResource(CreateSubscriptionResource resource) {
        String startDate = dateFormat.format(resource.subscriptionStartDate());
        String endDate = dateFormat.format(resource.subscriptionEndDate());

        return new CreateSubscriptionCommand(resource.userId(), resource.planId(), startDate, endDate, resource.subscriptionStatus(), resource.subscriptionDescription());
    }
}
