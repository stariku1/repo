/**
 * volunteer line class
 * 
 * @author tz_as
 *
 */
public class VolunteerLine implements VolunteerLineInterface {
	/**
	 * queue of volunteers
	 */
	MyQueue<Volunteer> Volunteers;

	/**
	 * constructor with size
	 */
	public VolunteerLine() {
		Volunteers = new MyQueue<Volunteer>(5);
	}

	/**
	 * constructor with user set size
	 * 
	 * @param i size
	 */
	public VolunteerLine(int i) {
		Volunteers = new MyQueue<Volunteer>(i);
	}

	/**
	 * add new volunteer
	 * 
	 * @return enqueued volunteer
	 */
	@Override
	public boolean addNewVolunteer(Volunteer v) throws VolunteerException {
		if (Volunteers.isFull())
			throw new VolunteerException("Volunteer Queue is full");
		return Volunteers.enqueue(v);
	}

	/**
	 * turn volunteer
	 * 
	 * @return dequeued volunteer
	 */
	@Override
	public Volunteer volunteerTurn() throws VolunteerException {
		if (Volunteers.isEmpty())
			throw new VolunteerException("Volunteer Queue is empty");
		return Volunteers.dequeue();
	}

	/**
	 * check if volunteer line is empty
	 * 
	 * @return empty or not
	 */
	@Override
	public boolean volunteerLineEmpty() {
		return Volunteers.isEmpty();
	}

	/**
	 * array of volunteers
	 * 
	 * @return array of volunteers
	 */
	@Override
	public Volunteer[] toArrayVolunteer() {
		int size = 0;
		Object[] temp = Volunteers.toArray();
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null)
				size++;
		}
		Volunteer[] Volunteers = new Volunteer[size];
		for (int i = 0; i < Volunteers.length; i++) {
			Volunteers[i] = (Volunteer) temp[i];
		}
		return Volunteers;
	}

}
