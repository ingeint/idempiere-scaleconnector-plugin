package com.ingeint.scaleconnector.gui.cli;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Spec;

@Slf4j
@Command(
        name = "scaleconnector-gui",
        mixinStandardHelpOptions = true, version = "4.1.2",
        description = "Scale Connector GUI/CLI",
        synopsisSubcommandLabel = "COMMAND",
        subcommands = {GuiCommand.class, ReadCommand.class, ListCommand.class, ServerCommand.class}
)
public class ScaleConnectorGuiCommand implements Runnable {

    @Spec
    private CommandLine.Model.CommandSpec spec;

    @Override
    public void run() {
        throw new ParameterException(spec.commandLine(), "Missing required subcommand");
    }
}
