# Cash Flow Minimizer with Heap (Max-Heap and Min-Heap)

This Java program minimizes cash flows among a group of people using **heaps**. The goal is to settle debts between people in such a way that the total number of transactions is minimized. The program uses a **max-heap** to manage creditors and a **min-heap** to manage debtors.

## Features

- **Heap-based optimization** for efficient debt settlement.
- People with positive balances are creditors, and people with negative balances are debtors.
- It calculates the minimum number of transactions to settle debts by matching creditors with debtors.
- The **priority queues (heaps)** automatically extract the most significant creditor and the most indebted debtor for each transaction.

## How It Works

1. **Input**:
   - The program first takes the number of people involved in the debt-sharing.
   - Each person is assigned a balance: positive for creditors, negative for debtors.
2. **Processing**:
   - Creditors are added to a **max-heap**.
   - Debtors are added to a **min-heap**.
   - The program repeatedly processes the highest creditor and the highest debtor, settling debts by transferring the minimum of their outstanding balances.
3. **Output**:
   - The program outputs each transaction: who pays whom and how much.

## How to Run

1. Clone or download this repository.
2. Compile and run the `CashFlowMinimizerWithHeap.java` file.
3. Provide the number of people and their respective balances when prompted.
4. The program will print the transactions required to settle the debts.

### Example Input:
Enter the number of people involved: 4  
Enter the name of person 1: Alice  
Enter the balance for Alice (positive for creditor, negative for debtor): 500  
Enter the name of person 2: Bob  
Enter the balance for Bob (positive for creditor, negative for debtor): -200  
Enter the name of person 3: Charlie  
Enter the balance for Charlie (positive for creditor, negative for debtor): -300  
Enter the name of person 4: Dave  
Enter the balance for Dave (positive for creditor, negative for debtor): 0  

### Example Output:
Alice pays 300 to Charlie  
Bob pays 200 to Charlie  

## Requirements

- Java 8 or later
- No external libraries required.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
