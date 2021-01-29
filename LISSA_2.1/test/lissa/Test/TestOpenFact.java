package lissa.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openfact.client.OpenfactClientFactory;
import org.openfact.client.OrganizationClient;
import org.openfact.client.oauth.TokenManager;
import org.openfact.client.services.DocumentsService;
import org.openfact.client.services.representations.idm.DocumentRequestRepresentation;
import org.openfact.client.services.representations.idm.DocumentResponseRepresentation;
import org.openfact.client.services.representations.idm.LineRepresentation;

public class TestOpenFact {

    public static void main(String[] args) {
        String openfactUrl = "http://openfactv2-openfact-development.apps.console.sistcoop.org:83/api";
        String tokenServerUrl = "http://keycloak-keycloak-sso-development.apps.console.sistcoop.org:83/auth/realms/ahren/protocol/openid-connect/token";
        String refreshToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJGSjg2R2NGM2pUYk5MT2NvNE52WmtVQ0lVbWZZQ3FvcXRPUWVNZmJoTmxFIn0.eyJqdGkiOiJhZDEyMzIzNS0wYWEyLTQ2Y2QtYmVhZS00NDExYTU4M2EyZGQiLCJleHAiOjAsIm5iZiI6MCwiaWF0IjoxNTM3Mjg4NjQwLCJpc3MiOiJodHRwOi8va2V5Y2xvYWsta2V5Y2xvYWstc3NvLWRldmVsb3BtZW50LmFwcHMuY29uc29sZS5zaXN0Y29vcC5vcmc6ODMvYXV0aC9yZWFsbXMvYWhyZW4iLCJhdWQiOiJvcGVuZmFjdC13ZWItY29uc29sZSIsInN1YiI6IjdiNjdlM2VlLTRlOGYtNDhhYi05YWFhLTRkOWI1ZDIzMWE4NyIsInR5cCI6Ik9mZmxpbmUiLCJhenAiOiJvcGVuZmFjdC13ZWItY29uc29sZSIsIm5vbmNlIjoiYWMxMjQ0MmYtM2RlZC00OTkyLTgwMGItMGE3Yzg3NWE1YjAzIiwiYXV0aF90aW1lIjowLCJzZXNzaW9uX3N0YXRlIjoiZjQ2OWY2YjctOThiOC00YTkxLWJkMzQtNzhmNzRmY2M5ODI5IiwiY2xpZW50X3Nlc3Npb24iOiI1NDMyNzAyMS1kZTA5LTQ0OGItYjU5ZC00MTJkZTkyOTVjNDYiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJvcmdhbml6YXRpb24tdXNlciJdfSwicmVzb3VyY2VfYWNjZXNzIjp7Im9wZW5mYWN0Ijp7InJvbGVzIjpbInZpZXctZXZlbnRzIiwidmlldy1kb2N1bWVudHMiLCJtYW5hZ2UtZG9jdW1lbnRzIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbInZpZXctcHJvZmlsZSJdfX19.lmp19CCHVxwBX0GItszYDjD_1CyJHIUpSLzQ3me_vlzJ4-1nRzGy1eKDPGFzt08EJXNznVNEQEAOqV_C_ULUmyeaDNLqpvhS0MIVaC1G2gwriWTVYgokkbNfuHRJtXfawce7wzwCzmDZLlsv-k6BZeGHwNQAObZle20ToaMhEjw";

//        String openfactUrl = "http://openfactv2-openfact-development.apps.console.sistcoop.org:83/api";
//        String tokenServerUrl = "http://keycloak-keycloak-sso-development.apps.console.sistcoop.org:83/auth/realms/ahren/protocol/openid-connect/token";
//        String refreshToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJGSjg2R2NGM2pUYk5MT2NvNE52WmtVQ0lVbWZZQ3FvcXRPUWVNZmJoTmxFIn0.eyJqdGkiOiJhZDEyMzIzNS0wYWEyLTQ2Y2QtYmVhZS00NDExYTU4M2EyZGQiLCJleHAiOjAsIm5iZiI6MCwiaWF0IjoxNTM3Mjg4NjQwLCJpc3MiOiJodHRwOi8va2V5Y2xvYWsta2V5Y2xvYWstc3NvLWRldmVsb3BtZW50LmFwcHMuY29uc29sZS5zaXN0Y29vcC5vcmc6ODMvYXV0aC9yZWFsbXMvYWhyZW4iLCJhdWQiOiJvcGVuZmFjdC13ZWItY29uc29sZSIsInN1YiI6IjdiNjdlM2VlLTRlOGYtNDhhYi05YWFhLTRkOWI1ZDIzMWE4NyIsInR5cCI6Ik9mZmxpbmUiLCJhenAiOiJvcGVuZmFjdC13ZWItY29uc29sZSIsIm5vbmNlIjoiYWMxMjQ0MmYtM2RlZC00OTkyLTgwMGItMGE3Yzg3NWE1YjAzIiwiYXV0aF90aW1lIjowLCJzZXNzaW9uX3N0YXRlIjoiZjQ2OWY2YjctOThiOC00YTkxLWJkMzQtNzhmNzRmY2M5ODI5IiwiY2xpZW50X3Nlc3Npb24iOiI1NDMyNzAyMS1kZTA5LTQ0OGItYjU5ZC00MTJkZTkyOTVjNDYiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJvcmdhbml6YXRpb24tdXNlciJdfSwicmVzb3VyY2VfYWNjZXNzIjp7Im9wZW5mYWN0Ijp7InJvbGVzIjpbInZpZXctZXZlbnRzIiwidmlldy1kb2N1bWVudHMiLCJtYW5hZ2UtZG9jdW1lbnRzIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbInZpZXctcHJvZmlsZSJdfX19.lmp19CCHVxwBX0GItszYDjD_1CyJHIUpSLzQ3me_vlzJ4-1nRzGy1eKDPGFzt08EJXNznVNEQEAOqV_C_ULUmyeaDNLqpvhS0MIVaC1G2gwriWTVYgokkbNfuHRJtXfawce7wzwCzmDZLlsv-k6BZeGHwNQAObZle20ToaMhEjw";

        TokenManager tokenManager = OpenfactClientFactory.getTokenManager("openfact-web-console", tokenServerUrl, refreshToken);
        DocumentsService service = OpenfactClientFactory.getDocumentsService(openfactUrl, tokenManager);
        OrganizationClient client = new OrganizationClient("miempresa", service);

        DocumentResponseRepresentation invoice1 = client.getDocumentByIdAsEntity("f4788082-2b04-4129-9d26-d17675715568");
        DocumentResponseRepresentation invoice2 = client.createInvoiceAndParseAsEntity(getInvoice(), true);

        System.out.println(invoice1.getDocumentId());
        System.out.println(invoice2.getDocumentId());

    }

