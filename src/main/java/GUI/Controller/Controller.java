package GUI.Controller;

import Bussiness.DeliveryService;
import Data.Serialization;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public interface Controller {
    Object checkInput() throws Exception;

    class CloseAction extends AbstractAction {
        private JFrame mainFrame;

        public CloseAction(JFrame mainFrame) {
            super("Exit");
            putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            this.mainFrame = mainFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            confirmClosing();
        }

        public void confirmClosing() {
            int confirmed = JOptionPane.showConfirmDialog(mainFrame, "Are you sure you want to quit?", "Confirm quit", JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) {
                try {
                    Serialization.getInstance().exportData(Serialization.getInstance().importData());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        }
    }

}
