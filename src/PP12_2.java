public class PP12_2 {

    // Innere Klasse für Bag
    static class Bag {
        private Integer object;
        private Bag next;

        // Konstruktor für eine leere Bag
        public Bag() {
            this.object = null;
            this.next = null;
        }

        // Konstruktor für eine Bag mit einem Objekt und einer nächsten Bag
        public Bag(Integer object, Bag next) {
            this.object = object;
            this.next = next;
        }

        // Methode zum Hinzufügen eines Objekts zur Bag
        public void add(Integer value) {
            if (this.object == null) {
                this.object = value;
                this.next = new Bag();
            } else {
                this.next.add(value);
            }
        }

        // Methode zur Überprüfung, ob die Bag leer ist
        public boolean isEmpty() {
            return this.object == null;
        }

        // Methode zur Berechnung der Größe der Bag
        public int size() {
            if (this.isEmpty()) {
                return 0;
            } else {
                return 1 + this.next.size();
            }
        }

        // Rekursive Methode für die String-Darstellung der Bag
        public String toString() {
            if (this.isEmpty()) {
                return "EMPTY";
            } else {
                return "(" + this.object + "," + this.next.toString() + ")";
            }
        }
    }

    public static void main(String[] args) {
        Bag myBag = new Bag();

        myBag.add(1);
        myBag.add(2);
        myBag.add(3);

        System.out.println("Inhalt der Bag: " + myBag.toString());
        System.out.println("Größe der Bag: " + myBag.size());
        System.out.println("Ist die Bag leer? " + myBag.isEmpty());
    }
}
