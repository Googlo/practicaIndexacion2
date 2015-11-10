/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *
 * @author moulay
 */
public class Index {
    private Integer nextDocumentId = 0;
    private Integer nextTermId = 0;
    
    HashMap<String, Integer> terminos = new HashMap();
    HashMap<String, Integer> documentos = new HashMap();
    HashMap<Integer, Float> idf = new HashMap();
    
    HashMap<Integer, PriorityQueue<Ocurrences>> indice = new HashMap();
    
    private List<Integer> getDocumentListFor(Integer tID) {
        return null;
    }
    
    private Integer getdID(String documentId) {
        Integer dID = documentos.get(documentId);
        if(dID == null) {
            dID = nextDocumentId;
            nextDocumentId++;
            documentos.put(documentId, dID);
        }
        return dID;
    }
    
    private Integer gettID(String termId) {
        Integer tID = terminos.get(termId);
        if(tID == null) {
            tID = nextTermId;
            nextTermId++;
            terminos.put(termId, tID);
        }
        return tID;
    }
    
    public Index(List<Document> documents) {
        for(Document d : documents) {
            Integer dID = getdID(d.getDocumentId());
            System.out.println("DOCUMENTO: " + d.getDocumentId() + " con dID: " + dID);
            StringTokenizer tokens = d.getTokens();
            
            HashMap<Integer, Integer> frecuencia = new HashMap();
            
            while(tokens.hasMoreTokens()) {
                String token = tokens.nextToken();
                //Devuelve el valor al que se asigna la clave especificada, 
                // o null si este mapa contiene ninguna asignación de la clave
                Integer tID = gettID(token);
                
                Integer veces = frecuencia.get(tID);
                if(veces == null) {
                    veces = 1;
                } else {
                    veces++;
                }

                frecuencia.put(tID, veces);
            }
            
            for(Entry<Integer, Integer> termino: frecuencia.entrySet()) {
                Integer tID = termino.getKey();
                Ocurrences ocurrencia = new Ocurrences(dID, termino.getValue());
                PriorityQueue<Ocurrences> ocurrencias = indice.get(tID);
                if(ocurrencias == null) {
                    ocurrencias = new PriorityQueue();
                }
                ocurrencias.add(ocurrencia);
                indice.put(tID, ocurrencias);
            }

        }
        
     /*   for(Entry<Integer, PriorityQueue<Ocurrences>> termino: indice.entrySet()) {
            Integer tID = termino.getKey();
            PriorityQueue<Ocurrences> ocurrencias = termino.getValue();
            System.out.println();
            System.out.println("TERMINO: " + tID);
            for(Ocurrences o : ocurrencias) {
                System.out.println("\tDOcumento: " + o.getdID() + " aparece " + o.getTf() + " veces");
            }
        }*/
    }
}
