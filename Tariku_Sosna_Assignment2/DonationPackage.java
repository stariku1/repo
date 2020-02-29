/**
 * donation package class
 * 
 * @author tz_as
 *
 */
public class DonationPackage {
	/**
	 * the description
	 */
	String description;
	/**
	 * the weight
	 */
	double weight;

	/**
	 * constructor to set values
	 * 
	 * @param pDesc   the description from user
	 * @param pWeight the description from weight
	 */
	public DonationPackage(String pDesc, double pWeight) {

		this.description = pDesc;
		this.weight = pWeight;
	}

	/**
	 * description
	 * 
	 * @return description
	 */
	public String getDescription() {

		return description;

	}

	/**
	 * weight info
	 * 
	 * @return weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * info on heavy or not
	 * 
	 * @return heavy or not
	 */
	public boolean isHeavy() {
		return (weight >= 20);

	}

	/**
	 * description
	 * 
	 * @return description
	 */
	public String toString() {
		return description;
	}
}
