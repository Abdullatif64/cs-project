/**
 * Created by abdll on 12/21/2017.
 */
public class TweetoSLL {
    public Tweeto head;
    public int size;

    public TweetoSLL() {
        head = null;
        size = 0;
    }

    public Tweeto getHead() {
        return head;
    }

    public void setHead(Tweeto head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public Tweeto Search(String U, String K) {
        Tweeto temp = head;
        while (temp != null) {
            if (temp.getTweet().toLowerCase().contains(K.toLowerCase()) && temp.getID().toLowerCase().startsWith(U.toLowerCase()))
                break;
            temp = temp.getNext();
        }
        return temp;
    }

//Add a node to the list

    public void insert(Tweeto N) {
        if (head == null) {
            head = N;
            N.setNext(null);
            size++;
            return;
        }

        //add the new node N to the head of the list
        N.setNext(head);
        head = N;
        size++;
        return;
    }
/*
//remove a node from the list; we first search the node containing the key
//3 cases would apply. begining, middle or the end.
    public boolean remove(String key) {
        //we return true if node containing key is sucessfully removed; false otherwise
        boolean RETURN = false;
        //check if list is empty
        if (head == null) {
            return RETURN;
        }
        //check if list has only one node
        if (size == 1) {
            //check if this node is the candidate
            if (head.getTweet() == key) {
                head = null;
                size--;
                RETURN = true;
            }
            return RETURN;
        }
        //now we have atleast 2 nodes in the list
        //look for the candidate
        //remember the previous node;
        Tweeto temp = head, P = null, N;
        while (temp != null) {
            if (temp.getTweet() == key) // found it!
            {
                break;
            }
            P = temp;
            temp = temp.getNext();
        }
        if (temp == null)// didn't find it
        {
            return false;
        }
        //case 1. if head is the candidate node
        if (temp == head) {
            head = temp.getNext();
        } //case 2. if candidate is in the middle or the last!
        else {
            P.setNext(temp.getNext());
        }
        size--;
        return true;
    }
//update method takes two params old and key
    public boolean update(String old, String key) {
        if (head == null) {
            return false;
        }
        Tweeto temp = head;
        while (temp != null) {
            if (temp.getTweet() == old) {
                temp.setTweet(key);
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }*/

    //toString method
    @Override
    public String toString() {
        String out = "";
        Tweeto temp = head;
        while (temp != null) {
            out = out + temp;
            temp = temp.getNext();
        }
        if (head != null)
            out += "\n";
        return out;
    }
}
