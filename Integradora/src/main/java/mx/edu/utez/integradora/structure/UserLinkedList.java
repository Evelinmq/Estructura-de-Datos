package mx.edu.utez.integradora.structure;

import mx.edu.utez.integradora.model.User;

public class UserLinkedList {
    
    private UserNode head;

    public UserLinkedList() {
        this.head = null;
    }

    public void add(User user) {
        UserNode newNode = new UserNode(user);

        if (head == null) {
            head = newNode;
            return;
        }

        UserNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;
    }

    public User findById(int id) {
        UserNode current = head;

        while (current != null) {
            if (current.data.getId() == id) {
                return current.data;
            }
            current = current.next;
        }

        return null;
    }

    public User[] toArray() {
        int count = 0;

        UserNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        User[] result = new User[count];

        current = head;
        int i = 0;
        while (current != null) {
            result[i++] = current.data;
            current = current.next;
        }

        return result;
    }
}
