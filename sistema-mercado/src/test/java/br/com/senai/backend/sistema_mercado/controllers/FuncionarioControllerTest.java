import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import br.com.senai.backend.sistema_mercado.services.FuncionarioService;

package br.com.senai.backend.sistema_mercado.controllers;




@ExtendWith(MockitoExtension.class)
class FuncionarioControllerTest {

    @Mock
    private FuncionarioService funcionarioService;

    @InjectMocks
    private FuncionarioController funcionarioController;

    @Test
    void cadastrar_shouldReturnServiceValue() {
        String expected = "Funcionario cadastrado";
        when(funcionarioService.cadastrarFuncionario()).thenReturn(expected);

        String actual = funcionarioController.cadastrar();

        assertEquals(expected, actual);
        verify(funcionarioService, times(1)).cadastrarFuncionario();
    }

    @Test
    void cadastrar_shouldReturnNullWhenServiceReturnsNull() {
        when(funcionarioService.cadastrarFuncionario()).thenReturn(null);

        String actual = funcionarioController.cadastrar();

        assertEquals(null, actual);
        verify(funcionarioService, times(1)).cadastrarFuncionario();
    }
}