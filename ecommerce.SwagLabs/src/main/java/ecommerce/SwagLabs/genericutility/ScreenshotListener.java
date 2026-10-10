package ecommerce.SwagLabs.genericutility;

import org.testng.ITestListener;
import org.testng.ITestResult;

import ecommerce.SwagLabs.baseClass.BaseClass;

public class ScreenshotListener implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		captureScreenshot(result, "PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		captureScreenshot(result, "FAIL");
	}

	private void captureScreenshot(ITestResult result, String status) {

		try {

			Object testObject = result.getInstance();

			BaseClass baseClass = (BaseClass) testObject;

			if (baseClass.driver != null) {

				String testName = result.getMethod().getMethodName();

				ScreenshotUtility.takeScreenshot(baseClass.driver, testName, status);
			}

		} catch (Exception e) {

			System.out.println("Unable to capture screenshot for: " + result.getName());

			e.printStackTrace();
		}
	}
}