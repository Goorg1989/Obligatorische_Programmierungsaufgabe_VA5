public class PP13_3 {

    static class Contact implements Comparable<Contact> {
        private String firstName;
        private String lastName;
        private String age;

        public Contact(String firstName, String lastName, String age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getAge() {
            return age;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName + ", Age: " + age;
        }

        @Override
        public int compareTo(Contact other) {
            int lastNameComparison = this.lastName.compareTo(other.lastName);
            if (lastNameComparison == 0) {
                return this.firstName.compareTo(other.firstName);
            }
            return lastNameComparison;
        }
    }

    static class Node {
        Contact data;
        Node next;

        public Node(Contact data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        private Node head;

        public LinkedList() {
            this.head = null;
        }

        public void add(Contact contact) {
            Node newNode = new Node(contact);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public void selectionSort() {
            if (head == null) return;

            Node current = head;
            while (current != null) {
                Node minNode = current;
                Node runner = current.next;

                while (runner != null) {
                    if (runner.data.compareTo(minNode.data) < 0) {
                        minNode = runner;
                    }
                    runner = runner.next;
                }

                // Swap data instead of nodes
                Contact temp = current.data;
                current.data = minNode.data;
                minNode.data = temp;

                current = current.next;
            }
        }

        public void printList() {
            Node current = head;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList friends = new LinkedList();

        friends.add(new Contact("John", "Smith", "20"));
        friends.add(new Contact("Achmed", "Abdul Malik", "25"));
        friends.add(new Contact("Son", "Goku", "35"));
        friends.add(new Contact("Naruto", "Uzumaki", "29"));

        friends.selectionSort();

        friends.printList();
    }
}


