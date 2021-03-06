package pl.waw.sgh.bank;

import pl.waw.sgh.bank.exceptions.BankException;
import pl.waw.sgh.bank.exceptions.BrakKontaException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    private Integer ostKlientId = 0;

    private Integer ostKontoId = 0;

    private List<Klient> listaKlient = new ArrayList<>();

    private List<Konto> listaKont = new ArrayList<>();

    public Klient stworzKlienta(String imie, String nazwisko, String email) {
        Klient kl = new Klient(ostKlientId++,imie,nazwisko,email);
        listaKlient.add(kl);
        return kl;
    }

    public Konto stworzKonto(boolean czyRor, String waluta, Klient klient) {
        Konto konto = czyRor ?
                new KontoRor(ostKontoId++, waluta, new BigDecimal(0), klient)
                :
                new KontoOszcz(ostKontoId++, waluta, new BigDecimal(0), klient);
        listaKont.add(konto);
        return konto;
    }

    public Konto znajdzKonto(Integer kontoId) throws BrakKontaException {
        for (Konto k : listaKont) {
            if (kontoId.equals(k.getKontoId())) return k;
        }
        //return null;
        throw new BrakKontaException("Konto o nr " + kontoId + " nie istnieje!");
    }

    public void przelew(Integer kontoZrodloweId, Integer kontoCelId, BigDecimal kwota) {
        //TODO Uzupełnić
    }

    @Override
    public String toString() {
        return "Bank{" +
                "ostKlientId=" + ostKlientId +
                ", ostKontoId=" + ostKontoId +
                "\n, listaKlient=" + listaKlient +
                "\n, listaKont=" + listaKont +
                '}';
    }
}
