/**
 * donation manager class
 * 
 * @author tz_as
 *
 */
public class DonationManager implements DonationManagerInterface {

	/**
	 * containers
	 */
	Container Containers = new Container();
	/**
	 * volunteers
	 */
	VolunteerLine Volunteers = new VolunteerLine();
	/**
	 * recipients
	 */
	RecipientLine Recipients = new RecipientLine();
	/**
	 * amount sold
	 */
	int amount = 0;
	/**
	 * container
	 */
	DonationPackage container;
	/**
	 * volunteer
	 */
	Volunteer volunteer;
	/**
	 * recipient
	 */
	Recipient recipient;

	/**
	 * load container
	 * 
	 * @return loaded container
	 */
	@Override
	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException {
		return Containers.loadContainer(dPackage);
	}

	/**
	 * add new volunteer
	 * 
	 * @return added volunteer
	 */
	@Override
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		return Volunteers.addNewVolunteer(v);
	}

	/**
	 * add new recipient
	 * 
	 * @return added recipient
	 */
	@Override
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		return Recipients.addNewRecipient(r);
	}

	/**
	 * donate package
	 * 
	 * @return amount sold
	 */
	@Override
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException {
		if (Volunteers.volunteerLineEmpty())
			throw new VolunteerException("Volunteer Queue is Empty");
		if (Containers.containerLineEmpty())
			throw new ContainerException("Container Stack is Empty");
		if (Recipients.recipientLineEmpty())
			throw new RecipientException("Recipient Stack is Empty");
		container = Containers.removePackageFromContainer();
		volunteer = Volunteers.volunteerTurn();
		Volunteers.addNewVolunteer(volunteer);
		recipient = Recipients.recipientTurn();
		return amount++;
	}

	/**
	 * donation package array
	 * 
	 * @return array package
	 */
	@Override
	public DonationPackage[] managerArrayPackage() {
		return Containers.toArrayPackage();
	}

	/**
	 * volunteer array
	 * 
	 * @return array of volunteers
	 */
	@Override
	public Volunteer[] managerArrayVolunteer() {
		return Volunteers.toArrayVolunteer();
	}

	/**
	 * recipient array
	 * 
	 * @return array of recipients
	 */
	@Override
	public Recipient[] managerArrayRecipient() {
		return Recipients.toArrayRecipient();
	}

	/**
	 * description of donation manager
	 * 
	 * @return this description
	 */
	public String toString() {
		return volunteer + " delivered " + container + " to " + recipient + ".";
	}

}
