import java.util.*;

public class CashFlowMinimizerWithHeap {
    // Inner class to represent a person with a name and balance
    static class Person implements Comparable<Person> {
        String name;
        int balance;

        Person(String name, int balance) {
            this.name = name;
            this.balance = balance;
        }

        // Sorting based on balance for the heap (max-heap for creditors, min-heap for debtors)
        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.balance, other.balance);
        }
    }

    // Method to minimize cash flows using heaps
    public static void minimizeCashFlows(Map<String, Integer> debts) {
        // Create heaps for creditors and debtors
        PriorityQueue<Person> creditors = new PriorityQueue<>(Collections.reverseOrder());  // max-heap
        PriorityQueue<Person> debtors = new PriorityQueue<>();  // min-heap

        // Fill the heaps with people based on their balance
        for (Map.Entry<String, Integer> entry : debts.entrySet()) {
            String name = entry.getKey();
            int balance = entry.getValue();
            Person person = new Person(name, balance);

            if (balance > 0) creditors.add(person);  // Add to creditors (max-heap)
            else if (balance < 0) debtors.add(person);  // Add to debtors (min-heap)
        }

        // Settle debts using heaps
        while (!creditors.isEmpty() && !debtors.isEmpty()) {
            Person creditor = creditors.poll();  // Extract the person with the highest credit
            Person debtor = debtors.poll();      // Extract the person with the highest debt (most negative balance)

            // Transaction amount is the minimum of the creditor's balance and the debtor's owed amount
            int transactionAmount = Math.min(creditor.balance, -debtor.balance);
            System.out.println(creditor.name + " pays " + transactionAmount + " to " + debtor.name);

            // Update the balances after the transaction
            creditor.balance -= transactionAmount;
            debtor.balance += transactionAmount;

            // If the creditor still has balance left, add back to the heap
            if (creditor.balance > 0) creditors.add(creditor);
            // If the debtor still owes money, add back to the heap
            if (debtor.balance < 0) debtors.add(debtor);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get the number of people involved
        System.out.print("Enter the number of people involved: ");
        int numPeople = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after the number input

        // Create a map to store people's names and balances
        Map<String, Integer> debts = new HashMap<>();

        // Step 2: Get the names and balances of each person
        for (int i = 0; i < numPeople; i++) {
            System.out.print("Enter the name of person " + (i + 1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Enter the balance for " + name + " (positive for creditor, negative for debtor): ");
            int balance = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character after the balance input

            debts.put(name, balance);
        }

        // Step 3: Minimize the cash flows
        minimizeCashFlows(debts);

        scanner.close();
    }
}
