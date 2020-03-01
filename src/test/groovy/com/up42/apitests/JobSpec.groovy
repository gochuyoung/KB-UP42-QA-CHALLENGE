package com.up42.apitests

import com.up42.apitests.dto.Block
import spock.util.concurrent.PollingConditions

import static com.up42.apitests.factory.BlockFactory.buildSentinelBlock
import static com.up42.apitests.factory.BlockFactory.buildSharpeningFilterBlock
import static com.up42.apitests.factory.JobFactory.buildJob
import static com.up42.apitests.service.BlockService.postNewBlock
import static com.up42.apitests.service.JobService.getJobStatus
import static com.up42.apitests.service.JobService.postNewJob

class JobSpec extends BaseSpec {

    static final String SUCCEEDED_JOB_STATUS = "SUCCEEDED"
    static final ArrayList<Block> blocks = [buildSentinelBlock(), buildSharpeningFilterBlock()]

    PollingConditions jobPollingCondition = new PollingConditions(delay: 5, timeout: 60)

    def "should newly created job succeed"() {
        given:
            postNewBlock(blocks, WORKFLOW_ID)
        when:
            def jobId = postNewJob(buildJob(), WORKFLOW_ID)
        then:
            shouldJobSucceed(jobId)
    }

    def shouldJobSucceed(String jobId) {
        jobPollingCondition.eventually {
            assert getJobStatus(jobId) == SUCCEEDED_JOB_STATUS
        }
        return true
    }

}
