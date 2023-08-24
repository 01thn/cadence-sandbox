package com.example.cadencesandbox.cadence;

import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import com.uber.cadence.worker.Worker;
import com.uber.cadence.worker.WorkerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class InsuranceWorker {

    private static final Logger log = Logger.getLogger(String.valueOf(InsuranceWorker.class));

    public static final String TASK_LIST = "insuranceActivities";
    public static final String DOMAIN = "test-domain-1";

    public void work() {
        // Get a new client
        WorkflowClient workflowClient =
                WorkflowClient.newInstance(
                        new WorkflowServiceTChannel(ClientOptions.defaultInstance()),
                        WorkflowClientOptions.newBuilder().setDomain(DOMAIN).build());
        // Get worker to poll the common task list.
        InsuranceWorkflow insuranceWorkflow = workflowClient.newWorkflowStub(InsuranceWorkflow.class);
        WorkerFactory factory = WorkerFactory.newInstance(workflowClient);
        Worker workerForCommonTaskList = factory.newWorker(TASK_LIST);
        workerForCommonTaskList.registerWorkflowImplementationTypes(InsuranceWorkflowImpl.class);
        workerForCommonTaskList.registerActivitiesImplementations(new InsuranceActivitiesImpl());

        // Start all workers created by this factory.
        factory.start();
        log.info("Start process");
        insuranceWorkflow.getInsurance();
        System.out.println("Worker started for task list: " + TASK_LIST);
    }
}
