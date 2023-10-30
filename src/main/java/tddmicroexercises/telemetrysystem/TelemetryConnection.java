package tddmicroexercises.telemetrysystem;

import java.util.Random;

public interface TelemetryConnection {
    void connect(String telemetryServerConnectionString);
    void disconnect();
    Boolean getOnlineStatus();
}
