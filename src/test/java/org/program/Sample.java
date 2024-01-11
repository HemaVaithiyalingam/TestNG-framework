package org.program;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sample {
	@BeforeClass()
	private void bfrclass() {
		System.out.println("bfr class");
	}
	@AfterClass
	private void aftrclass() {
		System.out.println("after class");
	}
@Test(priority = 2,dependsOnMethods = "tc3",groups = "sanity")
private void tc1() {
	System.out.println("tc1");
}
@Test(priority = 1,invocationCount = 3,groups = {"sanity","smoke"})
private void tc3() {
	System.out.println("tc3");
}
@Test(priority = 3,enabled = true,groups = {"sanity","smoke","regression"})
private void tc2() {
	System.out.println("tc2");
}
@Test(groups = "regression")
private void tc4() {
	System.out.println("tc4");
}
@Test(groups = "smoke")//if no priority gn it will execute first
private void tc5() {
	System.out.println("tc5");
}

}
