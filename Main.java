//Name: Andrew Erickson

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Run the tests
        testListSize();
        testLastPosition();

        // Initialize DoublyLinkedSortedList
        DoublyLinkedSortedList data = new DoublyLinkedSortedList();

        // Read from ace.csv and populate the list
        try {
            Scanner scanner = new Scanner(new File("ace.csv"));
            if (scanner.hasNextLine()) scanner.nextLine(); // Skip header
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                // Create HurricaneRowData object
                HurricaneRowData row = new HurricaneRowData(
                    Integer.parseInt(parts[0]), // Year
                    Integer.parseInt(parts[1]), // Ace Index
                    Integer.parseInt(parts[2]), // # Storms
                    Integer.parseInt(parts[3]), // Cat 1-5
                    Integer.parseInt(parts[4])  // Cat 3-5
                );
                // Insert into sorted list 
                data.insert(row);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Print results using the linked list 
        Node link = data.getFirst();
        HurricaneRowData dat = link.getValue();
        int max_year = dat.getYear();
        
        System.out.println("Year of max ace: " + max_year);
        System.out.println("All data in order of Ace:");
        System.out.println(data);
    }

    public static void testListSize() {
        DoublyLinkedSortedList testList = new DoublyLinkedSortedList();
        testList.insert(new HurricaneRowData(2010, 50, 10, 5, 2));
        testList.insert(new HurricaneRowData(2011, 60, 12, 6, 3));
        testList.insert(new HurricaneRowData(2012, 40, 8, 4, 1));
        
        int count = 0;
        Node current = testList.getFirst();
        while (current != null) {
            count++;
            current = current.getNext();
        }
        
        if (count == 3) System.out.println("Test 1 Passed: List size is 3.");
        else System.out.println("Test 1 Failed.");
    }

    public static void testLastPosition() {
        DoublyLinkedSortedList testList = new DoublyLinkedSortedList();
        HurricaneRowData lowAce = new HurricaneRowData(1983, 17, 4, 3, 1);
        testList.insert(new HurricaneRowData(2005, 248, 28, 15, 7));
        testList.insert(lowAce); 
        
        if (testList.getLast().getValue().equals(lowAce)) 
            System.out.println("Test 2 Passed: Lowest value is at the end.");
        else System.out.println("Test 2 Failed.");
    }
}