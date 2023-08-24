package com.example.cadencesandbox.cadence;

import java.util.UUID;

public class InsuranceActivitiesImpl implements InsuranceActivities {
    @Override
    public String fillApplication(String name) {
        System.out.println("process");
        return UUID.randomUUID().toString();
    }

    @Override
    public Boolean riskAssessment(String applicationId) {
        System.out.println("risk process");
        return true;
    }

    @Override
    public Boolean makeDecision(String applicationId) {
        System.out.println("decision process");
        return true;
    }

    @Override
    public Boolean acceptApplication(String applicationId) {
        System.out.println("accept process");
        return true;
    }

    @Override
    public String rejectApplication(String applicationId) {
        System.out.println("rejectprocess");
        return applicationId;
    }
}
