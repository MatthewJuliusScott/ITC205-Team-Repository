package bcccp.tickets.season;

public class UsageRecord implements IUsageRecord {
	
	String ticketId;
	long startDateTime;
	long endDateTime;
	
	
	
	public UsageRecord(String ticketId, long startDateTime) {
		this.ticketId = ticketId;
		this.startDateTime = startDateTime;
	}



	@Override
	public void finalise(long endDateTime) {
		this.endDateTime = endDateTime;
		
	}



	@Override
	public long getStartTime() {
	
		return startDateTime;
	}



	@Override
	public long getEndTime() {

		return endDateTime;
	}



	@Override
	public String getSeasonTicketId() { //TODO The name of the object is implicit, and should be avoided in a method name.
		
		return ticketId;
	}
	
	
	
}
