import java.util.*;

public class CashFlowMinimizer {

    // Helper class to represent an individual and their balance
    static class Person {
        String name;
        int balance; // Positive means the person is a creditor, negative means debtor

        Person(String name, int balance) {
            this.name = name;
            this.balance = balance;
        }
    }

    // Method to minimize the cash flows
    public static void minimizeCashFlows(Map<String, Integer> debts) {
        // Step 1: Calculate net balance for each person
        List<Person> people = new ArrayList<>();
        int totalBalance = 0;

        // Calculate the total balance for each person
        for (Map.Entry<String, Integer> entry : debts.entrySet()) {
            String name = entry.getKey();
            int balance = entry.getValue();
            people.add(new Person(name, balance));
            totalBalance += balance;
        }

        // Print the total balance for debugging
        System.out.println("Total balance: " + totalBalance);

        // If total balance is not 0, it's impossible to settle the debts
        if (totalBalance != 0) {
            System.out.println("Error: Total balance is not zero, can't settle debts.");
            return;
        }

        // Step 2: Separate creditors and debtors
        List<Person> creditors = new ArrayList<>();
        List<Person> debtors = new ArrayList<>();

        for (Person person : people) {
            if (person.balance > 0) {
                creditors.add(person);
            } else if (person.balance < 0) {
                debtors.add(person);
            }
        }

        // Step 3: Settle debts by matching creditors and debtors
        settleDebts(creditors, debtors);
    }

    // Helper method to settle debts between creditors and debtors
    private static void settleDebts(List<Person> creditors, List<Person> debtors) {
        int creditorIndex = 0;
        int debtorIndex = 0;

        while (creditorIndex < creditors.size() && debtorIndex < debtors.size()) {
            Person creditor = creditors.get(creditorIndex);
            Person debtor = debtors.get(debtorIndex);

            // The amount to transfer is the minimum of creditor's balance and debtor's owed amount
            int transactionAmount = Math.min(creditor.balance, -debtor.balance);

            // Print the transaction
            System.out.println(creditor.name + " pays " + transactionAmount + " to " + debtor.name);

            // Update the balances after transaction
            creditor.balance -= transactionAmount;
            debtor.balance += transactionAmount;

            // Move to the next creditor or debtor if their balance is settled
            if (creditor.balance == 0) {
                creditorIndex++;
            }
            if (debtor.balance == 0) {
                debtorIndex++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get the number of people involved
        System.out.print("Enter the number of people involved: ");
        int numPeople = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after the number input

        Map<String, Integer> debts = new HashMap<>();

        // Step 2: Get the names and their respective balances
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
