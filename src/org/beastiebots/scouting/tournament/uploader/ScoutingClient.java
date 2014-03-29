/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.beastiebots.scouting.tournament.uploader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.file.Path;
import java.util.Vector;
import javax.swing.SwingWorker;
import org.roblybarger.ServiceBrowser;
import org.roblybarger.ServiceBrowserListener;
import org.roblybarger.ServiceDescription;

/**
 *
 * @author Jacob
 */
public class ScoutingClient extends SwingWorker<Boolean, Void> implements ServiceBrowserListener {

    public static final String SERVICE_NAME = "FTCScoutingServer";

    ServiceBrowser browser;
    Vector<ServiceDescription> descriptors;

    private String tournament;
    private Path outputDir;

    public ScoutingClient(String tournament, Path outputDir) {
        this.tournament = tournament;
        this.outputDir = outputDir;
    }

    @Override
    public Boolean doInBackground() throws Exception {
        if (outputDir != null) {
            File outputFile = new File(outputDir.toFile(), "scouting" + File.separator + "3785" + File.separator + "data.json");

            outputFile.getParentFile().mkdirs();

            FileOutputStream fileOut = new FileOutputStream(outputFile);
            PrintStream fileOutput = new PrintStream(fileOut);

            fileOutput.print(tournament);
            fileOutput.close();
        }

        descriptors = new Vector<ServiceDescription>();

        /* first browse for any 'timeDemo' instance */
        browser = new ServiceBrowser();
        browser.addServiceBrowserListener(this);
        browser.setServiceName(SERVICE_NAME);
        browser.startListener();
        browser.startLookup();
        System.out.println(
                "Browser started. Will search for 2 secs.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
            // ignore
        }
        browser.stopLookup();
        browser.stopListener();

        /* now if the browser found any matches, we'll
         * print out the complete list, but only connect
         * to the first one.
         */
        if (descriptors.size() > 0) {

            System.out.println("\n---SCOUTING SERVERS---");
            for (ServiceDescription descriptor : descriptors) {
                System.out.println(descriptor.toString());
            }

            System.out.println("\n---FIRST SERVER'S TIME IS---");
            ServiceDescription descriptor = descriptors.get(0);
            try {
                Socket socket = new Socket(descriptor.getAddress(),
                        descriptor.getPort());
                InputStreamReader reader
                        = new InputStreamReader(socket.getInputStream());
                BufferedReader bufferedReader
                        = new BufferedReader(reader);
                PrintStream output
                        = new PrintStream(socket.getOutputStream());
                String line = bufferedReader.readLine();
                System.out.println(line);
                output.println(tournament);
                output.flush();
                socket.close();
            } catch (IOException ie) {
                System.err.println("Exception: " + ie);
                System.exit(1);
            }
            return true;
        } else {
            System.out.println("\n---NO TIME SERVERS FOUND---");
            return false;
        }

    }

    @Override
    public void serviceReply(ServiceDescription descriptor) {
        int pos = descriptors.indexOf(descriptor);
        if (pos > -1) {
            descriptors.removeElementAt(pos);
        }
        descriptors.add(descriptor);
    }
}
