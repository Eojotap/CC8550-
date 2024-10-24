package src.br.calebe.ticketmachine.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrocoTest {

    @Test
    void testTrocoComValorDois() {
        Troco troco = new Troco(2);
        assertEquals(1, troco.papeisMoeda[5].getQuantidade(), "Quantidade de notas de 2 está incorreta");
    }

    @Test
    void testTrocoSemValor() {
        Troco troco = new Troco(0);
        for (PapelMoeda papel : troco.papeisMoeda) {
            assertEquals(0, papel.getQuantidade(), "Nenhuma nota deveria ser retornada");
        }
    }

    @Test
    void testTrocoComVariasNotas() {
        Troco troco = new Troco(150);
        assertEquals(1, troco.papeisMoeda[0].getQuantidade(), "Quantidade de notas de 100 está incorreta");
        assertEquals(1, troco.papeisMoeda[1].getQuantidade(), "Quantidade de notas de 50 está incorreta");
    }

    @Test
    void testIteratorComUmaNota() {
        Troco troco = new Troco(100);
        Troco.TrocoIterator iterator = troco.new TrocoIterator(troco);

        assertTrue(iterator.hasNext(), "Deve haver uma nota de 100");
        PapelMoeda papelMoeda = iterator.next();
        assertEquals(100, papelMoeda.getValor(), "Valor da nota deve ser 100");
    }

    @Test
    void testIteratorSemNotas() {
        Troco troco = new Troco(0);
        Troco.TrocoIterator iterator = troco.new TrocoIterator(troco);

        assertFalse(iterator.hasNext(), "Não deve haver notas disponíveis");
    }
}
