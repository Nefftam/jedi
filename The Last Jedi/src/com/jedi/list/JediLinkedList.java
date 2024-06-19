package com.jedi.list;

public class JediLinkedList{

    Node head;

    public void add(int info)
    {
        if (head == null)
            head = new Node(info);
        else
        {
            Node tmp = head;
            while (tmp.next != null)
            {
                tmp = tmp.next;
            }
            tmp.next = new Node(info);
        }
    }

    public Node addRecursive(Node head, int info)
    {
        if(head == null) return new Node(info);
        head.next = addRecursive(head.next,info);
        return head;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Node tmp = head;
        sb.append("[");
        while(tmp != null)
        {
            sb.append(tmp.data);
            if(tmp.next != null)
                sb.append(",");
            tmp = tmp.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public void reverseListRecursive()
    {
        head = reverseListRecursive(head);
    }

    private Node reverseListRecursive(Node head)
    {
        if (head == null) return head;
        if(head.next == null) return head;
        Node head1 = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return head1;
    }

    public int length()
    {
        return length(head);
    }
    private int length(Node head)
    {
        if(head == null) return 0;
        return 1 + length(head.next);
    }
}

class Node
{
    int data;
    Node next;

    Node(int info)
    {
        this.data = info;
    }
}
