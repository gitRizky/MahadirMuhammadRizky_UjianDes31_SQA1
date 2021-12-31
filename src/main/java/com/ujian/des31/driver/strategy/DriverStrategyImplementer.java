package com.ujian.des31.driver.strategy;

import com.ujian.des31.driver.utils.Constans;

public class DriverStrategyImplementer {
	public static DriverStrategy chooseStrategy(String strategy) {
		switch (strategy) {
		case Constans.CHROME:
			return new Chrome();

		case Constans.FIREFOX:
			return new Firefox();

		default:
			return null;
		}

	}
}
