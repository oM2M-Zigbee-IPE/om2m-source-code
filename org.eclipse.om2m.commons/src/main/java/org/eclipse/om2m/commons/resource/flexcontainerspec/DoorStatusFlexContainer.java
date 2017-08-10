/*
ModuleClass : DoorStatus



This ModuleClass provides the status of a door. It is intended  to be part of a larger object such as a refrigerator and an oven  that might have multiple doors.

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


@XmlRootElement(name = DoorStatusFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = DoorStatusFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class DoorStatusFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "doorStatus";
	public static final String SHORT_NAME = "dooSs";
	
	public DoorStatusFlexContainer () {
		setContainerDefinition("org.onem2m.home.moduleclass." + DoorStatusFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
	
	public void finalizeSerialization() {
	}
	
}