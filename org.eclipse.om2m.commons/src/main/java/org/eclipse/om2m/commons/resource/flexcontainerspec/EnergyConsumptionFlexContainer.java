/*
ModuleClass : EnergyConsumption



This ModuleClass describes the energy consumed by the device  since power up. One particular use case for energyConsumption  ModuleClass is smart meter.

Created: 2017-08-09 15:38:05
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.eclipse.om2m.commons.resource.AbstractFlexContainer;
import org.eclipse.om2m.commons.resource.AbstractFlexContainerAnnc;


@XmlRootElement(name = EnergyConsumptionFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = EnergyConsumptionFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class EnergyConsumptionFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "energyConsumption";
	public static final String SHORT_NAME = "eneCn";
	
	public EnergyConsumptionFlexContainer () {
		setContainerDefinition("org.onem2m.home.moduleclass." + EnergyConsumptionFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
	
	public void finalizeSerialization() {
	}
	
}