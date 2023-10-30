package tddmicroexercises.telemetrysystem.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tddmicroexercises.telemetrysystem.TelemetryConnectionEventSimulator;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TelemetryConnectionImplTest {
    @Mock
    private TelemetryConnectionEventSimulator mockEventSimulator;

    @InjectMocks
    private TelemetryConnectionImpl telemetryConnectionImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testConnectSuccess() {
        when(mockEventSimulator.simulateConnection()).thenReturn(new Random(42));
        telemetryConnectionImpl.connect("testConnectionString");
        assertTrue(telemetryConnectionImpl.getOnlineStatus());
        verify(mockEventSimulator).simulateConnection();
    }

    @Test
    public void testDisconnect() {

        telemetryConnectionImpl.disconnect();
        assertFalse(telemetryConnectionImpl.getOnlineStatus());
    }

    @Test
    public void testConnectWithNullOrEmptyConnectionString() {
        assertThrows(IllegalArgumentException.class, () -> telemetryConnectionImpl.connect(null));
        assertThrows(IllegalArgumentException.class, () -> telemetryConnectionImpl.connect(""));
    }

}
