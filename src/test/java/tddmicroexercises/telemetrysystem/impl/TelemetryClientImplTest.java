package tddmicroexercises.telemetrysystem.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tddmicroexercises.telemetrysystem.TelemetryConnection;
import tddmicroexercises.telemetrysystem.TelemetryDataProcessor;

public class TelemetryClientImplTest {
    @Mock
    private TelemetryConnection mockTelemetryConnection;
    @Mock
    private TelemetryDataProcessor mockTelemetryDataProcessor;
    @InjectMocks
    private TelemetryClientImpl telemetryClient;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testConnect() {
        String connectionString = "testConnectionString";
        telemetryClient.connect(connectionString);
        verify(mockTelemetryConnection).connect(connectionString);
    }

    @Test
    public void testDisconnect() {
        telemetryClient.disconnect();
        verify(mockTelemetryConnection).disconnect();
    }

    @Test
    public void testGetOnlineStatus() {

        when(mockTelemetryConnection.getOnlineStatus()).thenReturn(true);
        assertTrue(telemetryClient.getOnlineStatus());
        verify(mockTelemetryConnection).getOnlineStatus();
    }

    @Test
    public void testProcessData() {
        String testMessage = "testMessage";
        telemetryClient.processData(testMessage);
        verify(mockTelemetryDataProcessor).processData(testMessage);
    }

    @Test
    public void testReceiveData() {
        String testData = "testData";
        when(mockTelemetryDataProcessor.receiveData()).thenReturn(testData);
        assertEquals(testData, telemetryClient.receiveData());
        verify(mockTelemetryDataProcessor).receiveData();
    }
}
