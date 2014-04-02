/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.beastiebots.scouting.tournament.uploader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import javax.json.Json;
import javax.json.JsonReader;
import javax.swing.SwingWorker;
import org.beastiebots.scouting.gui.ScoutingServerUI;
import org.beastiebots.scouting.tournament.Tournament;
import org.roblybarger.ServiceDescription;
import org.roblybarger.ServiceResponder;

/**
 *
 * @author Jacob
 */
public class ScoutingServer extends SwingWorker<Void, String> {

    Tournament theTournament;
    ScoutingServerUI ui;

    public ScoutingServer(Tournament theTournament, ScoutingServerUI ui) {
        this.theTournament = theTournament;
        this.ui = ui;
    }

    @Override
    public Void doInBackground() throws Exception {
        ServerSocket serverSocket = null;
        String SERVICE_NAME = "FTCScoutingServer";
        String INSTANCE_NAME = "3785";

        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(
                    new InetSocketAddress(InetAddress.getLocalHost(),
                            0));    /*bind to any available port number*/

        } catch (IOException ioe) {
            System.err.println(
                    "Could not bind a server socket to a free port: " + ioe);
            System.exit(1);
        }

        /* Create a descriptor for the service you are providing. */
        ServiceDescription descriptor = new ServiceDescription();
        descriptor.setAddress(serverSocket.getInetAddress());
        descriptor.setPort(serverSocket.getLocalPort());
        descriptor.setInstanceName(INSTANCE_NAME);
        System.out.println("Service details: " + descriptor);

        /* Read special note for code you should add here */

        /*
         * Set up a responder and give it the descriptor (above)
         * we want to publish. Start the responder, which
         * works in its own thread.
         */
        ServiceResponder responder
                = new ServiceResponder(SERVICE_NAME);
        responder.setDescriptor(descriptor);
        responder.startResponder();

        /* Back to the usual routine of servicing requests */
        System.out.println(
                "Responder listening. Now taking connections...");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println(
                        "Connection from: " + socket.getInetAddress());
                OutputStreamWriter writer
                        = new OutputStreamWriter(socket.getOutputStream());
                writer.write(new Date().toString() + "\r\n");
                writer.flush();
                InputStreamReader reader
                        = new InputStreamReader(socket.getInputStream());
                BufferedReader bufferedReader
                        = new BufferedReader(reader);
                String line = bufferedReader.readLine();
                this.publish(line);
                socket.close();
            } catch (IOException ie) {
                System.err.println("Exception: " + ie);
            }
        }
    }

    @Override
    protected void process(List<String> tournaments) {
        String tournamentStr = tournaments.get(tournaments.size() - 1);

        JsonReader reader = Json.createReader(new StringReader(tournamentStr));

        boolean changed = theTournament.readJson(reader.readObject());
        if (changed) {
            try {
                Socket socket = new Socket("beastiebots.org", 8081);

                GZIPOutputStream gzipOut = new GZIPOutputStream(socket.getOutputStream());
                PrintStream output
                        = new PrintStream(gzipOut);
                output.println(theTournament.toJson().toString());
                output.flush();
                gzipOut.finish();
                socket.close();
            } catch (IOException ie) {
                System.err.println("Exception: " + ie);
            }
        }
        ui.updateUI();
    }

}
