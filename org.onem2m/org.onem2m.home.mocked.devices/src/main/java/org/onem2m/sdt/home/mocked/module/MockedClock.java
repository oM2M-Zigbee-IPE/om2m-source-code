/*******************************************************************************
 * Copyright (c) 2014, 2016 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.onem2m.sdt.home.mocked.module;

import java.util.Date;

import org.onem2m.home.modules.Clock;
import org.onem2m.sdt.Domain;
import org.onem2m.sdt.datapoints.DateDataPoint;
import org.onem2m.sdt.datapoints.TimeDataPoint;
import org.onem2m.sdt.impl.DataPointException;

public class MockedClock extends Clock {

	public MockedClock(String name, Domain domain) {
		super(name, domain,
			new TimeDataPoint("currentTime") {
				private Date d = new Date();
				@Override
				public void doSetValue(Date value) throws DataPointException {
					d = value;
				}
				@Override
				public Date doGetValue() throws DataPointException {
					return d;
				}
			}, 
			new DateDataPoint("currentDate") {
				private Date d = new Date();
				@Override
				public void doSetValue(Date value) throws DataPointException {
					d = value;
				}
				@Override
				public Date doGetValue() throws DataPointException {
					return d;
				}
			});
	}

}
