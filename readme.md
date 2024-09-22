Write a program to calculate monthly mortgage payments.

- Create two classes – Mortgage.java and MortgageCalculation.java 

- The Mortgage.java class will be your blueprint where you will create:

1)	A constructor with three parameters – Mortgage amount, mortgage interest rate (yearly rate), and mortgage term (in years). 
2)	A method to calculate monthly mortgage amount:
The formula to use is this:
M = P(monthly rate(1+monthly rate)^n) / ((1+monthly rate)^n – 1)

     Where M = monthly mortgage payment amount (this is what you are calculating to get)  
P = Principal mortgage amount  
n = number of months required to repay the loan   
monthly rate = Mortgage interest / 12   
^n means raise to the power of n    
                          
     This method should return monthly mortgage amount.

3)	Write a method that will return the principal balance after payment of one installment. In that installment payment, 75% of the amount was attributed to interest and 25% was attributed to the principal. 
4)	The mortgage company allows early principal payment. Write a method for extra principal payment that will return the principal balance after this payment. 
5)	Write a setter method for the interest rate. 
6)	Write a getter method for the principal balance. 

7)	On the driver class, create 2 objects of type Mortgage:
A mortgage of $400,000 with fixed yearly mortgage rate of 6% for 30 years 
A mortgage of $350,000 with fixed yearly mortgage rate of 5.75% for 15 years. 
8)	Print monthly mortgage amount for both loans. 
9)	Print principal balance after one installment is paid 
10)	Set new interest rate by lowering both rates by 25 basis points and print monthly mortgage rate for both loans. 
11)	Make extra principal payment for $5000 for both loans and print what will be the monthly mortgage payment after making that extra principal payment. 
12)	Print the current principal balance. 
