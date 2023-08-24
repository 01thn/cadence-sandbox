package com.example.cadencesandbox.cadence;

import com.uber.cadence.workflow.WorkflowMethod;

import static com.example.cadencesandbox.cadence.InsuranceWorker.TASK_LIST;

public interface InsuranceWorkflow {
    @WorkflowMethod(executionStartToCloseTimeoutSeconds = 10, taskList = TASK_LIST)
    void getInsurance();
}
