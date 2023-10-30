package tddmicroexercises.telemetrysystem.impl;

import tddmicroexercises.telemetrysystem.TelemetryClient;
import tddmicroexercises.telemetrysystem.TelemetryConnection;
import tddmicroexercises.telemetrysystem.TelemetryDataProcessor;

public class TelemetryClientImpl implements TelemetryClient {
   private final TelemetryConnection telemetryConnection;
   private final TelemetryDataProcessor telemetryDataProcessor;

   public TelemetryClientImpl(TelemetryConnection telemetryConnection, TelemetryDataProcessor telemetryDataProcessor){
       this.telemetryConnection = telemetryConnection;
       this.telemetryDataProcessor=telemetryDataProcessor;
   }
    @Override
    public void connect(String telemetryServerConnectionString) {
    telemetryConnection.connect(telemetryServerConnectionString);
    }

    @Override
    public void disconnect() {
   telemetryConnection.disconnect();
    }

    @Override
    public Boolean getOnlineStatus() {
        return telemetryConnection.getOnlineStatus();
    }

    @Override
    public void processData(String message) {
telemetryDataProcessor.processData(message);
    }

    @Override
    public String receiveData() {
       return telemetryDataProcessor.receiveData();
    }
}
