/*
ModuleClass : Colour



This ModuleClass provides the capabilities to set the value of  Red, Green, Blue for the color device.

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


@XmlRootElement(name = ColourFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = ColourFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class ColourFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "colour";
	public static final String SHORT_NAME = "color";
	
	public ColourFlexContainer () {
		setContainerDefinition("org.onem2m.home.moduleclass." + ColourFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
	
	public void finalizeSerialization() {
	}
	
}