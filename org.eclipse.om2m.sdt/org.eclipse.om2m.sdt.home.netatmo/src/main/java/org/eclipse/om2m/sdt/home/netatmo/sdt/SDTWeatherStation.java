/*******************************************************************************
 * Copyright (c) 2014, 2016 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *******************************************************************************/
package org.eclipse.om2m.sdt.home.netatmo.sdt;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.eclipse.om2m.sdt.datapoints.FloatDataPoint;
import org.eclipse.om2m.sdt.datapoints.IntegerDataPoint;
import org.eclipse.om2m.sdt.datapoints.StringDataPoint;
import org.eclipse.om2m.sdt.exceptions.DataPointException;
import org.eclipse.om2m.sdt.home.devices.WeatherStation;
import org.eclipse.om2m.sdt.home.driver.Utils;
import org.eclipse.om2m.sdt.home.modules.AcousticSensor;
import org.eclipse.om2m.sdt.home.modules.AirQualitySensor;
import org.eclipse.om2m.sdt.home.modules.Barometer;
import org.eclipse.om2m.sdt.home.modules.Temperature;
import org.eclipse.om2m.sdt.home.netatmo.impl.Activator;
import org.eclipse.om2m.sdt.home.netatmo.model.WeatherStationModule;
import org.eclipse.om2m.sdt.home.types.DatapointType;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

@SuppressWarnings("rawtypes")
public class SDTWeatherStation extends WeatherStation {

	private List<ServiceRegistration> serviceRegistrations;

	private final WeatherStationModule stationOrModule;

	public SDTWeatherStation(WeatherStationModule pStationOrModule) {
		super(computeId(pStationOrModule.getName()),
				pStationOrModule.getId(), Activator.NETATMO_DOMAIN);
		this.stationOrModule = pStationOrModule;
		
		setDeviceManufacturer("Netatmo");
		setDeviceModelName("WeatherStation");
		setDeviceName(pStationOrModule.getName());
		setProtocol(Activator.PROTOCOL);
		try {
			setPresentationURL(new URL("https://www.netatmo.com/product/weather/weatherstation"));
		} catch (MalformedURLException ignored) {
		}

		if (stationOrModule.getDataTypes().contains(WeatherStationModule.TEMPERATURE_DATA_TYPE)) {
			// temperature
			setIndoorTemperature(new Temperature("temperature_" + getId(), Activator.NETATMO_DOMAIN,
				new FloatDataPoint(DatapointType.currentTemperature) {
					@Override
					protected Float doGetValue() throws DataPointException {
						return new Double(stationOrModule.getCurrentTemperature()).floatValue();
					}
				}));
			getIndoorTemperature().setMinValue(new FloatDataPoint(DatapointType.minValue) {
				@Override
				protected Float doGetValue() throws DataPointException {
					return new Double(stationOrModule.getMinTemperature()).floatValue();
				}
			});
			getIndoorTemperature().setMaxValue(new FloatDataPoint(DatapointType.maxValue) {
				@Override
				protected Float doGetValue() throws DataPointException {
					return new Double(stationOrModule.getMaxTemperature()).floatValue();
				}
			});
			getIndoorTemperature().setUnit(new StringDataPoint(DatapointType.unit) {
				@Override
				protected String doGetValue() throws DataPointException {
					return "°C";
				}
			});
		}

		if (stationOrModule.getDataTypes().contains(WeatherStationModule.NOISE_DATA_TYPE)) {
			// noise
			setAcousticSensor(new AcousticSensor("noise_" + getId(), Activator.NETATMO_DOMAIN, 
				new FloatDataPoint(DatapointType.loudness) {
					@Override
					protected Float doGetValue() throws DataPointException {
						return (float)stationOrModule.getNoise();
					}
				}));
		}

		if (stationOrModule.getDataTypes().contains(WeatherStationModule.PRESSURE_DATA_TYPE)) {
			// pressure
			setBarometer(new Barometer("atmosphericPressureSensor_" + getId(), 
				Activator.NETATMO_DOMAIN, 
				new FloatDataPoint(DatapointType.atmosphericPressure) {
					@Override
					protected Float doGetValue() throws DataPointException {
						return new Double(stationOrModule.getAbsolutePressure()).floatValue();
					}
				}));
		}

		AirQualitySensor airQuality = new AirQualitySensor("airQuality_" + getId(), Activator.NETATMO_DOMAIN);
		setAirQualitySensor(airQuality);

		if (stationOrModule.getDataTypes().contains(WeatherStationModule.HUMIDITY_DATA_TYPE)) {
			airQuality.setSensorHumidity(new IntegerDataPoint(DatapointType.sensorHumidity) {
				@Override
				protected Integer doGetValue() throws DataPointException {
					return (int) stationOrModule.getHumidity();
				}
			});
		}

		if (stationOrModule.getDataTypes().contains(WeatherStationModule.CO2_DATA_TYPE)) {
			// co2
			airQuality.setCo2(new IntegerDataPoint(DatapointType.co2) {
				@Override
				protected Integer doGetValue() throws DataPointException {
					return (int)stationOrModule.getCo2();
				}
			});
		}
	}

	public void register(BundleContext bundleContext) {
		serviceRegistrations = Utils.register(this, bundleContext);
	}

	public void unregister() {
		for (ServiceRegistration sr : serviceRegistrations) {
			sr.unregister();
		}
		
		// remove all modules & device object from domain
		Activator.NETATMO_DOMAIN.removeDevice(getName());
	}

	private static String computeId(String pId) {
		return pId.replaceAll("[^a-zA-Z0-9]+", "_").trim();
	}

}
