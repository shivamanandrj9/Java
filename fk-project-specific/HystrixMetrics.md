## Using Hystrix pool Metrics ##

### For DB calls ###

 ```
 ConnectionDetails connectionDetails = ConnectionDetails.builder()
.commandKey(FETCH_TREND_CONCEPT)
.poolName(MONGO_READ_REPLICA)
.build();
```

The pool name specifies the thread pool config that needs to be used on a pod. The config is defined in simpleProxy and those config is used in the code. The commandKey is just an identifier for to know what usecase is using the thread pool. The circuit break thing will be used based on the commandKey name. If there are multiple failures happening, the circuit will be opened and the thread pool will be stopped for that usecase.

The metrics published are:

<details>
<summary> CommandKey Metrics (The one using the pool) </summary>

```
"prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.countBadRequests.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.countCollapsedRequests.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.countEmit.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.countExceptionsThrown.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.countFailure.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.countFallbackEmit.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.countFallbackFailure.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.countFallbackMissing.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.countFallbackRejection.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.countFallbackSuccess.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.countResponsesFromCache.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.countSemaphoreRejected.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.countShortCircuited.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.countSuccess.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.countThreadPoolRejected.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.countTimeout.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.currentTime.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.errorPercentage.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.executionSemaphorePermitsInUse.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.latencyExecute_mean.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.latencyExecute_percentile_25.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.latencyExecute_percentile_5.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.latencyExecute_percentile_50.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.latencyExecute_percentile_75.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.latencyExecute_percentile_90.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.latencyExecute_percentile_99.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.latencyExecute_percentile_995.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.latencyTotal_mean.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.latencyTotal_percentile_25.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.latencyTotal_percentile_5.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.latencyTotal_percentile_50.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.latencyTotal_percentile_75.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.latencyTotal_percentile_90.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.latencyTotal_percentile_99.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.latencyTotal_percentile_995.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.propertyValue_circuitBreakerErrorThresholdPercentage.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.propertyValue_circuitBreakerRequestVolumeThreshold.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.propertyValue_circuitBreakerSleepWindowInMilliseconds.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.propertyValue_executionIsolationSemaphoreMaxConcurrentRequests.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.propertyValue_executionIsolationThreadTimeoutInMilliseconds.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.propertyValue_executionTimeoutInMilliseconds.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.propertyValue_fallbackIsolationSemaphoreMaxConcurrentRequests.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.propertyValue_rollingStatisticalWindowInMilliseconds.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.rollingCountBadRequests.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.rollingCountCollapsedRequests.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.rollingCountEmit.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.rollingCountExceptionsThrown.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.rollingCountFailure.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.rollingCountFallbackEmit.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.rollingCountFallbackFailure.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.rollingCountFallbackMissing.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.rollingCountFallbackRejection.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.rollingCountFallbackSuccess.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.rollingCountResponsesFromCache.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.rollingCountSemaphoreRejected.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.rollingCountShortCircuited.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.rollingCountSuccess.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.rollingCountThreadPoolRejected.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.mongo.read.replicaGroup.fetch.trend.concept.rollingCountTimeout.Value",
```
</details>

<details>
<summary>Hystrix Thread Pool Metrics</summary>
"prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.mongo.readThreadPool.completedTaskCount.Value",
"prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.mongo.readThreadPool.countThreadsExecuted.Value",
"prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.mongo.readThreadPool.currentTime.Value",
"prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.mongo.readThreadPool.largestPoolSize.Value",
"prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.mongo.readThreadPool.propertyValue_actualMaximumSize.Value",
"prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.mongo.readThreadPool.propertyValue_corePoolSize.Value",
"prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.mongo.readThreadPool.propertyValue_keepAliveTimeInMinutes.Value",
"prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.mongo.readThreadPool.propertyValue_maxQueueSize.Value",
"prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.mongo.readThreadPool.propertyValue_maximumSize.Value",
"prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.mongo.readThreadPool.propertyValue_queueSizeRejectionThreshold.Value",
"prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.mongo.readThreadPool.queueSize.Value",
"prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.mongo.readThreadPool.rollingCountCommandsRejected.Value",
"prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.mongo.readThreadPool.rollingCountThreadsExecuted.Value",
"prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.mongo.readThreadPool.rollingMaxActiveThreads.Value",
"prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.mongo.readThreadPool.threadActiveCount.Value",
"prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.mongo.readThreadPool.totalTaskCount.Value",
</details>

### For Http Calls ###

```
CommandResponse response = SimpleProxy.PROXY.getHttpCommand(CATALOG_SEMANTICS_CLIENT, HystrixCommandKey.Factory.asKey(CATALOG_SEMANTICS_CLIENT), httpReqWrapper).exec();
```

