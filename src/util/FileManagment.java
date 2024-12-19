package util;

import Repository.Implementations.ChequesImpl;
import model.Cheque;

import java.io.File;
import java.io.FileWriter;
import java.sql.Timestamp;

public class FileManagment {
    public static boolean generateReport(Cheque cheque){
        File file = new File(cheque.getFecha_emision() + "-procesamiento-cheques.txt");
        if (!file.exists()){
            try {
                System.out.println(file.createNewFile()? "Creando Archivo":"Archivo No Creado");
                try (FileWriter fileWriter = new FileWriter(file)){
                    String string = "-".repeat(50) + """
                            BANCO UNIÓN S.A
                            Cheque No: """ + cheque.getNumero_cheque() + """
                            Fecha: """ + cheque.getFecha_emision() + """
                            
                            PAGUESE A: """ + cheque.getBeneficiario() + """
                            LA SUMA DE: """ + cheque.getMonto_letras() + """
                            
                            Valor: """ + cheque.getMonto() + """
                            
                            FIRMA DIGITAL: """ + cheque.getFirma_digital() + """
                            """ + "-".repeat(50);
                    fileWriter.write(string);
                }
                return true;
            } catch (Exception e){
                System.out.println(e.getMessage());
                return false;
            }
        }else {
            return false;
        }
    }
}
