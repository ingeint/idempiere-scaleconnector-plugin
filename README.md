# iDempiere ScaleConnector Plugin

This project is an integration between iDempiere and digital scales with the aim of get the sensor measure from
iDempiere. ScaleConnector can be configured to sync with any device or sensor (temperature, humidity, pressure,
weighing, accountant, etc.)
that communicate through the RS-232 serial port. For mor
info [here](https://wiki.idempiere.org/en/Plugin:_Scale_Connector)

## Components

### ScaleConnector GUI

Add permissions:

```bash
sudo gpasswd -a $(whoami) dialout
sudo gpasswd -a $(whoami) uucp
sudo gpasswd -a $(whoami) lock
sudo gpasswd -a $(whoami) tty
```

Emulating a serial port on linux:

```bash
sudo apt install socat
socat -d -d \
  pty,raw,nonblock,echo=0,iexten=0,link=/tmp/tty.fake.slave \
  pty,raw,nonblock,echo=0,iexten=0,link=/tmp/tty.fake.master
while :; do echo "B0+0000155 Kg054B" > /tmp/tty.fake.master; sleep 0.1; done
```

Running the application:

```bash
./gradlew run
```

Then click on `TCP Server` > `Read Port`.

![](screenshots/server-mode.png)