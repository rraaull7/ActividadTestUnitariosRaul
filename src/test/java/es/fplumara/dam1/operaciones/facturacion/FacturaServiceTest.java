package es.fplumara.dam1.operaciones.facturacion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FacturaServiceTest {

    @Mock
    private Calculadora calc;

    @Test
    @DisplayName("totalConIva(100) devuelve 121 y llama sumar(100, 21) una vez")
    void testTotalConIva() {
        when(calc.sumar(100, 21)).thenReturn(121);

        FacturaService service = new FacturaService(calc);
        int resultado = service.totalConIva(100);

        assertEquals(121, resultado);

        verify(calc, times(1)).sumar(100, 21);
        verifyNoMoreInteractions(calc);
    }
}
