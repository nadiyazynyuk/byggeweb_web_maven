package dk.byggeweb.infrastructure.test;

import lombok.extern.log4j.Log4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j
public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        log.info(context.getSuite().getName().toUpperCase() + " SUITE STARTED");
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info(result.getMethod().getMethodName() + " TEST STARTED");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(result.getMethod().getMethodName() + " TEST PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info(result.getMethod().getMethodName() + " TEST FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info(result.getMethod().getMethodName() + " TEST SKIPPED");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info(context.getSuite().getName().toUpperCase() + " SUITE FINISHED");
    }

}
