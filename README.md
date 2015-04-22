# LogicCalc
A boolean algebra logic calculator that reduces a logic statement down to true or false.

### Assumptions
I made a couple assumptions regarding the syntax of the logic statement:
* All statements are a single line and must be terminated with a '.' character
* Any amount of whitespace can separate the different tokens within the statement

### Examples
	java -jar LogicCalc.jar "(TRUE OR FALSE)."
	java -jar LogicCalc.jar "FALSE OR TRUE AND FALSE OR NOT TRUE."
