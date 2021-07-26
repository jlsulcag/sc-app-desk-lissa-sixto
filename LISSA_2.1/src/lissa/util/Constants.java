
package lissa.util;

import java.math.BigDecimal;

public class Constants {
    public static final String BOLETA = "Boleta";
    public static final String FACTURA = "Factura";
    public static final String BOLETA_ELECTRONICA = "BoletaElectronica";
    public static final String FACTURA_ELECTRONICA = "FacturaElectronica";
    public static final String ORDEN_SERVICIO = "OrdenServicio";
    public static final String BOLETA_FAR = "BoletaFar";
    public static final String FACTURA_FAR = "FacturaFar";
    public static final String FONDO_PREVISION = "FONDO PREVISION";
    public static final BigDecimal IGV = new BigDecimal("0.18");
    public static final BigDecimal CIEN_IGV = new BigDecimal("1.18");
    public static final int UNO = 1;
    public static final int CERO = 0;
    public static final int SUCCESS = 1;
    public static final int ERROR = -1;
    public static final String FAR_BOLETA_ELECTRONICA = "FarBoletaElectronica";
    public static final String FAR_FACTURA_ELECTRONICA = "FarBoletaElectronica";
    public static final String FAR_TICKET_BOLETA = "Far_TicketBoleta";
    public static final String FAR_TICKET_BOLETA_80MM = "FarTicketBoleta80mm";    
    
    
    public static final int ES_GENERICO = 1;
    public static final int NO_GENERICO = 0;
    
    public static final int BUSQ_X_PRODUCTO = 1;
    public static final int BUSQ_X_PRINCIPIO_ACTIVO = 2;
    public static final int BUSQ_X_ACCION_FARMACOLOGICA = 3;
    
    //Tipo Comprobante
    public static final String COMPROBANTE_TICKET_BOLETA = "TICKET BOLETA";
    
    public static final String ALMACEN_ALMACEN = "ALMACEN";
    public static final String ALMACEN_FARMACIA = "FARMACIA";

    /*Estados comprobantes*/
    public static final String ESTADO_COMPROBANTE_ACT = "ACT";
    public static final String ESTADO_COMPROBANTE_ANU = "ANU";
    
    //Variables OpenFact Demo
    /*
    public static final String openfactUrl = "http://openfactv2-openfact-development.apps.console.sistcoop.org:83/api";    
    public static final String tokenServerUrl = "http://keycloak-keycloak-sso-development.apps.console.sistcoop.org:83/auth/realms/ahren/protocol/openid-connect/token";
    public static final String refreshToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJGSjg2R2NGM2pUYk5MT2NvNE52WmtVQ0lVbWZZQ3FvcXRPUWVNZmJoTmxFIn0.eyJqdGkiOiJhZDEyMzIzNS0wYWEyLTQ2Y2QtYmVhZS00NDExYTU4M2EyZGQiLCJleHAiOjAsIm5iZiI6MCwiaWF0IjoxNTM3Mjg4NjQwLCJpc3MiOiJodHRwOi8va2V5Y2xvYWsta2V5Y2xvYWstc3NvLWRldmVsb3BtZW50LmFwcHMuY29uc29sZS5zaXN0Y29vcC5vcmc6ODMvYXV0aC9yZWFsbXMvYWhyZW4iLCJhdWQiOiJvcGVuZmFjdC13ZWItY29uc29sZSIsInN1YiI6IjdiNjdlM2VlLTRlOGYtNDhhYi05YWFhLTRkOWI1ZDIzMWE4NyIsInR5cCI6Ik9mZmxpbmUiLCJhenAiOiJvcGVuZmFjdC13ZWItY29uc29sZSIsIm5vbmNlIjoiYWMxMjQ0MmYtM2RlZC00OTkyLTgwMGItMGE3Yzg3NWE1YjAzIiwiYXV0aF90aW1lIjowLCJzZXNzaW9uX3N0YXRlIjoiZjQ2OWY2YjctOThiOC00YTkxLWJkMzQtNzhmNzRmY2M5ODI5IiwiY2xpZW50X3Nlc3Npb24iOiI1NDMyNzAyMS1kZTA5LTQ0OGItYjU5ZC00MTJkZTkyOTVjNDYiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJvcmdhbml6YXRpb24tdXNlciJdfSwicmVzb3VyY2VfYWNjZXNzIjp7Im9wZW5mYWN0Ijp7InJvbGVzIjpbInZpZXctZXZlbnRzIiwidmlldy1kb2N1bWVudHMiLCJtYW5hZ2UtZG9jdW1lbnRzIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbInZpZXctcHJvZmlsZSJdfX19.lmp19CCHVxwBX0GItszYDjD_1CyJHIUpSLzQ3me_vlzJ4-1nRzGy1eKDPGFzt08EJXNznVNEQEAOqV_C_ULUmyeaDNLqpvhS0MIVaC1G2gwriWTVYgokkbNfuHRJtXfawce7wzwCzmDZLlsv-k6BZeGHwNQAObZle20ToaMhEjw";
    public static final String RUC = "miempresa";
    */
    
    
    //Variables OpenFact Demo  version 2.0
    
