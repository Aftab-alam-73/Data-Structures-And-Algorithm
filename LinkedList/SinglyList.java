import java.util.Scanner;

public class SinglyList {
static Scanner sc=new Scanner(System.in);
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static Node head;

    static void Create() {
        System.out.println("Enter The Size Of The List");
        int size=sc.nextInt();
        Node tail=null;
        for(int i=1;i<=size;i++)
        {
            System.out.println("Enter The Data: "+(i+1));
            Node newNode=new Node(sc.nextInt());
            if(head==null)
            {
                head=newNode;
                tail=newNode;
            }else{
                tail.next=newNode;
                tail=newNode;
            }
        }
    }

    static void InsertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    static void InsertLast(int data) {
        if (head == null) {
            InsertFirst(data);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(data);
        temp.next = newNode;
        newNode.next = null;
    }

    static void InsertBefor(int data, int key) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == key) {
                break;
            }
            temp = temp.next;
        }

        if (temp != null) {
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
            return;
        }

        System.out.println("Key is not present in the list!");

    }

    static void InsertAftet(int data, int key) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                break;
            }
            temp = temp.next;
        }
        if (temp != null) {
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
            return;
        }
        System.out.println("Key is not present in the list!");
    }

    static void InsertIndex(int data, int index) {
        if (index < 0) {
            System.out.println("Invalid Index!");
            return;
        }
        if (index == 0) {
            InsertFirst(data);
            return;
        }
        Node temp = head;
        index = index - 1;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("List size is smaller than the given index");

        } else {
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    static void DeleteFirst() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        head = head.next;
    }

    static void DeleteLast() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.next.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = null;
    }

    static void DeleteBefore(int key) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.data == key) {
            System.out.println("There is no Node Before " + key);
            return;
        }
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            prev = temp;
            temp = temp.next;
            if (temp.data == key) {
                break;
            }
        }
        if (temp == null) {
            System.out.println("Key is not present in the List!");
            return;
        }
        prev.next = temp.next;
    }

    static void DeleteAfter(int key) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                break;
            }
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Key is not present in the List!");
            return;
        }
        if (temp.next != null) {
            return;
        }
        temp.next = temp.next.next;
    }

    static void DeleteNode(int data) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.data == data) {
            DeleteFirst();
            return;
        }
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (temp.data == data) {
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Node is not present in the List!");
            return;
        }
        prev.next = temp.next;
    }

    static void DeleteIndex(int index) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (index == 0) {
            DeleteFirst();
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("List is smaller than index!");
            return;
        }
        temp.next = temp.next.next;
    }

    static void Reverse() {
        Node prev = null;
        Node next = head;
        Node curr = head;
        while (next != null) {
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    static void Search(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                break;
            }
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Node is not present!");
        } else {
            System.out.println("Node is present in the List!");
        }
    }

    static void Size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("The size of the List is : " + count);
    }

    static void Display() {
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;

        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            System.out.println("--------------------- CHOOSE THE OPTION------------------\n\n");
            System.out.println("1.Create A List");
            System.out.println("2.Insert A Node At The Begining");
            System.out.println("3.Insert A Node At The Last");
            System.out.println("4.Insert A Node At Given Index");
            System.out.println("5.Insert A Node Before A Node");
            System.out.println("6.Insert A Node After A Node");
            System.out.println("7.Delete The First Node");
            System.out.println("8.Delete The Last Node");
            System.out.println("9.Delete The Node Before A Node");
            System.out.println("10.Delete The Node After A Node");
            System.out.println("11.Delete The Given Node");
            System.out.println("12.Delete The Node Of A Given Index");
            System.out.println("13.Search A Node In The List");
            System.out.println("14.Find The Size Of The List");
            System.out.println("15.Display The Whole List");
            System.out.println("16.Reverse The List");
            System.out.println("17.Exit");
            System.out.println("\n");
            System.out.println("Enter The Option!");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                 Create();
                 break;
                case 2:
                    System.out.println("Enter The Data");
                    int data = sc.nextInt();
                    InsertFirst(data);
                    break;
                case 3:
                    System.out.println("Enter The Data");
                    int data1 = sc.nextInt();
                    InsertLast(data1);
                    break;
                case 4:
                    System.out.println("Enter The Data");
                    int data2 = sc.nextInt();
                    System.out.println("Enter The Index");
                    int index = sc.nextInt();
                    InsertIndex(data2, index);
                    break;
                case 5:
                    System.out.println("Enter The Data");
                    int data3 = sc.nextInt();
                    System.out.println("Enter The Key");
                    int key = sc.nextInt();
                    InsertBefor(data3, key);
                    break;
                case 6:
                    System.out.println("Enter The Data");
                    int data4 = sc.nextInt();
                    System.out.println("Enter The Key");
                    int key1 = sc.nextInt();
                    InsertAftet(data4, key1);
                    break;
                case 7:
                    DeleteFirst();
                    break;
                case 8:
                    DeleteLast();
                    break;
                case 9:
                    System.out.println("Enter the Node");
                    int node = sc.nextInt();
                    DeleteBefore(node);
                    break;
                case 10:
                    System.out.println("Enter the Node");
                    int node1 = sc.nextInt();
                    DeleteAfter(node1);
                    break;
                case 11:
                    System.out.println("Enter The Node");
                    int Node = sc.nextInt();
                    DeleteNode(Node);
                    break;
                case 12:
                    System.out.println("Enter The Index");
                    int ind = sc.nextInt();
                    DeleteIndex(ind);
                    break;
                case 13:
                    System.out.println("Enter The Node");
                    int n = sc.nextInt();
                    Search(n);
                    break;
                case 14:
                    Size();
                    break;
                case 15:
                    Display();
                    break;
                case 16:
                    Reverse();
                    break;
                case 17:
                    flag = false;
                default:
                    System.out.println("Please Enter Valid Option\nThank You");

            }

        }
    }
}