# Cash Flow Minimizer Project

This project provides a solution for minimizing cash flows between a group of people, helping to simplify the number of transactions required to settle debts. It includes two approaches:
- A **List-based implementation** that uses simple lists to track creditors and debtors.
- A **Heap-based implementation** that uses heaps (priority queues) to efficiently process transactions and minimize the number of required transactions.

## Folder Structure

- **list-based**: Contains the implementation of the cash flow minimizer using lists to manage creditors and debtors. This approach processes the transactions sequentially.
- **heap-based**: Implements the cash flow minimizer using heaps (priority queues) to optimize the selection of the largest creditor and debtor, improving performance when handling a large number of people.

## Features

- Minimizes the number of transactions required to settle debts between people.
- Handles both creditors (those owed money) and debtors (those who owe money).
- Verifies that the total balance of all participants is zero before proceeding with any transactions.
- Provides clear output of transactions (who pays whom and how much).

## Getting Started

### Prerequisites

Make sure you have Java installed on your system. You can verify this by running:

java -version


### How to Run the Project

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/harshalchavan7/Cash-Flow-Minimizer.git
    ```

2. Navigate to the project directory:

    ```bash
    cd cash-flow-minimizer
    ```

3. To run the **list-based approach**, navigate to the `list-based` directory and run:

    ```bash
    javac CashFlowMinimizer.java
    java CashFlowMinimizer
    ```

4. To run the **heap-based approach**, navigate to the `heap-based` directory and run:

    ```bash
    javac CashFlowMinimizerWithHeap.java
    java CashFlowMinimizerWithHeap
    ```
## How It Works

The Cash Flow Minimizer works by taking the input balances of individuals and determining who owes money and who is owed money. It then matches creditors with debtors and suggests the minimal number of transactions to settle all debts.

- In the **list-based approach**, creditors and debtors are managed using simple lists. Each transaction is processed sequentially, and balances are updated after each transaction.
- In the **heap-based approach**, creditors are managed using a **max-heap** (priority queue), and debtors are managed using a **min-heap** (priority queue). This allows for efficient extraction of the largest creditor and largest debtor, reducing the number of transactions needed.

### Example Input

Enter the number of people involved: 4
Enter the name of person 1: John
Enter the balance for John (positive for creditor, negative for debtor): 50
Enter the name of person 2: Alice
Enter the balance for Alice (positive for creditor, negative for debtor): -30
Enter the name of person 3: Bob
Enter the balance for Bob (positive for creditor, negative for debtor): -20
Enter the name of person 4: Charlie
Enter the balance for Charlie (positive for creditor, negative for debtor): 0


### Example Output

John pays 30 to Alice
John pays 20 to Bob


## Contributing
If you'd like to contribute to the project, feel free to fork the repository, make improvements, and submit a pull request. Please follow the project's coding conventions and ensure that your changes are well-documented.

## License
This project is licensed under the MIT License - see the LICENSE file for details.