    public static final String openfactUrl = "https://openfactv2-openfact.b9ad.pro-us-east-1.openshiftapps.com/api";    
    public static final String tokenServerUrl = "https://sso-sso.b9ad.pro-us-east-1.openshiftapps.com/auth/realms/innpath/protocol/openid-connect/token";
    public static final String refreshToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJjR1lKa0l3a3FMR1VJbkNzNzBhVFJndS1ua2dCZndOem9OQmVoeFZyNVpvIn0.eyJqdGkiOiIwNjRiNjQ5Mi0zMGFlLTRlYmEtYmI4ZC1iYTJlMWEyZGYyMDciLCJleHAiOjAsIm5iZiI6MCwiaWF0IjoxNTY3MDEzOTA5LCJpc3MiOiJodHRwczovL3Nzby1zc28uYjlhZC5wcm8tdXMtZWFzdC0xLm9wZW5zaGlmdGFwcHMuY29tL2F1dGgvcmVhbG1zL2lubnBhdGgiLCJhdWQiOiJvcGVuZmFjdC13ZWItY29uc29sZSIsInN1YiI6Ijc5NjUyMWE5LWY5YTEtNGQxNy1hNTYzLWY1YzM3YTczMDUwNyIsInR5cCI6Ik9mZmxpbmUiLCJhenAiOiJvcGVuZmFjdC13ZWItY29uc29sZSIsIm5vbmNlIjoiYjRlNzZmZTgtYTkxYS00Yjk5LThlMGYtNDMzOTE1NTU0YzhiIiwiYXV0aF90aW1lIjowLCJzZXNzaW9uX3N0YXRlIjoiZTg1MDQzYjctNzJmNC00M2E0LWFhMDItZmRiZDNmZTllZGU2IiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9yZ2FuaXphdGlvbi1tYW5hZ2VyIiwib2ZmbGluZV9hY2Nlc3MiLCJhZG1pbiIsIm9yZ2FuaXphdGlvbi11c2VyIiwidW1hX2F1dGhvcml6YXRpb24iLCJvcmdhbml6YXRpb24tYWNjb3VudGFudCJdfSwicmVzb3VyY2VfYWNjZXNzIjp7Im9wZW5mYWN0Ijp7InJvbGVzIjpbIm1hbmFnZS1ldmVudHMiLCJtYW5hZ2Utb3JnYW5pemF0aW9uIiwidmlldy1ldmVudHMiLCJ2aWV3LWRvY3VtZW50cyIsImNyZWF0ZS1vcmdhbml6YXRpb24iLCJtYW5hZ2UtZG9jdW1lbnRzIiwidmlldy1vcmdhbml6YXRpb24iXX0sImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwgb2ZmbGluZV9hY2Nlc3MifQ.QIqMsiSY5ePbIQ1t6xOUCIalK2kKpOyHebAduydyUJDb6nzII0cEr1U1QYikpBVzRAfA-c1T2zs4mZqMAVRFL1VRPdaUqX5gmoZT7Rt0QCRDtEU_Z4CIm-czPuJfuWEMRUYcpVQ82xBdczWdHaSIDZeTYAK5doIWQzKqF2WzP4ivqWTEDR1-kfCtUet4Nhu4yTimRTIR2PT2pT-lpd0R8eSciSJVWYkAKpLDvI52wQTFST0wLnZmXsv4juIbUKfEyISXWUX_dLVkdVMGf_bvQiKUOpdfAB6oiUw4zo0X3z-Ivs75uWXw1SsETYxOnmoZEaXUxridcrK425syV29vwg";
    public static final String RUC = "miempresa";
    
    
    
