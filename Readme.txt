An application that can be used to make and input file become uppercase or lowercase. Also it can replace one spesific word into another.

application will read settings.txt to know the setting (input file name, output file name, etc)

the it will excecute based on the setting and in the exact order of the setting.

Application will write the output based on the output filename specified in setting.txt

How to excecute:
1. Open settings.txt:
	- input file name => name of the input file
	- output file name => name of the output file
	- upper case / lower case word => will make the input file become the specified value. There are 3 value:
		* Upper --> will make uppercase
		* Lower --> will make lowercase
		* Normal --> same as input
	- auto correct => will replace the left word with the right word. split by  '-'. only one auto correct value
	- auto correct case sensitive => replace the left word in case sensitive or not. there are 2 value:
		* Yes --> replace by case sensitive
		* No --> replace by case insensitive
2. Make the input file based on the name in the settings.txt
3. Run Application
4. The application will write a file with the name as specified in settings.txt