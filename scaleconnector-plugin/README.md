# ScaleConnector Plugin

- Copyright: 2021 INGEINT <https://www.ingeint.com>
- Repository: https://github.com/ingeint/idempiere-scaleconnector-plugin
- License: GPL 2

## Description

This project is an integration between iDempiere and digital scales with the aim of get the sensor measure from
iDempiere. ScaleConnector can be configured to sync with any device or sensor (temperature, humidity, pressure,
weighing, accountant, etc.) that communicate through the RS-232 serial port.

## Components

- iDempiere Plugin [com.ingeint.scaleconnector](com.ingeint.scaleconnector)
- iDempiere Unit Test Fragment [com.ingeint.scaleconnector.test](com.ingeint.scaleconnector.test)
- iDempiere Target Platform [com.ingeint.scaleconnector.targetplatform](com.ingeint.scaleconnector.targetplatform)

## Prerequisites

- Java 11, commands `java` and `javac`.
- iDempiere 8.2.0
- Set `IDEMPIERE_REPOSITORY` env variable

## Features/Documentation

Official documentation [here](https://wiki.idempiere.org/en/Plugin:_Scale_Connector)

## Commands

Compile plugin and run tests:

```bash
./build
```

Use the parameter `debug` for debug mode example:

```bash
./build debug
```

To use `.\build.bat` for windows.
