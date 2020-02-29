/**
 * 
 * holds containers
 * 
 * @author tz_as
 *
 */
public class Container implements ContainerInterface {
	/**
	 * stack of containers
	 */
	MyStack<DonationPackage> Containers;

	/**
	 * paramaterized constructor to declare array size
	 * 
	 * @param i size
	 */
	public Container(int i) {
		Containers = new MyStack<DonationPackage>(i);
	}

	/**
	 * non-paramaterized constructor to declare array size
	 */
	public Container() {
		Containers = new MyStack<DonationPackage>(5);
	}

	/**
	 * load container
	 * 
	 * @return push
	 */
	@Override
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException {
		if (Containers.isFull())
			throw new ContainerException("Containers Stack is full");
		return Containers.push(dPackage);
	}

	/**
	 * remove package
	 * 
	 * @return pop
	 */
	@Override
	public DonationPackage removePackageFromContainer() throws ContainerException {
		if (Containers.isEmpty())
			throw new ContainerException("Containers Stack is empty");
		return Containers.pop();
	}

	/**
	 * check if empty
	 * 
	 * @return empty or not
	 */
	public boolean containerLineEmpty() {
		return Containers.isEmpty();
	}

	/**
	 * array of containers
	 * 
	 * @return array of containers
	 */
	@Override
	public DonationPackage[] toArrayPackage() {
		int size = 0;
		Object[] temp = Containers.toArray();
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null)
				size++;
		}
		DonationPackage[] Containers = new DonationPackage[size];
		for (int i = 0; i < Containers.length; i++) {
			Containers[i] = (DonationPackage) temp[i];
		}
		return Containers;
	}

}