    // Crear factura boleta
    public static DocumentRequestRepresentation getInvoice() {
        DocumentRequestRepresentation invoice = new DocumentRequestRepresentation();

        invoice.setFechaDeEmision(new Date());

        invoice.setTipo("01"); // Tipo de Documento (Boleta/factura)
        invoice.setEntidadDenominacion("Juan Perez"); // Nombre del cliente
        invoice.setEntidadEmail("jlsulcag@gmail.com"); // Email del cliente
        invoice.setEntidadNumeroDeDocumento("20129258323"); // Numero de documento del cliente (RUC/DNI)
        invoice.setEntidadTipoDeDocumento("6"); // Tipo de Documento del cliente (RUC/DNI)
        invoice.setEnviarAutomaticamenteASunat(true);
        invoice.setEnviarAutomaticamenteAlCliente(true);
        invoice.setIgv(new BigDecimal(18)); // IGV Aplicado a la operacion expresada en porcentaje 18%
        invoice.setMoneda("PEN"); // Moneda nacional
        invoice.setObservaciones("Mis observaciones");

        invoice.setOperacionGratuita(false); // Si la operacion es gratuita
        invoice.setTotalGratuita(BigDecimal.ZERO);

        invoice.setTotalGravada(new BigDecimal(120_100));
        invoice.setTotalExonerada(BigDecimal.ZERO);
        invoice.setTotalInafecta(BigDecimal.ZERO);

        invoice.setTotal(new BigDecimal(141_718));
        invoice.setTotalIgv(new BigDecimal(21_618));
        invoice.setTotalOtrosCargos(BigDecimal.ZERO); // Otros cargos aplicados
        invoice.setDescuentoGlobal(BigDecimal.ZERO); // Descuentos aplicados

        // Detalle de la factura
        List<LineRepresentation> lines = new ArrayList<>();
        LineRepresentation line1 = new LineRepresentation();
        LineRepresentation line2 = new LineRepresentation();
        lines.add(line1);
        lines.add(line2);

        line1.setCantidad(new BigDecimal(2));
        line1.setDescripcion("Carro Toyota ultimo modelo");
        line1.setTipoDeIgv("10"); // Codigo de operacion (Gravado - Operacion Onerosa)
        line1.setValorUnitario(new BigDecimal(60_000)); // Precio unitario sin igv
        line1.setIgv(new BigDecimal(21_600)); // Igv aplicado al item
        line1.setPrecioUnitario(new BigDecimal(70_800)); // Precio unitario con igv
        line1.setSubtotal(new BigDecimal(120_000)); // Subtotal sin igv
        line1.setTotal(new BigDecimal(141_600)); // Subtotal con igv

        line2.setCantidad(new BigDecimal(1));
        line2.setDescripcion("Llanta doble filo original");
        line2.setTipoDeIgv("10"); // Codigo de operacion (Gravado - Operacion Onerosa)
        line2.setValorUnitario(new BigDecimal(100)); // Precio unitario sin igv
        line2.setIgv(new BigDecimal(18)); // Igv aplicado al item
        line2.setPrecioUnitario(new BigDecimal(118)); // Precio unitario con igv
        line2.setSubtotal(new BigDecimal(100)); // Subtotal sin igv
        line2.setTotal(new BigDecimal(118)); // Subtotal con igv

        // Return result
        invoice.setDetalle(lines);
        return invoice;
    }

}
