package mx.edu.utez.integradora.structure;

import mx.edu.utez.integradora.model.User;

public class UserNode {
    public User data;
    public UserNode next;
    public UserNode prev;

    public UserNode(User data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
