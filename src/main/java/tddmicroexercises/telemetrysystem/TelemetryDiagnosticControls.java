package tddmicroexercises.telemetrysystem;

import tddmicroexercises.telemetrysystem.impl.TelemetryClientImpl;

public class TelemetryDiagnosticControls
{
    private final String DiagnosticChannelConnectionString = "*111#";
    
    private final TelemetryClient telemetryClient;
    private final TelemetryDataProcessor telemetryDataProcessor;
    private final TelemetryConnection telemetryConnection;
    private String diagnosticInfo = "";

        public TelemetryDiagnosticControls(TelemetryConnection telemetryConnection,TelemetryDataProcessor telemetryDataProcessor)
        {
            this.telemetryConnection=telemetryConnection;
            this.telemetryDataProcessor=telemetryDataProcessor;
            telemetryClient = new TelemetryClientImpl(this.telemetryConnection,this.telemetryDataProcessor);
        }
        

        
        public void setDiagnosticInfo(String diagnosticInfo){
            this.diagnosticInfo = diagnosticInfo;
        }
 
        public void checkTransmission() throws Exception
        {
            diagnosticInfo = "";

            telemetryClient.disconnect();
    
            int retryLeft = 3;
            while (telemetryClient.getOnlineStatus() == false && retryLeft > 0)
            {
                telemetryClient.connect(DiagnosticChannelConnectionString);
                retryLeft -= 1;
            }
             
            if(telemetryClient.getOnlineStatus() == false)
            {
                throw new Exception("Unable to connect.");
            }
    
            telemetryClient.processData(TelemetryClient.DIAGNOSTIC_MESSAGE);
            diagnosticInfo = telemetryClient.receiveData();
    }
}
