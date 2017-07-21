package Lab4;

public class Tinevra4 {
    static class iNode {
        String value;
        int counter;
        iNode next;

        iNode(String value){
            this.value=value;
            counter=1;
        }
        iNode(String value, iNode next){
            this.value=value;
            this.next=next;
            counter=1;
        }
    }

    public static void main(String[] args){
        iNode list= null;
        String x= "123";
        for (int i = 0; i <x.length() ; i++) {
            list= new iNode(x.substring(i,i+1), list);
        }
        //prints the characters separated
        printAllPartitions(list);
        //makes the partitions
        list = partLL(list);
        //prints the partitions
        printAllPartitions(list);
    }
    /**
     * brakes the string into partitions.
     * @param characters the head of a linked list.
     * @return the head of a linked list with all the partitions inside the nodes.
     */
    public static iNode partLL(iNode characters){
        iNode temp = new iNode("");
        if(characters==null){
            return temp;
        }
        String current = characters.value;
        //stores the information of characters in temp.
        temp = partLL(characters.next);
        String sum = "";

        iNode head = temp;
        iNode tail = new iNode(current+temp.value);
        while(temp.next!=null){
            sum = current+ temp.next.value;
            tail = new iNode(sum, tail);
            temp =temp.next;
        }
        temp.next = tail;
        return head;
    }

    /**
     * this method prints out a linked list nodes values
     * @param s the linked list head
     */
    public static void printAllPartitions(iNode s){
        System.out.print("{");
        for(iNode i= s; i!=null; i=i.next){
            System.out.print("{"+i.value+"}");
        }
        System.out.println("}");
    }
}





