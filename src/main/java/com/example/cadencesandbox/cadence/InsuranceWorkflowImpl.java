package com.example.cadencesandbox.cadence;

import com.uber.cadence.activity.ActivityOptions;
import com.uber.cadence.workflow.ActivityException;
import com.uber.cadence.workflow.Workflow;

import java.time.Duration;

public class InsuranceWorkflowImpl implements InsuranceWorkflow {

    private final ActivityOptions options =
            new ActivityOptions.Builder().setScheduleToCloseTimeout(Duration.ofSeconds(20)).build();
    private final InsuranceActivities insuranceActivities =
            Workflow.newActivityStub(InsuranceActivities.class, options);

    @Override
    public void getInsurance() {
        String id = insuranceActivities.fillApplication("test");
        try {
            insuranceActivities.riskAssessment(id);
            insuranceActivities.makeDecision(id);
        } catch (ActivityException e) {
            insuranceActivities.rejectApplication(id);
        }
    }
}
