package com.ingeint.scaleconnector.gui.cli;

import com.ingeint.scaleconnector.gui.controller.ControllerViewSelectMode;
import com.ingeint.scaleconnector.gui.feature.SCUIFeature;
import com.ingeint.scaleconnector.gui.feature.SCUILocale;
import lombok.extern.slf4j.Slf4j;
import org.pushingpixels.substance.api.skin.SubstanceBusinessLookAndFeel;
import picocli.CommandLine.Command;

import javax.swing.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

@Slf4j
@Command(name = "gui", description = "Runs the user interface")
public class GuiCommand implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        try {
            SCUILocale.load(SCUIFeature.get("DEFAULT_LOCALE"));
        } catch (Exception e) {
            log.error("Error loading features");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading features", "Error", JOptionPane.ERROR_MESSAGE);
            return 1;
        }

        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);

        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new SubstanceBusinessLookAndFeel());
            } catch (Exception e) {
                log.error("Look and feel failed to initialize");
                e.printStackTrace();
            }
            new ControllerViewSelectMode();
        });

        CountDownLatch latch = new CountDownLatch(1);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> latch.countDown()));
        latch.await();

        return 0;
    }
}
