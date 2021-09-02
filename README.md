# iDempiere ScaleConnector Plugin

This project is an integration between iDempiere and digital scales with the aim of get the sensor measure from
iDempiere. ScaleConnector can be configured to sync with any device or sensor (temperature, humidity, pressure,
weighing, accountant, etc.) that communicate through the RS-232 serial port.

Official documentation [here](https://wiki.idempiere.org/en/Plugin:_Scale_Connector)

## Dependencies

- Java 11
- iDempiere 8

## Components

### ScaleConnector GUI

Running the application as developer:

```shell
./gradlew run --args="gui"
```

Installing the application:

```shell
./gradlew build
sudo unzip -d /opt/ ./scaleconnector-gui/build/distributions/scaleconnector-gui.zip
sudo ln -s /opt/scaleconnector-gui/bin/scaleconnector-gui /usr/local/bin/scaleconnector-gui
```

Printing help:

```shell
scaleconnector-gui -h
```

Running on GUI mode:

```shell
scaleconnector-gui gui
```

Running on console TCP server mode:

```shell
scaleconnector-gui server -p 5000
```

Creating a linux service:

```shell
sudo mkdir -p /var/lib/scaleconnector-gui
sudo cp ./scaleconnector-gui/scaleconnector.service /etc/systemd/system/scaleconnector.service
sudo systemctl daemon-reload
sudo systemctl enable scaleconnector
sudo systemctl start scaleconnector
```

### ScaleConnector REST

Installing httpie (REST client):

```shell
sudo apt install httpie
```

Running the application as developer:

```shell
./gradlew bootRun --args="--server.port=8080"
http :8080/actuator/health
```

Executing a test request:

```shell
http :8080/read type=TEST date=$(date +"%Y-%m-%dT%T")
```

Executing a read request:

```shell
http :8080/read < ./scaleconnector-rest/read-request.json
```

Installing the application:

```shell
./gradlew bootJar
sudo mkdir -p /opt/scaleconnector-rest
sudo cp ./scaleconnector-rest/build/libs/scaleconnector-rest.jar /opt/scaleconnector-rest/
java -jar /opt/scaleconnector-rest/scaleconnector-rest.jar --server.port=8080
```

Creating a linux service:

```shell
sudo mkdir -p /var/lib/scaleconnector-rest
sudo cp ./scaleconnector-rest/scaleconnector-rest.service /etc/systemd/system/scaleconnector-rest.service
sudo systemctl daemon-reload
sudo systemctl enable scaleconnector-rest
sudo systemctl start scaleconnector-rest
```

## Other useful commands

Emulating a serial port on linux:

```shell
sudo usermod -a -G dialout $(whoami)
sudo apt install socat
socat -d -d \
  pty,raw,nonblock,echo=0,iexten=0,link=/tmp/tty.fake.slave \
  pty,raw,nonblock,echo=0,iexten=0,link=/tmp/tty.fake.master
while :; do echo "B0+0000155 Kg054B" > /tmp/tty.fake.master; sleep 0.2; done
```

> Sometimes it's necessary to restart the session after adding new users to a group

Check physical serial port:

```shell
setserial -g /dev/ttyS*
```

Check logs for servers:

```shell
tail -f /var/log/syslog | grep scaleconnector
```
