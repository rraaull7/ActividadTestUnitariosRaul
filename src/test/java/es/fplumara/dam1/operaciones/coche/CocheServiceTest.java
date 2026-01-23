package es.fplumara.dam1.operaciones.coche;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CocheServiceTest {

    private CocheService cocheService = new CocheService(null);

    @ParameterizedTest
    @ValueSource(strings = {
            "1234ABC",
            "0000ZZZ",
            "9876QWE"
    })
    void testValidaMatriculaValida(String matricula) {
        assertTrue(cocheService.validaMatricula(matricula));
    }

    @ParameterizedTest
    @CsvSource({
            "123ABC, false",
            "12345ABC, false",
            "1234AB, false",
            "1234A1C, false",
            "'1234-ABC', false",
            "'1234 ABC', false",
            "1234abc, false"
    })
    void testValidaMatriculaInvalida(String matricula) {
        assertFalse(cocheService.validaMatricula(matricula));
    }
}
