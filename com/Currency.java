package concun.gl.com;



import java.util.ArrayList;
import java.util.Scanner;

public class Currency{

	static class PaymentApproach {
		int denomination;
		int numNotes;

		public PaymentApproach(int denomination, int numNotes) {
			this.denomination = denomination;
			this.numNotes = numNotes;
		}

		public String toString() {
			return String.valueOf(numNotes);

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of currency denominations");
		int numberOfNotes = sc.nextInt();

		int currency[] = new int[numberOfNotes];

		System.out.println("Enter the currency denomination value");
		for (int i = 0; i < currency.length; i++) {
			currency[i] = sc.nextInt();

		}
		System.out.println("Enter the amount you want to pay");
		int amount = sc.nextInt();

		MergeSort ms = new MergeSort();
		ms.sort(currency, 0, currency.length - 1);

		ArrayList<PaymentApproach> paymentApproach = new ArrayList<>();
		for (int i = currency.length - 1; i >= 0; i--) {
			if (amount == 0) {
				break;
			}
			int numNotes = amount / currency[i];
			if (numNotes > 0) {
				paymentApproach.add(new PaymentApproach(currency[i], numNotes));
				amount %= currency[i];
			}
		}
		System.out.println("Your payment approach in order to give min number pf notes willb be");
		for (PaymentApproach approach : paymentApproach) {

			System.out.println(approach.denomination + ":" + approach);

		}
		sc.close();

	}

}