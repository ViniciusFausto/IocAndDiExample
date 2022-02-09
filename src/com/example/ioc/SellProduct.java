package com.example.ioc;

public class SellProduct {
	
	/*
	 * PROBLEM:
	 *
	 * Note that all control of the "log" object is under the responsibility of the
	 * class SellProduct, which is not ideal. For example, if we need to change the
	 * name of the file that will insert the Log the right thing is that this
	 * responsibility is not of the Sell product class.
	 */
	public void sellProductWrong(Product product) {
		Log log = new Log("File.txt");
		log.insert(product);
	}

	/*
	 * RESOLUTION:
	 *
	 * To solve this I used the Dependency Injection via constructor. But what does
	 * that mean? I created an instance variable of type Log and instantiated it
	 * through the constructor, thus giving all responsibility to the log class to
	 * control this dependency.
	 */
	private Log log;

	public SellProduct(Log logSell) {
		this.log = logSell;
	}

	public void sellProductCorrectly(Product product) {
		log.insert(product);
	}

	/*
	 * CONCLUSION: 
	 * 
	 * We had a problem and needed to use Inversion of Control to be
	 * able to resolve it. To apply control inversion we used Dependency Injection
	 * via the builder.
	 */
}
