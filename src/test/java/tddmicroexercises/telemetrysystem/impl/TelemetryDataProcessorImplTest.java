package tddmicroexercises.telemetrysystem.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tddmicroexercises.telemetrysystem.TelemetryConnectionEventSimulator;

import java.util.Random;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class TelemetryDataProcessorImplTest {
    @Mock
    private TelemetryConnectionEventSimulator telemetryConnectionEventSimulator;
    @InjectMocks
    private TelemetryDataProcessorImpl telemetryDataProcessor;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testProcessDataWithEmptyMessage() {
        TelemetryConnectionEventSimulator simulator = new TelemetryConnectionEventSimulatorImpl();
        TelemetryDataProcessorImpl dataProcessor = new TelemetryDataProcessorImpl(simulator);
        try {
           telemetryDataProcessor.processData("");
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testReceiveData() {
        when(telemetryConnectionEventSimulator.simulateConnection()).thenReturn(new Random(123));
        String receivedMessage = telemetryDataProcessor.receiveData();
        assertNotNull(receivedMessage);
        assertNotEquals("", receivedMessage);
    }

}
