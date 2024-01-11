package org.pom;

public class PageManager {
	private Amazonlocator amazonLocator;
	private FlipkartLocator flipkartLocator;
	
	public Amazonlocator getAmazonLocator() {
		if(amazonLocator==null) {
			amazonLocator=new Amazonlocator();
		}
		return amazonLocator;
	}
	
	public FlipkartLocator getFlipkartLocator() {
		if(flipkartLocator==null) {
			flipkartLocator=new FlipkartLocator();
		}
		return flipkartLocator;
		
	}
	

}
