package tddmicroexercises.telemetrysystem.impl;

import tddmicroexercises.telemetrysystem.TelemetryConnection;
import tddmicroexercises.telemetrysystem.TelemetryConnectionEventSimulator;

public class TelemetryConnectionImpl implements TelemetryConnection {

        private Boolean onlineStatus;
        private TelemetryConnectionEventSimulator telemetryConnectionEventSimulator;

        public TelemetryConnectionImpl(TelemetryConnectionEventSimulator telemetryConnectionEventSimulator) {
            this.telemetryConnectionEventSimulator= telemetryConnectionEventSimulator;
        }

        @Override
        public void connect(String telemetryServerConnectionString) {
            if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString))
            {
                throw new IllegalArgumentException();
            }
            boolean success=telemetryConnectionEventSimulator.simulateConnection().nextInt(10)<=8;
            onlineStatus=success;
        }

        @Override
        public void disconnect() {
            onlineStatus=false;
        }

        @Override
        public Boolean getOnlineStatus() {
            return onlineStatus;
        }
    }


