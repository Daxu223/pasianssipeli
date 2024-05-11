package com.pasianssipeli.view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class OhjeFrame extends JDialog {

    public OhjeFrame(JFrame parent) {
        super(parent, "Ohjeet", false);

        JDialog dialog = new JDialog();
        dialog.setTitle("Ohjeet");
        dialog.setModal(true); // Make it modal if needed

        String preWrittenText = "<html>Tavoite:<br>Järjestä kaikki kortit nousevaan järjestykseen maan mukaan neljään peruskasaan.<br><br>Asettelu:<br>Jaa 7 kortin pilaria.<br>Käännä jokaisen pilarin ylimmäinen kortti näkyväksi.<br>Aseta loput kortit piilokasaksi alaspäin.<br><br>Pelikuvaus:<br>Rakenna laskevia sarjoja vuorottelevilla väreillä pilarissa.<br>Siirrä kortteja pilarin välillä paljastaaksesi piilokortteja.<br>Käytä piilokasaa lisätäksesi kortteja pilariin.<br><br>Voittaminen:<br>Voita siirtämällä kaikki kortit onnistuneesti peruskasoihin nousevassa järjestyksessä maan mukaan.</html>";

        JLabel textArea = new JLabel(preWrittenText);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // Älä näytä vertikaalista scrollauspalkkia
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Älä näytä horisontaalista scrollauspalkkia

        dialog.add(scrollPane);

        dialog.setSize(750, 350);

        // Keskitä dialogi näytön keskelle
        dialog.setLocationRelativeTo(null);

        dialog.setVisible(true);
    }
}