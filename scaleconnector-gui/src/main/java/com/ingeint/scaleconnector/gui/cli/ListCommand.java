package com.ingeint.scaleconnector.gui.cli;

import jssc.SerialPortList;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Slf4j
@Command(name = "list", description = "Lists the serial ports available")
public class ListCommand implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        String[] portNames = SerialPortList.getPortNames();

        if (portNames.length > 0) {
            for (int i = 0; i < portNames.length; i++) {
                System.out.println(portNames[i]);
            }
        } else {
            System.out.println("Not available serial ports");
        }

        System.out.println();
        return 0;
    }
}
