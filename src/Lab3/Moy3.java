package Lab3;

/**
* Name: Hao T. Moy
* Assignment: Lab3
* Instructor: Dr. Julio Cesar Urenda
* T.A.: Isaac Torres
* Last Modification: 7/3/2017
* Purpose: Linked lists and circular linked lists manipulation.
*/

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

class CiNode {
	public int item;
	public CiNode next;

	public CiNode(int i, CiNode n) {
		this.item = i;
		this.next = n;
	}
}

public class Moy3 {


	 /*
	  * This method first checks if the input is compatible, if it is not, it returns -1.
	  * The idea was to return null, but the specified signature did not allow it.
	  * The method creates a circular linked list with a number of nodes corresponding to the number of people.
	  * It then cyclically terminates the links with the undesired values until only one is left.
	  * @param people Specifies the number of nodes on the initial list.
	  * @param elimination Determines the modification cycle of the list.
	  * @return Returns the integer content of the only node whose link was not terminated.
	  */
	public static int survivalNumber(int people, int elimination)  {

		try {
			if (elimination == 1)  {
				return people;
			}

			if (people < 1 || elimination < 1  ) {
				throw new IllegalArgumentException();
			}

			if (people != (int)people || elimination != (int)elimination) {
				throw new InputMismatchException();
			}

			else {
				CiNode head = null;
				for (int i=people; i>=1; i--) {
					head = new CiNode(i, head);
				}

				CiNode temp = head;
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = head;

				int kills = 0;
				int c = 1;
				temp = head;
				while (kills != people-1 ) {
					if ((c+1) % elimination == 0) {
						temp = temp.next.next;
						kills ++;
					}
					c++;
					temp = temp.next;
				}
				return temp.item;
			}
		}
		catch (IllegalArgumentException | InputMismatchException e) {
			return -1;
		}
	}

	public static void main (String[]args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter number of people: ");
		int people = scnr.nextInt();
		System.out.println("Enter elimination number: ");
		int elimination = scnr.nextInt();
		System.out.println("Survival number: " + survivalNumber(people, elimination));


	}
}
