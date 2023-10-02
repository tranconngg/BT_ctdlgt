package BTtuan4;

public class Linked_list {
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void printLinked_list(Node head) {
        if (head == null) System.out.println("List is empty!");
        else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value);
                temp = temp.next;
                if (temp != null) {
                    System.out.print("->");
                } else {
                    System.out.println();
                }
            }
        }
    }

    public static Node add_ToheadNode(Node headNode, int val) {
        Node newNode = new Node(val);
        if (headNode != null) {
            newNode.next = headNode;
        }
        return newNode;
    }

    public static Node add_ToTail(Node headNode, int val) {
        Node newNode = new Node(val);
        if (headNode == null) {
            return newNode;
        } else {
            //b1: xác định last node
            Node lastNode = headNode;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            //gán next cho last node = new Node
            lastNode.next = newNode;
            //trả lại một list mới có node cuối đã thay đổi
            return headNode;
        }
    }

    public static Node addToIndex(Node headNode, int index, int val) {
        if (index == 0) {
            return add_ToheadNode(headNode, val);
        } else {
            Node newNode = new Node(val);
            Node curNode = headNode;
            int cnt = 0;
            while (curNode != null) {
                cnt++;
                if (index == cnt) {
                    //add Node
                    newNode.next = curNode.next;
                    curNode.next = newNode;
                    break;
                }
                curNode = curNode.next;
            }
        }
        return headNode;
    }

    public static Node removeAthead(Node headNode) {
        if (headNode != null) {
            return headNode.next;
        }
        return headNode;
    }

    public static Node removeAttail(Node headNode) {
        if (headNode == null) {
            return headNode;
        }
        Node lastNode = headNode;
        Node prevNode = null;

        while (lastNode.next != null) {
            prevNode = lastNode;
            lastNode = lastNode.next;
        }

        if (prevNode == null) // tuc la chi co 1 node thi node đầu cũng là node cuối mà node cuối thì câu lệnh while sẽ ko chạy.
        {
            return null;
        } else {
            prevNode.next = lastNode.next;
        }
        return headNode;
    }

    public static Node removeAtindex(Node headNode, int index) {
        if (headNode == null || index < 0) {
            return null;
        }
        if (index == 0) {
            return headNode.next;
        }
        Node cur = headNode;
        Node prev = null;
        int cnt = 0;
        while ((cur.next != null)) {
            if (cnt == index) {
                prev.next = cur.next; // động tác nhảy cóc :))
            }
            prev = cur; // trước khi cur hiện tại nhảy sang cur tiếp theo thì lưu cur hiện tại vào prev
            cur = cur.next; // thành ra prev laf node truoc cur, còn cur.next là node sau cur;
            cnt++;
        }
        return headNode;
    }

    public static Node reveser(Node headNode) {
        Node cur = headNode;
        Node next = null;
//dk1 kiem tra xem Node dau vao co null hay khong dk2 neu đã trỏ tới node cuối cùng thì vong lặp dừng lại
        while (cur != null && cur.next != null) {
            // a->b->c , cur dang là a
            next = cur.next; // xac dinh next là Node tiep theo của cur tuc la b

            cur.next = next.next; // a vòng xuống nối c, next.next là node tiep theo của next tức là c

            next.next = headNode; // b vòng lên nối lại vào a (a đang là cur và cung là head)

            headNode = next; // cập nhật lại head (cur) và tiếp tục vòng lặp tiếp theo

        }
        return headNode;
    }

    public static Node reveser_dequy(Node headNode) {
        if (headNode == null) {
            return null;
        }
        Node newNext = headNode.next;
        if (newNext == null) {
            return headNode;
        }

        Node newHead = reveser_dequy(newNext);
        newNext.next = headNode;
        newHead.next = null;

        return newHead;
    }

    static boolean compareLists(Node head1, Node head2) {

        while (head1 != null && head2 != null) {

            if (head1.value != head2.value) {
                return false;
            }

            head1 = head1.next;

            head2 = head2.next;

        }
        if (head1 == null && head2 == null) {
            return true;
        }
        return false;


    }

    public static Node mergeLists(Node head1, Node head2) {
        Node head3 = new Node(0);
        Node cur = head3;

        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }

        if (head1 != null) {
            cur.next = head1;
        } else {
            cur.next = head2;
        }

        return head3.next;
    }

    public static int getNode(Node head, int positionFromTail) {
        if (head == null) {
            return 0;
        }
        // Write your code here
        Node cur1 = head;
        int length = 0;
        while (cur1 != null) {
            length++;
            cur1 = cur1.next;
        }
        int cnt = 0;
        Node cur2 = head;
        while (cur2 != null) {
            cnt++;
            if (cnt == length - positionFromTail) {
                return cur2.value;
            }
            cur2 = cur2.next;
        }
        return 1;
    }
}

