package tddmicroexercises.telemetrysystem;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tddmicroexercises.telemetrysystem.impl.TelemetryClientImpl;

import static org.mockito.Mockito.*;

public class TelemetryDiagnosticControlsTest

{
  @Mock
  private TelemetryClient telemetryClient;
     @InjectMocks
     private TelemetryDiagnosticControls telemetryDiagnosticControls;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void
    CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response()
            throws Exception {
        when(telemetryClient.getOnlineStatus()).thenReturn(true);
        when(telemetryClient.receiveData()).thenReturn("Status: OK");
        telemetryDiagnosticControls.checkTransmission();
        verify(telemetryClient).disconnect();
        verify(telemetryClient).processData(TelemetryClient.DIAGNOSTIC_MESSAGE);
        verify(telemetryClient).receiveData();
    }

}
