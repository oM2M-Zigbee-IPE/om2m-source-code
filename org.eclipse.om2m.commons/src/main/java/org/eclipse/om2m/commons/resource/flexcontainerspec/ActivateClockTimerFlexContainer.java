/*
Action : activateClockTimer



Activate current clock timer.

Created: 2017-08-09 14:07:04
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.eclipse.om2m.commons.resource.AbstractFlexContainer;
import org.eclipse.om2m.commons.resource.AbstractFlexContainerAnnc;


@XmlRootElement(name = ActivateClockTimerFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = ActivateClockTimerFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class ActivateClockTimerFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "activateClockTimer";
	public static final String SHORT_NAME = "acCTr";
	
	public ActivateClockTimerFlexContainer () {
		setContainerDefinition("org.onem2m.home.moduleclass.timer." + ActivateClockTimerFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
	
}