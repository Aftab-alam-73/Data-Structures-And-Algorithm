import java.util.Scanner;

public class DoublyList {
  static Scanner sc = new Scanner(System.in);

  static class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }
  }

  static Node head;

  static void Create() {
    System.out.println("Enter The size of List!");
    int size = sc.nextInt();
    Node tail = null;
    for (int i = 0; i < size; i++) {
      System.out.println("Enter The data " + (i + 1));
      Node newNode = new Node(sc.nextInt());
      if (head == null) {
        head = newNode;
        tail = newNode;
      } else {
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
      }

    }

  }

  static void InsertFirst() {
    System.out.println("Enter The Data");
    Node newNode = new Node(sc.nextInt());
    if (head == null) {
      head = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
  }

  static void InsertLast() {
    System.out.println("Enter The Data");
    Node newNode = new Node(sc.nextInt());
    if (head == null) {
      InsertFirst();
      return;
    }
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newNode;
    newNode.prev = temp;
  }

  static void InsertBefore() {
    if (head == null) {
      System.out.println("List is empty!");
      return;
    }
    System.out.println("Enter The Key");
    int key = sc.nextInt();
    if (head.data == key) {
      InsertFirst();
      return;
    }
    Node temp = head;
    while (temp != null && temp.data != key) {
      temp = temp.next;
    }
    if (temp == null) {
      System.out.println("Key is not present in the List");
      return;
    }
    System.out.println("Enter The Data");
    Node newNode = new Node(sc.nextInt());
    temp.prev.next = newNode;
    newNode.prev = temp.prev;
    newNode.next = temp;
    temp.prev = newNode;
  }

  static void InsertAfter() {
    if (head == null) {
      System.out.println("List is empty!");
      return;
    }
    System.out.println("Enter The Key");
    int key = sc.nextInt();
    Node temp = head;
    while (temp != null && temp.data != key) {
      temp = temp.next;
    }
    if (temp == null) {
      System.out.println("Key is not present in the List");
      return;
    }
    System.out.println("Enter The Data");
    Node newNode = new Node(sc.nextInt());
    if (temp.next == null) {
      temp.next = newNode;
      newNode.prev = temp;
      return;
    }
    newNode.next = temp.next;
    temp.next.prev = newNode;
    temp.next = newNode;
    newNode.prev = temp;
  }

  static void InsertIndex() {
    if (head == null) {
      System.out.println("List is empty!");
      return;
    }
    System.out.println("Enter The Index");
    int Index = sc.nextInt();
    if (Index < 0) {
      System.out.println("Invalid Index!");
      return;
    }
    if (Index == 0) {
      InsertFirst();
      return;
    }
    Node temp = head;
    for (int i = 0; i < Index && temp != null; i++) {
      temp = temp.next;
    }
    if (temp == null) {
      System.out.println("Index is bigger than the size of List");
      return;
    }
    System.out.println("Enter The Data");
    Node newNode = new Node(sc.nextInt());
    temp.prev.next = newNode;
    newNode.prev = temp.prev;
    newNode.next = temp;
    temp.prev = newNode;
  }

  static void DeleteFirst() {
    if (head == null) {
      System.out.println("List is empty!");
      return;
    }
    head = head.next;
    head.next.prev = null;
  }

  static void DeleteLast() {
    if (head == null) {
      System.out.println("List is empty!");
      return;
    }
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.prev.next = null;
    temp.prev = null;
  }

  static void DeleteBefor() {
    if (head == null) {
      System.out.println("List is empty!");
      return;
    }
    System.out.println("Enter The Key");
    int key = sc.nextInt();
    if (head.data == key) {
      System.out.println("There Is No Node Before The Key " + key);
      return;
    }
    Node temp = head;
    while (temp != null && temp.data != key) {
      temp = temp.next;
    }
    if (temp == null) {
      System.out.println("Key Is Not Present In The List");
      return;
    }
    if (temp.prev.prev == null) {
      DeleteFirst();
      return;
    }
    temp.prev.prev.next = temp;
    temp.prev = temp.prev.prev;
  }

  static void DeleteAfter() {
    if (head == null) {
      System.out.println("List Is Empty!");
      return;
    }
    System.out.println("Enter The Key");
    int key = sc.nextInt();
    Node temp = head;
    while (temp != null && temp.data != key) {
      temp = temp.next;
    }
    if (temp == null) {
      System.out.println("Key Is Not Present In The List");
      return;
    } else if (temp.next == null) {
      System.out.println("There Is No Node After " + key);
    } else {
      if (temp.next.next != null) {
        temp.next = temp.next.next;
        temp.next.prev = null;
        temp.next.next.prev = temp;
      } else {
        temp.next = temp.next.next;
      }
    }
  }

  static void DeleteNode() {
    if (head == null) {
      System.out.println("List Is Empty!");
      return;
    }
    System.out.println("Enter The Node");
    int key = sc.nextInt();
    if (head.data == key) {
      DeleteFirst();
      return;
    }
    Node temp = head;
    while (temp != null && temp.data != key) {
      temp = temp.next;
    }
    if (temp == null) {
      System.out.println("Node Is Not Present In The List");

    } else {
      if (temp.next != null) {
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
      } else {
        temp.prev.next = null;
        temp.prev = null;
      }
    }
  }

  static void Display() {
    if (head == null) {
      System.out.println("List is empty!");
      return;
    }
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.println();
  }
 static void Size()
 {
    Node temp=head;
    int count=0;
    while(temp!=null)
    {
       count++;
       temp=temp.next;
    }
    System.out.println("The Size Of The List Is: "+count);
 }
 static void Search() {
  System.out.println("Enter The Data");
  int data=sc.nextInt();
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
  public static void main(String[] args) {
    Create();
    Display();
    // InsertFirst();
    // InsertLast();
    // InsertBefore();
    // InsertAfter();
    // InsertIndex();
    // DeleteFirst();
    // DeleteLast();
    // DeleteBefor();
    // DeleteAfter();
    // DeleteNode();
    Size();
    Search();
    Display();

  }
}
