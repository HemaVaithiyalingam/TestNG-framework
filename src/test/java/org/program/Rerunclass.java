
package org.program;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

public class Rerunclass implements IRetryAnalyzer {
	int min=1;
	int max=3;

	@Override
	public boolean retry(ITestResult result) {
		if(min<=max) {
			min++;
			return true;
		}
		
		return false;
	}

	
}
