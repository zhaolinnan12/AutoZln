package utils;


import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

/**
 * create by Anthony on 2017/11/23
 */
public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("用例启动。" + iTestResult.toString());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("用例执行成功，" + iTestResult.toString());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("用例运行失败，启动截图。");
        // 调用截图方法
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Test
    public void listenerExampletest() {

        Assert.assertTrue(11 == 11);
    }
}
