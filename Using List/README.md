# Cash Flow Minimizer (List-based Solution)

This Java program minimizes cash flows among a group of people by using **lists** and a **two-pointer approach**. The goal is to reduce the number of transactions needed to settle debts by matching creditors with debtors.

## Features

- **List-based approach** to manage creditors and debtors.
- The program iteratively matches creditors with debtors to minimize cash flow transactions.
- Creditors (people with positive balances) and debtors (people with negative balances) are processed sequentially to determine the minimum number of transactions needed.

## How It Works

1. **Input**:
   - The program first takes the number of people involved in the debt-sharing.
   - Each person is assigned a balance: positive for creditors, negative for debtors.
2. **Processing**:
   - People are separated into two lists: one for creditors and one for debtors.
   - The program matches the first creditor with the first debtor, and a transaction is made based on the minimum of their balances.
   - This continues until all debts are settled.
3. **Output**:
   - The program outputs each transaction: who pays whom and how much.

## How to Run

1. Clone or download this repository.
2. Compile and run the `CashFlowMinimizer.java` file.
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
