# SeleniumParallelTest

Download selenium standalone server this page http://www.seleniumhq.org/download/
<br/>
Starting a Hub
To start a hub with default parameters, run the following command from a command-line shell. This will work on all the supported platforms, Windows Linux, or Mac OSX.
<br/>
<br/>
java -jar selenium-server-standalone-2.44.0.jar -role hub
This starts a hub using default parameter values. We’ll explain these parameters in folowing subsections. Note that you will likely have to change the version number in the jar filename depending on which version of the selenium-server you’re using.
<br/>
Starting a Node
<br/>
To start a node using default parameters, run the following command from a command-line.
<br/>
java -jar selenium-server-standalone-2.44.0.jar -role node  -hub http://localhost:4444/grid/register

<br/>
<br/>

This assumes the hub has been started above using default parameters. The default port the hub uses to listen for new requests is port 4444. This is why port 4444 was used in the URL for locating the hub. Also the use of ‘localhost’ assumes your node is running on the same machine as your hub. For getting started this is probably easiest. If running the hub and node on separate machines, simply replace ‘localhost’ with the hostname of the remote machine running the hub.
<br/>
WARNING: Be sure to turn off the firewalls on the machine running your hub and nodes. Otherwise you may get connection errors.


Open the ide(I am using intellij idea
Run the following code
<br/>
mvn clean install -Denvironment=test -DtestXmlFile=test.xml

<br/>
And watch the test.



