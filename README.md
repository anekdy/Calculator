#Basic Calculator
*Coding exercise*

This application performs basic arithmetic operations based on the arguments passed.
Format supported is: operand operator operand 
Limitations:
 - does not follow MDAS rule
 - does not support groupings e.g. (operand operator (operand operator operand))


Minimum Requirement: Java 1.7


Instruction for jar creation(using Eclipse IDE) and execution:
1. In Eclipse click on File > Export...
2. Select Java > Runnable JAR file
3. Select/enter the export destination and the JAR filename
4. Select "Package required libraries into generated JAR".
5. To run the executable JAR, enter the command below from the command line replacing <JAR_FILE.jar> 
   with the JAR filename from step 3 and <Expression> with a valid arithmetic expression e.g. 15/3
cmd> java -jar <JAR_FILE.jar> <Expression>
