package tddmicroexercises.telemetrysystem.impl;

import tddmicroexercises.telemetrysystem.TelemetryConnectionEventSimulator;
import tddmicroexercises.telemetrysystem.TelemetryDataProcessor;

public class TelemetryDataProcessorImpl implements TelemetryDataProcessor {
    private static final String DIAGNOSTIC_MESSAGE = "AT#UD";
    private  String diagnosticMessageResult;

    private final TelemetryConnectionEventSimulator telemetryConnectionEventSimulator;

    public TelemetryDataProcessorImpl( TelemetryConnectionEventSimulator telemetryConnectionEventSimulator) {
        this.telemetryConnectionEventSimulator = telemetryConnectionEventSimulator;
    }
    @Override
    public void processData(String message) {
        if (message == null || "".equals(message))
        {
            throw new IllegalArgumentException();
        }

        if (message == DIAGNOSTIC_MESSAGE)
        {
            // simulate a status report
            diagnosticMessageResult =
                    "LAST TX rate................ 100 MBPS\r\n"
                            + "HIGHEST TX rate............. 100 MBPS\r\n"
                            + "LAST RX rate................ 100 MBPS\r\n"
                            + "HIGHEST RX rate............. 100 MBPS\r\n"
                            + "BIT RATE.................... 100000000\r\n"
                            + "WORD LEN.................... 16\r\n"
                            + "WORD/FRAME.................. 511\r\n"
                            + "BITS/FRAME.................. 8192\r\n"
                            + "MODULATION TYPE............. PCM/FM\r\n"
                            + "TX Digital Los.............. 0.75\r\n"
                            + "RX Digital Los.............. 0.10\r\n"
                            + "BEP Test.................... -5\r\n"
                            + "Local Rtrn Count............ 00\r\n"
                            + "Remote Rtrn Count........... 00";

            return;
        }

        // here should go the real Send operation (not needed for this exercise)
    }

    @Override
    public String receiveData() {
        String message;

        if (diagnosticMessageResult == null || "".equals(diagnosticMessageResult))
        {
            // simulate a received message (just for illustration - not needed for this exercise)
            message = "";
            int messageLength = telemetryConnectionEventSimulator.simulateConnection().nextInt(50) + 60;
            for(int i = messageLength; i >=0; --i)
            {
                message += (char)telemetryConnectionEventSimulator.simulateConnection().nextInt(40) + 86;
            }

        }
        else
        {
            message = diagnosticMessageResult;
            diagnosticMessageResult = "";
        }

        return message;
    }
}
