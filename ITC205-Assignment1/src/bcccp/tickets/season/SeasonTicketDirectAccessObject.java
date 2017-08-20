package bcccp.tickets.season;

import java.util.HashMap;

public class SeasonTicketDirectAccessObject implements ISeasonTicketDirectAccessObject { 

	private IUsageRecordFactory				factory_; 

	// need to keep track of all tickets
	private HashMap<String, ISeasonTicket>	tickets_;

	public SeasonTicketDirectAccessObject(IUsageRecordFactory factory) {
		this.factory_ = factory;
		tickets_ = new HashMap<String, ISeasonTicket>();
	}

	@Override
	public void deregisterTicket(ISeasonTicket ticket) { //TODO Generic variables should have the same name as their type.

		tickets_.remove(ticket.getId());
	}

	@Override
	public ISeasonTicket findTicketById(String ticketId) {

		return tickets_.get(ticketId);
	}

	@Override
	public int getNumberOfTickets() {

		return tickets_.size();
	}

	@Override
	public void recordTicketEntry(String ticketId) {

		ISeasonTicket newTicket = tickets_.get(ticketId);

		long time = System.currentTimeMillis();
		IUsageRecord usage = factory_.newUsageRecord (ticketId, time);

		newTicket.recordUsage(usage);
	}

	@Override
	public void recordTicketExit(String ticketId) {

		ISeasonTicket oldTicket = tickets_.get(ticketId);

		long time = System.currentTimeMillis();
		oldTicket.getCurrentUsageRecord().finalise(time);

	}

	@Override
	public void registerTicket(ISeasonTicket ticket) {
		tickets_.put(ticket.getId(), ticket);
	}

}
