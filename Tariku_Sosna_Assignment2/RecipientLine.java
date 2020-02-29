/**
 * recipient line class
 * 
 * @author tz_as
 *
 */
public class RecipientLine implements RecipientLineInterface {
	/**
	 * queue of recipients
	 */
	MyQueue<Recipient> Recipients;

	/**
	 * constructor with size 5 in queue
	 */
	public RecipientLine() {
		Recipients = new MyQueue<Recipient>(5);
	}

	/**
	 * constructor with user set size
	 * 
	 * @param i size
	 */
	public RecipientLine(int i) {
		Recipients = new MyQueue<Recipient>(5);
	}

	/**
	 * add recipient
	 * 
	 * @return added recipient
	 */
	@Override
	public boolean addNewRecipient(Recipient rc) throws RecipientException {
		if (Recipients.isFull())
			throw new RecipientException("Recipient Queue is full");
		return Recipients.enqueue(rc);
	}

	/**
	 * turn recipient
	 * 
	 * @return turned recipient
	 */
	@Override
	public Recipient recipientTurn() throws RecipientException {
		if (Recipients.isEmpty())
			throw new RecipientException("Recipient Queue is empty");
		return Recipients.dequeue();
	}

	/**
	 * empty or not
	 * 
	 * @return empty or not
	 */
	@Override
	public boolean recipientLineEmpty() {
		return Recipients.isEmpty();
	}

	/**
	 * to array
	 * 
	 * @return recipients
	 */
	@Override
	public Recipient[] toArrayRecipient() {
		int size = 0;
		Object[] temp = Recipients.toArray();
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null)
				size++;
		}
		Recipient[] Recipients = new Recipient[size];
		for (int i = 0; i < Recipients.length; i++) {
				Recipients[i] = (Recipient) temp[i];
		}
		return Recipients;
	}

}
