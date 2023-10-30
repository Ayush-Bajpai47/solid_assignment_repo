package tddmicroexercises.telemetrysystem;

import java.util.Random;

public interface TelemetryDataProcessor {
    void  processData(String message);
    String receiveData();
}
