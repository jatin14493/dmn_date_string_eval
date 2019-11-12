DMN Evaluation


1. In the main method play around with the variables to see which condition gets evaluated.

HIT Policy : First (which takes in account the first matching row in case multiple rows of inputs get matched.)

INPUTS

There are 3 inputs taken in the example :
  1. Name :  String type
  2. Date : Input of type date (Note format of date should be like : yyyy-MM-ddT12:00:00, T is mandatory else the execution     fails.)
  3. Email : String type (To play around with things like contains, startswith etc.)

OUTPUT

1. Result variable which will hold the execution result. In this case, it will return a String.


Please Note :

FEEL doesn't support feature like contains, startsWith etc so we need to set the inputEntry expression language explicitly to JUEL for that particular cell (all others by default will be set to FEEL only)in order for DMN Engine to evaluate it correctly. For other inputs and operations, FEEL Expressions work correctly without any extra effort.


Steps to Play Around :

1. In main method, there's a variable MAP wherein anyone can provide custom inputs and verify if the rules are working as desired. Also, DMN conditions can be updated to set new rules and condition. Post changes re-run the application to check the output.

