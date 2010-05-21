package com.efi.printsmith.integration.jdf;

import org.cip4.jdflib.auto.JDFAutoStatusQuParams.EnumDeviceDetails;
import org.cip4.jdflib.auto.JDFAutoStatusQuParams.EnumJobDetails;
import org.cip4.jdflib.core.JDFDoc;
import org.cip4.jdflib.jmf.JDFCommand;
import org.cip4.jdflib.jmf.JDFEmployeeDef;
import org.cip4.jdflib.jmf.JDFJMF;
import org.cip4.jdflib.jmf.JDFMessage;
import org.cip4.jdflib.jmf.JDFQuery;
import org.cip4.jdflib.jmf.JDFQueueEntryDef;
import org.cip4.jdflib.jmf.JDFQueueFilter;
import org.cip4.jdflib.jmf.JDFResponse;
import org.cip4.jdflib.jmf.JDFStatusQuParams;
import org.cip4.jdflib.jmf.JDFStopPersChParams;
import org.cip4.jdflib.jmf.JDFSubscription;
import org.cip4.jdflib.jmf.JDFMessage.EnumType;
import org.cip4.jdflib.jmf.JDFMessage.EnumFamily;
import org.cip4.jdflib.jmf.JDFQueueSubmissionParams;

public class JMFMessages {
	private static JDFDoc SubmitQueueEntry(String deviceID, String returnJMF, String jdfURL, boolean resubmit, String jobID, boolean fullQuery, long queryIntervalSecs) {
		//TODO: Handle filtering the resulting queue status?
		//String result = null; 
		JDFDoc jmfDoc = null;
		try{
            jmfDoc=new JDFDoc("JMF");
            JDFJMF jaj = jmfDoc.getJMFRoot();
            
            JDFCommand command;
            jaj.setSenderID("P60");
            jaj.setDeviceID(deviceID);
            if (resubmit) {
            	command=(JDFCommand)jaj.appendMessageElement(EnumFamily.Command,JDFMessage.EnumType.ResubmitQueueEntry);
            } else {
            	command=(JDFCommand)jaj.appendMessageElement(EnumFamily.Command,JDFMessage.EnumType.SubmitQueueEntry);
            }
            command.removeAttribute("xsi:type");
            jmfDoc.getRoot().removeAttribute("xsi:type");
            JDFQueueSubmissionParams queueSubmissionParams = command.appendQueueSubmissionParams();
            queueSubmissionParams.setURL(jdfURL);
            queueSubmissionParams.setReturnJMF(returnJMF);
            
            if (fullQuery) {
	            JDFQuery jdfQuery = jaj.appendQuery();
	            jdfQuery.setType(EnumType.Status);
	            JDFStatusQuParams statusQuParams = jdfQuery.appendStatusQuParams();
	            statusQuParams.setEmployeeInfo(true);
	            statusQuParams.setQueueInfo(true);
	            statusQuParams.setJobDetails(EnumJobDetails.Full);
	            statusQuParams.setDeviceDetails(EnumDeviceDetails.Details);
	            statusQuParams.setJobID(jobID);
	            JDFSubscription subscription = jdfQuery.appendSubscription();
	            subscription.setURL(returnJMF);
	            subscription.setRepeatTime(queryIntervalSecs);
	            jdfQuery.removeAttribute("xsi:type");
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return jmfDoc;
		
	}
	
	public static JDFDoc SubmitQueueEntry(String deviceID, String returnJMF, String strURL, String jobID, boolean fullQuery, long queryInterval) {
		return SubmitQueueEntry(deviceID, returnJMF, strURL, false, jobID, fullQuery, queryInterval);
	}
	
	public static JDFDoc ResubmitQueueEntry(String deviceID, String returnJMF, String strURL, String jobID, boolean fullQuery, long queryInterval) {
		return SubmitQueueEntry(deviceID, returnJMF, strURL, true, jobID, fullQuery, queryInterval);
	}

	public static JDFDoc SubmitQueueEntry(String deviceID, String returnJMF, String strURL) {
		return SubmitQueueEntry(deviceID, returnJMF, strURL, false, "", false, 0);
	}
	
	public static JDFDoc ResubmitQueueEntry(String deviceID, String returnJMF, String strURL) {
		return SubmitQueueEntry(deviceID, returnJMF, strURL, true, "", false, 0);
	}

	private static JDFDoc Query(EnumType queryElement) {
		return Query(queryElement, null, null);
	}
	private static JDFDoc Query(EnumType queryElement, String deviceID) {
		return Query(queryElement, deviceID, null);
	}
	
	private static JDFDoc Query(EnumType queryElement, String deviceID, String queueID) {
		JDFDoc result = null;
		try {
			JDFDoc jmfDoc = new JDFDoc("JMF");
			JDFJMF jaj = jmfDoc.getJMFRoot();
			if (deviceID != null) {
				jaj.setAttribute("DeviceID", deviceID);
			}
			JDFMessage jdfMessage = jaj.appendMessageElement(EnumFamily.Query,queryElement);
			if (queueID != null) {
	            JDFQueueEntryDef queueEntryDef = jdfMessage.appendQueueEntryDef();
	            queueEntryDef.setQueueEntryID(queueID);				
			}
			result = jmfDoc;
		} catch (Exception e) {
        	e.printStackTrace();
        }
        return result;
	}

	public static JDFDoc QueryKnownDevices() {
		return Query(JDFMessage.EnumType.KnownDevices);
	}
	
	public static JDFDoc QueryKnownDevices(String deviceId) {
		return Query(JDFMessage.EnumType.KnownDevices, deviceId);
	}

	public static JDFDoc QueryKnownControllers() {
		return Query(JDFMessage.EnumType.KnownJDFServices);
	}
	
	public static JDFDoc QueryKnownMessages() {
		return Query(JDFMessage.EnumType.KnownMessages);
	}
	
	public static JDFDoc QueryKnownMessages(String deviceID) {
		return Query(JDFMessage.EnumType.KnownMessages, deviceID);
	}
	
	public static JDFDoc QueryRepeatMessages(String deviceID) {
		return null;
	}

	public static JDFDoc QueryQueueStatus(String deviceID, String queueID) {		
		return Query(JDFMessage.EnumType.QueueStatus, deviceID, queueID);
	}
	
	public static JDFDoc QuerySubmissionMethods(String deviceID) {
		return Query(JDFMessage.EnumType.SubmissionMethods, deviceID);
	}
	
	public static JDFDoc QueryQueueEntryStatus(String deviceID, String queueID) {
		return Query(JDFMessage.EnumType.QueueEntryStatus, deviceID, queueID);
	}
	
	public static JDFDoc QueryStatusSubscription(String deviceID, String returnJMFAddress, long queryIntervalSecs, String jobId) {
		JDFDoc statusDoc = Query(JDFMessage.EnumType.Status, deviceID);
		JDFQuery jdfQuery = statusDoc.getJMFRoot().getQuery(0);
		
		JDFStatusQuParams statusQuParams = jdfQuery.appendStatusQuParams();
        statusQuParams.setEmployeeInfo(true);
        statusQuParams.setQueueInfo(true);
        statusQuParams.setJobDetails(EnumJobDetails.Full);
        statusQuParams.setDeviceDetails(EnumDeviceDetails.Details);
        statusQuParams.setJobID(jobId);
        JDFSubscription subscription = jdfQuery.appendSubscription();
        subscription.setURL(returnJMFAddress);
        subscription.setRepeatTime(queryIntervalSecs);
        jdfQuery.removeAttribute("xsi:type");
        
        return statusDoc;
	}
	
	public static JDFDoc QueryStatusSubscription(String deviceId, String returnJMFAddress, long queryIntervalSecs) {
		return QueryStatusSubscription(deviceId, returnJMFAddress, queryIntervalSecs, null);
	}
	
	public static JDFDoc QueryStatusSubscription(String deviceId, String returnJMFAddress) {
		return QueryStatusSubscription(deviceId, returnJMFAddress, 60); // TODO make default queryinterval configurable
	}
	
	public static JDFDoc QueryStatusSubscription(String deviceID, String returnJMFAddress, String jobId) {
		JDFDoc statusDoc = Query(JDFMessage.EnumType.Status, deviceID);
		JDFQuery jdfQuery = statusDoc.getJMFRoot().getQuery(0);
		
		JDFStatusQuParams statusQuParams = jdfQuery.appendStatusQuParams();
        statusQuParams.setEmployeeInfo(true);
        statusQuParams.setQueueInfo(true);
        statusQuParams.setJobDetails(EnumJobDetails.Full);
        statusQuParams.setDeviceDetails(EnumDeviceDetails.Details);
        statusQuParams.setJobID(jobId);
        jdfQuery.removeAttribute("xsi:type");
        
        return statusDoc;
	}
		
	public static JDFDoc QueryStatus(String deviceId) {
		return QueryStatusSubscription(deviceId, null);
	}

	public static JDFDoc QueryOccupation(String deviceID, String employeePersonalID) {
		JDFDoc result = null;
		if (employeePersonalID != null) {
			try {
				JDFDoc jmfDoc = new JDFDoc("JMF");
				JDFJMF jaj = jmfDoc.getJMFRoot();
				jaj.setAttribute("DeviceID", deviceID);
				JDFMessage jdfMessage= jaj.appendMessageElement(EnumFamily.Query,JDFMessage.EnumType.Occupation);
				JDFEmployeeDef employeeDef = jdfMessage.appendEmployeeDef();
				employeeDef.setPersonalID(employeePersonalID);
				result = jmfDoc;
			} catch (Exception e) {
	        	e.printStackTrace();
	        }
		}
        return result;
	}

	public static JDFDoc QueueEntryCommand(EnumType commandType, String deviceID, String queueEntryID, boolean filterQueueStatus) {
		JDFDoc result = null;
        try{
            JDFDoc jmfDoc=new JDFDoc("JMF");
            JDFJMF jaj = jmfDoc.getJMFRoot();
            
            // create a command message
            JDFCommand command=(JDFCommand)jaj.appendMessageElement(EnumFamily.Command,commandType);
            jaj.setDeviceID(deviceID);
            JDFQueueEntryDef queueEntryDef = command.appendQueueEntryDef();
            queueEntryDef.setQueueEntryID(queueEntryID);
            
            if (filterQueueStatus) {
            	JDFQueueFilter queueFilter = command.appendQueueFilter();
            	JDFQueueEntryDef filterQueueEntryDef = queueFilter.appendQueueEntryDef();
            	filterQueueEntryDef.setQueueEntryID(queueEntryID);
            }
            result = jmfDoc;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return result;				
	}
	
	public static JDFDoc RemoveQueueEntry(String deviceId, String queueEntryID, boolean filterQueueStatus) {
		return QueueEntryCommand(JDFMessage.EnumType.RemoveQueueEntry, deviceId, queueEntryID, filterQueueStatus);
	}
	
	public static JDFDoc AbortQueueEntry(String deviceId, String queueEntryID, boolean filterQueueStatus) {
		return QueueEntryCommand(JDFMessage.EnumType.AbortQueueEntry, deviceId, queueEntryID, filterQueueStatus);
	}
	
	public static JDFDoc HoldQueueEntry(String deviceId, String queueEntryID, boolean filterQueueStatus) {
		return QueueEntryCommand(JDFMessage.EnumType.HoldQueueEntry, deviceId, queueEntryID, filterQueueStatus);
	}
	
	public static JDFDoc ResumeQueueEntry(String deviceId, String queueEntryID, boolean filterQueueStatus) {
		return QueueEntryCommand(JDFMessage.EnumType.ResumeQueueEntry, deviceId, queueEntryID, filterQueueStatus);
	}
	
	public static JDFDoc StopPersistentChannel(String url, String deviceID, String jobID, String messageType) {
		JDFDoc result = null;
        try{
            JDFDoc jmfDoc=new JDFDoc("JMF");
            JDFJMF jaj = jmfDoc.getJMFRoot();
            
            // create a command message
            JDFCommand command=(JDFCommand)jaj.appendMessageElement(EnumFamily.Command,JDFMessage.EnumType.StopPersistentChannel);
            jaj.setDeviceID(deviceID);
            JDFStopPersChParams stopPersChParams = command.appendStopPersChParams();
            
            stopPersChParams.setURL(url);
            
            stopPersChParams.setDeviceID(deviceID);
            if (jobID != null) {
            	stopPersChParams.setJobID(jobID);
            }
            if (messageType != null) {
            	stopPersChParams.setMessageType(messageType);
            }
            result = jmfDoc;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return result;				
	}
	
	public static String Test() {
		return "Success";
	}
	
	public static JDFDoc ReturnQueueEntryResponse(int returnCode) {
		try {
			JDFDoc jmfDoc = new JDFDoc("JMF");
			JDFJMF jaj = jmfDoc.getJMFRoot();
			
			JDFResponse response = jaj.appendResponse();
			
			response.setType(EnumType.ReturnQueueEntry);
			response.setReturnCode(returnCode);
			return jmfDoc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

