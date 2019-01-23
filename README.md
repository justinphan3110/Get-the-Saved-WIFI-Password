# Get-the-Saved-WIFI-Password
Get the wifi password on your computer that you already sign in but does not remember the password 

OR Imagine you go to your friend's house and ask for the wifi password, he is a jerk and won't let you know. He only asks you to give your 
computer to him and he will type the password in. After the password is being typed, it is already saved on your computer. You then will be able to 
use this application to find the WIFI password

![image](https://user-images.githubusercontent.com/44376091/51580675-29f0c880-1e7a-11e9-84a7-67d5307fc1d0.png)


![image](https://user-images.githubusercontent.com/44376091/51504178-7a8df600-1d94-11e9-90c1-3ef741a89874.png)

![image](https://user-images.githubusercontent.com/44376091/51504204-96919780-1d94-11e9-86bc-540678c2eb35.png)


![image](https://user-images.githubusercontent.com/44376091/51505567-29820000-1d9c-11e9-8406-fe1127dcc7dc.png)


After Clicking Export a .txt file called wifiPass.txt will pop up:

![image](https://user-images.githubusercontent.com/44376091/51505450-4ec23e80-1d9b-11e9-9e27-9a3bef657d0e.png)



### Prerequisites

To modify my code, you only need basic knowledge of Java and Data Structures(Lists, HashMap, and I/O-BufferedWriter/ BufferedReader),cmd commands and JavaFX ( in this code, the graphics were made mainly from JavaFX Dialog)

### Installing

To start the program, there is 3 ways:
1. Run the GetPassword.jar
2. Run the GetWifiPassword.exe (prefered)
3. download the .java file and run it in a new project in IDE.

You should see a new window pops up

![image](https://user-images.githubusercontent.com/44376091/51504178-7a8df600-1d94-11e9-90c1-3ef741a89874.png)

Choose Scan so that the application will scan for all of the wifi that has been saved on your computer

![image](https://user-images.githubusercontent.com/44376091/51504204-96919780-1d94-11e9-86bc-540678c2eb35.png)

Choose a WIFI that you need to/ or forget the password:

![image](https://user-images.githubusercontent.com/44376091/51504368-7910fd80-1d95-11e9-9843-338de3f172cd.png)


Here I will choose the SCWifi password:

![image](https://user-images.githubusercontent.com/44376091/51505567-29820000-1d9c-11e9-8406-fe1127dcc7dc.png)




Wifi without the password will be informed:

![image](https://user-images.githubusercontent.com/44376091/51504398-a8276f00-1d95-11e9-86ba-f7597fe1dc2c.png)



### Code
![image](https://user-images.githubusercontent.com/44376091/51504462-fa689000-1d95-11e9-90b9-b6c23a641c2b.png)


I use the java application to access the cmd and scan for the used wifi using the command: Netsh wlan show profile

![image](https://user-images.githubusercontent.com/44376091/51504555-7bc02280-1d96-11e9-9467-c4636a59ea08.png)
 
 I after scan to get the whole list of available wifi, I will scan each wifi in the list and get its password. Both will be .put into the hashMap
 
 
![image](https://user-images.githubusercontent.com/44376091/51504629-ccd01680-1d96-11e9-971e-5d13bca34139.png)

You will also be able to export the whole Wifi-Password-HashMap into a .txt file called wifiPassword.txt

![image](https://user-images.githubusercontent.com/44376091/51505341-e2473f80-1d9a-11e9-97ed-f86967488e41.png)


 
## Built With
* [Insert command on cmd through Java](https://www.geeksforgeeks.org/java-program-open-command-prompt-insert-commands/)
* [Hash Map](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)
* [Lambda Expression](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
* [JavaFX](https://docs.oracle.com/javase/8/javafx/get-started-tutorial/jfx-overview.htm)
* [JavaFX Dialog](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Dialog.html)


## Author
  Long Phan 