Interface used for above command
```

 public CommandExecutable getHttpCommand(String name, HystrixCommandKey command, HttpRequestWrapper httpRequestWrapper);
```

Appears in command metrics as: [name]Group.[command].metric
name is pool name.



<details>
<summary> Hystrix Thread Pool Metrics </summary>
"prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.catalog.semantics.clientThreadPool.completedTaskCount.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.catalog.semantics.clientThreadPool.countThreadsExecuted.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.catalog.semantics.clientThreadPool.currentTime.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.catalog.semantics.clientThreadPool.largestPoolSize.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.catalog.semantics.clientThreadPool.propertyValue_actualMaximumSize.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.catalog.semantics.clientThreadPool.propertyValue_corePoolSize.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.catalog.semantics.clientThreadPool.propertyValue_keepAliveTimeInMinutes.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.catalog.semantics.clientThreadPool.propertyValue_maxQueueSize.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.catalog.semantics.clientThreadPool.propertyValue_maximumSize.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.catalog.semantics.clientThreadPool.propertyValue_queueSizeRejectionThreshold.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.catalog.semantics.clientThreadPool.queueSize.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.catalog.semantics.clientThreadPool.rollingCountCommandsRejected.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.catalog.semantics.clientThreadPool.rollingCountThreadsExecuted.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.catalog.semantics.clientThreadPool.rollingMaxActiveThreads.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.catalog.semantics.clientThreadPool.threadActiveCount.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.HystrixThreadPool.catalog.semantics.clientThreadPool.totalTaskCount.Value",
</details>

<details>
<summary> CommandKey Metrics </summary>
"prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.countBadRequests.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.countCollapsedRequests.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.countEmit.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.countExceptionsThrown.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.countFailure.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.countFallbackEmit.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.countFallbackFailure.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.countFallbackMissing.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.countFallbackRejection.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.countFallbackSuccess.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.countResponsesFromCache.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.countSemaphoreRejected.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.countShortCircuited.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.countSuccess.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.countThreadPoolRejected.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.countTimeout.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.currentTime.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.errorPercentage.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.executionSemaphorePermitsInUse.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.latencyExecute_mean.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.latencyExecute_percentile_25.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.latencyExecute_percentile_5.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.latencyExecute_percentile_50.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.latencyExecute_percentile_75.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.latencyExecute_percentile_90.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.latencyExecute_percentile_99.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.latencyExecute_percentile_995.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.latencyTotal_mean.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.latencyTotal_percentile_25.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.latencyTotal_percentile_5.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.latencyTotal_percentile_50.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.latencyTotal_percentile_75.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.latencyTotal_percentile_90.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.latencyTotal_percentile_99.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.latencyTotal_percentile_995.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.propertyValue_circuitBreakerErrorThresholdPercentage.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.propertyValue_circuitBreakerRequestVolumeThreshold.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.propertyValue_circuitBreakerSleepWindowInMilliseconds.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.propertyValue_executionIsolationSemaphoreMaxConcurrentRequests.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.propertyValue_executionIsolationThreadTimeoutInMilliseconds.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.propertyValue_executionTimeoutInMilliseconds.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.propertyValue_fallbackIsolationSemaphoreMaxConcurrentRequests.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.propertyValue_rollingStatisticalWindowInMilliseconds.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.rollingCountBadRequests.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.rollingCountCollapsedRequests.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.rollingCountEmit.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.rollingCountExceptionsThrown.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.rollingCountFailure.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.rollingCountFallbackEmit.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.rollingCountFallbackFailure.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.rollingCountFallbackMissing.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.rollingCountFallbackRejection.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.rollingCountFallbackSuccess.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.rollingCountResponsesFromCache.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.rollingCountSemaphoreRejected.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.rollingCountShortCircuited.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.rollingCountSuccess.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.rollingCountThreadPoolRejected.Value",
  "prod-user-feeds-cgt-service.jmx.metrics.catalog.semantics.clientGroup.catalog.semantics.client.rollingCountTimeout.Value",
</details>



## Different metrics meaning ##


1. It has a rolling window time of 10 buckets where each bucket is of 1 sec. For calculation like this where we need some set of data to calculate the value. We use this 10 sec rolling window or 10 buckets to calculate for a given time.

2. Here,
   ```avg(jmx_metrics_mongo_writeGroup_tag_fsn_latencyExecute_percentile_99_Value)```
    Average is done do it across both the pods.

3. ```sum(rate(jmx_metrics_mongo_writeGroup_tag_fsn_countSuccess_Value))```
    Counters in monitoring systems are monotonically increasing (they only go up). The raw value is the total number of successful executions since the service started. The rate() function calculates the per-second increase of the counter resulting in the per-second successCount value.