    //Variables OpenFact Produccion 
    /*    
    public static final String openfactUrl = "https://openfactv2-openfact.b9ad.pro-us-east-1.openshiftapps.com/api";
    public static final String tokenServerUrl = "https://sso-sso.b9ad.pro-us-east-1.openshiftapps.com/auth/realms/innpath/protocol/openid-connect/token";        
    public static final String refreshToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJjR1lKa0l3a3FMR1VJbkNzNzBhVFJndS1ua2dCZndOem9OQmVoeFZyNVpvIn0.eyJqdGkiOiJjNDNjYjBjYy05M2YyLTQ2ZWEtYWU4OS1iM2ZjYzVlZmRhZmYiLCJleHAiOjAsIm5iZiI6MCwiaWF0IjoxNTUxNDgwMDc3LCJpc3MiOiJodHRwczovL3Nzby1zc28uYjlhZC5wcm8tdXMtZWFzdC0xLm9wZW5zaGlmdGFwcHMuY29tL2F1dGgvcmVhbG1zL2lubnBhdGgiLCJhdWQiOiJvcGVuZmFjdC13ZWItY29uc29sZSIsInN1YiI6IjBmMDA3NTc2LWZhMzQtNGI4ZS05OWQ4LWUwODM5OTgwNDZiMSIsInR5cCI6Ik9mZmxpbmUiLCJhenAiOiJvcGVuZmFjdC13ZWItY29uc29sZSIsIm5vbmNlIjoiODY1NTdjYzctYjlhYi00MmI0LTg1ZjMtNWFjYjJiOGQwNTg0IiwiYXV0aF90aW1lIjowLCJzZXNzaW9uX3N0YXRlIjoiNTM5ZGRlZTMtYWRlZC00ZjdkLWFlMDQtMDg5ZGM4OWQwNWQ3IiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9yZ2FuaXphdGlvbi1tYW5hZ2VyIiwib2ZmbGluZV9hY2Nlc3MiLCJvcmdhbml6YXRpb24tdXNlciIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsib3BlbmZhY3QiOnsicm9sZXMiOlsibWFuYWdlLWV2ZW50cyIsIm1hbmFnZS1vcmdhbml6YXRpb24iLCJ2aWV3LWV2ZW50cyIsInZpZXctZG9jdW1lbnRzIiwibWFuYWdlLWRvY3VtZW50cyIsInZpZXctb3JnYW5pemF0aW9uIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6Im9wZW5pZCBwcm9maWxlIGVtYWlsIG9mZmxpbmVfYWNjZXNzIn0.R2sJHzO9gAuqXx3M1ay2krxUul5vOF3GU4ZxS1uzfoIaJoYvWrpuCL1_7p-7dBIxcaTWVvqLtvpOU-GUfmIZYvK9GFuRNiz7iXAoXNHEZX9wMNFvqmUeztAAYcD_VhQAM9C9PCatxMvfH4FZ4k91KAzu2dSn3EmjxeElLckhMRDsQ3qmwLTB7YQAJv7Iu_MbfDtPXx-Q2eK7ukM-3cjWwL2rDqAuj6D77IaDnvCBbHUEvYQviwbsiPP01F5iQ-2iNVU5ImBxTx4wo3Ju9oVyIyuFXcq8ubPOGlKeW4tXN8tVGd_NXbXbDCj66i-rVttVJ2G_B0LauKY6PnZ0nTgpqw";
    public static final String RUC = "20494436761";
    */
    /*Constants admin producto*/
    public static final int JIF_INVENTARIO_INICIAL = 3;
}
