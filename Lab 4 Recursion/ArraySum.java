package lab4204;

class ArraySum 
{

	public int sumOfArray(Integer A[], int size) {
		if (size <= 0)
			return A[size]; 
		return sumOfArray(A, size - 1) + A[size]; 
	}
}


