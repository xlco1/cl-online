/**
 * 
 */
package clo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author ssreenivasan
 *
 */
public class Listener implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		result.getName();
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("~~PASSED~~"+ result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("~~FAILED~~"+ result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("~~SKIPPED~~ "+ result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("~~FAILED WITH SUCESSPERCENTAGE~~ "+ result.getName());
		
	}

	public void onStart(ITestContext context) {
		System.out.println("~~STARTED~~ "+ context.getName());
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("~~FINISHED~~  "+ context.getName());
		
	}

}
