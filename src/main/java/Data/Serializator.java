package Data;

import Bussiness.DeliveryService;

import java.io.*;

public class Serializator implements Serializable {
    FileOutputStream dataFile;
    FileInputStream inDataFile;
    ObjectOutputStream outStream;
    ObjectInputStream inStream;

    public void exportData(DeliveryService toExport) throws IOException {
        dataFile = new FileOutputStream("data.ser");
        outStream = new ObjectOutputStream(dataFile);

        outStream.writeObject(toExport);
        outStream.close();
        dataFile.close();
    }

    public DeliveryService importData() throws IOException, ClassNotFoundException {
        inDataFile = new FileInputStream("data.ser");
        inStream = new ObjectInputStream(inDataFile);

        DeliveryService deliveryService = (DeliveryService) inStream.readObject();
        inStream.close();
        inDataFile.close();

        return deliveryService;
    }
}
