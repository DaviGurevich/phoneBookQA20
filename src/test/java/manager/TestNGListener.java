package manager;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


    @Slf4j
    public class TestNGListener implements ITestListener {

        @Override
        public void onTestStart(ITestResult result) {
            log.info("started test: " + result.getName());
            ITestListener.super.onTestStart(result);
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            log.info("test success: " + result.getName());
            ITestListener.super.onTestSuccess(result);
        }

        @Override
        public void onTestFailure(ITestResult result) {
            log.info("test failure: " + result.getName());
            ITestListener.super.onTestFailure(result);
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            log.info("test skipped: " + result.getName());
            ITestListener.super.onTestSkipped(result);
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
            ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        }

        @Override
        public void onTestFailedWithTimeout(ITestResult result) {
            log.info("test out of time: " + result.getName());
            ITestListener.super.onTestFailedWithTimeout(result);
        }

        @Override
        public void onStart(ITestContext context) {
            log.info("start test - onstart - : " + context.getName());
            ITestListener.super.onStart(context);
        }

        @Override
        public void onFinish(ITestContext context) {
            log.info("all code executed: passed tests: " + context.getPassedTests());
            log.info("all code executed: failed tests: " + context.getFailedTests());
            ITestListener.super.onFinish(context);
        }
    }


