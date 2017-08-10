/*
Device : DeviceWarningDeviceAnnc



A WarningDevice is a device that prevents users about an alarm (ie a siren).

Created: 2017-08-09 15:38:06
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.eclipse.om2m.commons.resource.AbstractFlexContainer;
import org.eclipse.om2m.commons.resource.AbstractFlexContainerAnnc;


@XmlRootElement(name = DeviceWarningDeviceFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = DeviceWarningDeviceFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class DeviceWarningDeviceFlexContainerAnnc extends AbstractFlexContainerAnnc {
	
	public static final String LONG_NAME = "deviceWarningDeviceAnnc";
	public static final String SHORT_NAME = "deWDeAnnc";
	
	public DeviceWarningDeviceFlexContainerAnnc () {
		setContainerDefinition("org.onem2m.home.device." + DeviceWarningDeviceFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
	
	public void finalizeSerialization() {
		getAlarmSpeaker();
		getAlarmSpeakerAnnc();
		getFaultDetection();
		getFaultDetectionAnnc();
	}
	
	@XmlElement(name="alaSr", required=true, type=AlarmSpeakerFlexContainerAnnc.class)
	private AlarmSpeakerFlexContainer alarmSpeaker;
	
	
	public void setAlarmSpeaker(AlarmSpeakerFlexContainer alarmSpeaker) {
		this.alarmSpeaker = alarmSpeaker;
		getFlexContainerOrContainerOrSubscription().add(alarmSpeaker);
	}
	
	public AlarmSpeakerFlexContainer getAlarmSpeaker() {
		this.alarmSpeaker = (AlarmSpeakerFlexContainer) getResourceByName(AlarmSpeakerFlexContainer.SHORT_NAME);
		return alarmSpeaker;
	}
	
	@XmlElement(name="alaSrAnnc", required=true, type=AlarmSpeakerFlexContainerAnnc.class)
	private AlarmSpeakerFlexContainerAnnc alarmSpeakerAnnc;
	
	
	public void setAlarmSpeaker(AlarmSpeakerFlexContainerAnnc alarmSpeakerAnnc) {
		this.alarmSpeakerAnnc = alarmSpeakerAnnc;
		getFlexContainerOrContainerOrSubscription().add(alarmSpeakerAnnc);
	}
	
	public AlarmSpeakerFlexContainerAnnc getAlarmSpeakerAnnc() {
		this.alarmSpeakerAnnc = (AlarmSpeakerFlexContainerAnnc) getResourceByName(AlarmSpeakerFlexContainerAnnc.SHORT_NAME);
		return alarmSpeakerAnnc;
	}
	
	@XmlElement(name="fauDn", required=true, type=FaultDetectionFlexContainerAnnc.class)
	private FaultDetectionFlexContainer faultDetection;
	
	
	public void setFaultDetection(FaultDetectionFlexContainer faultDetection) {
		this.faultDetection = faultDetection;
		getFlexContainerOrContainerOrSubscription().add(faultDetection);
	}
	
	public FaultDetectionFlexContainer getFaultDetection() {
		this.faultDetection = (FaultDetectionFlexContainer) getResourceByName(FaultDetectionFlexContainer.SHORT_NAME);
		return faultDetection;
	}
	
	@XmlElement(name="fauDnAnnc", required=true, type=FaultDetectionFlexContainerAnnc.class)
	private FaultDetectionFlexContainerAnnc faultDetectionAnnc;
	
	
	public void setFaultDetection(FaultDetectionFlexContainerAnnc faultDetectionAnnc) {
		this.faultDetectionAnnc = faultDetectionAnnc;
		getFlexContainerOrContainerOrSubscription().add(faultDetectionAnnc);
	}
	
	public FaultDetectionFlexContainerAnnc getFaultDetectionAnnc() {
		this.faultDetectionAnnc = (FaultDetectionFlexContainerAnnc) getResourceByName(FaultDetectionFlexContainerAnnc.SHORT_NAME);
		return faultDetectionAnnc;
	}
	
}