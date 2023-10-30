package tddmicroexercises.telemetrysystem.impl;

import tddmicroexercises.telemetrysystem.TelemetryConnection;
import tddmicroexercises.telemetrysystem.TelemetryConnectionEventSimulator;

import java.util.Random;

public class TelemetryConnectionEventSimulatorImpl implements TelemetryConnectionEventSimulator {
         @Override
         public Random simulateConnection() {
        return new Random(42);
    }

     }
