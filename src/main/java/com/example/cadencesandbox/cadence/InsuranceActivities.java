package com.example.cadencesandbox.cadence;

import com.uber.cadence.activity.ActivityMethod;

public interface InsuranceActivities {

    @ActivityMethod(scheduleToCloseTimeoutSeconds = 15)
    String fillApplication(String name);

    @ActivityMethod
    Boolean riskAssessment(String applicationId);

    @ActivityMethod
    Boolean makeDecision(String applicationId);

    @ActivityMethod
    Boolean acceptApplication(String applicationId);

    @ActivityMethod
    String rejectApplication(String applicationId);
}
