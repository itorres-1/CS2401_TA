//package Lab3;
//
///**
// * The Class GuerecaBerumen3.
// * @author Jesus Guereca Berumen
// * @version 1.0
// * @since June 27, 2017
// */
//public class GuerecaBerumen3 {
//
//	static public void main(String[] args) {
//		System.out.print(survivalNumber(100000,790));
//	}
//
//	/**
//	 * survivalNumber finds which person from a group of
//	 * n people will survive if every kth person is killed.
//	 *
//	 * @param n the amount of people
//	 * @param k the next person to be killed
//	 * @return Integer returned is the person number that survives
//	 */
//	public static  Integer survivalNumber(int n, int k){
//		try{
//			intNode LL = new intNode();
//			LL.CLL(n,LL);
//			if(k <= 0 || n <= 0)
//					return null;
//			if(k == 1 || n == 1)
//				return n;
//			else
//			while(true){
//				for(int c = 0;c < k-2;c++){
//					LL = LL.next;
//				}
//				LL.next = LL.next.next;
//				if(LL.done()){break;}
//				LL = LL.next;
//			}
//			return LL.data;
//		} catch(Exception e){
//			return null;
//		}
//	}
//}
///**
// * The calss intNode is an object
// * that holds a value and points to another
// * intNode
// *
// */
//class intNode{
//    public Integer data;
//    public intNode next;
//    public intNode(){
//    	next = null;
//    	data = null;
//    }
//    /**
//     * This is the constructor for an
//     * intNode
//     * @param data holds an integere value
//     * @param next holds an intNode which is next
//     */
//    public intNode(int data,intNode next){
//    	this.data = data;
//    	this.next = next;
//    }
//
//    /**
//     * CLL creates a circle linked list of size size
//     * @param size is the size of the desired link list
//     * @param head is the first element of the link list
//     * @return void
//     */
//    public void CLL(int size,intNode head){
//    	intNode temp = head;
//		if(size > 1){
//			temp.data = 1;
//			for(int n = 2;n <= size;n++){
//				temp.next = new intNode(n,new intNode());
//				temp = temp.next;
//			}
//			temp.next = head;
//		}
//    }
//    /**
//     * Done checks if there is only one element left
//     * in the list
//     * @return boolean returns true if only one element
//     */
//    public boolean done(){
//    	if(data == next.data)
//    		return true;
//    	return false;
//    }
//}
//
//class CLL{
//    intNode reference;
//    int size;
//
//
//}
