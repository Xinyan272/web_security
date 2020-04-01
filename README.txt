The explanation of this project (SQL injection) :
This is a very simple login interface.
After running the program, you can enter the user name and password. 
After you click Submit, the submission success screen will appear, and tell you the SQL statement currently executed.

(Required environment) Tomcat, IDEA, Java

PROBLEM !!!!!!! :
SQL injection is a code injection technique, used to attack data-driven applications, in which malicious SQL statements are inserted into an entry field for execution (e.g. to dump the database contents to the attacker)
In this project , If I change the password to ‘OR 1 = 1’, it will cause SQL injection, because 1 = 1 is always true regardless of whether the previous username and password are true or false, so this SQL statement is always true.